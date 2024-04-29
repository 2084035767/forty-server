package org.zs.forty.service.impl;

import cn.hutool.core.util.RandomUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.common.utils.AmqpUtil;
import org.zs.forty.common.utils.JwtUtil;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.UserMapper;
import org.zs.forty.model.dto.ForgetDTO;
import org.zs.forty.model.dto.SignupDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.User;
import org.zs.forty.model.vo.LoginUserVO;
import org.zs.forty.model.vo.UserVO;
import org.zs.forty.service.AuthService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/
@Slf4j
@Service
@MappingIgnore
@RequiredArgsConstructor
@CacheConfig(cacheNames = "AuthService")
public class AuthServiceImpl implements AuthService {
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;
  private final AmqpUtil amqpUtil;
  private final UserMapper userMapper;
  private final MainMapper mainMapper;
  private final JwtUtil jwtUtil;
  private String userCode = null;
  
  @Cacheable(key = "#email")
  @Override public LoginUserVO login(String email, String password) {
    LoginUserVO loginUser = userMapper.selectLoginUser(email);
    UsernamePasswordAuthenticationToken auth =
        new UsernamePasswordAuthenticationToken(email, password);
    Authentication authentication;
    try {
      authentication = authenticationManager.authenticate(auth);
    } catch (AuthenticationException e) {
      throw new UsernameNotFoundException("邮箱或密码错误");
    }
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    Map<String, Object> claims = new HashMap<>();
    claims.put("email", userDetails.getUsername());
    loginUser.setToken(jwtUtil.createToken(claims));
    return loginUser;
  }
  
  @Transactional
  @Override
  @Cacheable(key = "#signupDTO.id")
  public UserVO register(SignupDTO signupDTO) {
    User user = userMapper.selectByEmail(signupDTO.getEmail());
    if (Objects.isNull(user)) {
      signupDTO.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
      userMapper.insert(signupDTO);
      UserVO userVO = mainMapper.user2VO(userMapper.selectById(signupDTO.getId()));
      log.info("注册成功{}", userVO);
      amqpUtil.emailSend(mainMapper.email2DTO(signupDTO));
      return userVO;
    } else {
      throw new RuntimeException("用户名已存在");
    }
  }
  
  @Override public Boolean logout() {
    return null;
  }
  
  @Transactional
  @Override public Boolean getUserCode(String email) {
    try {
      User user = userMapper.selectByEmail(email);
      Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
      String code = RandomUtil.randomNumbers(6);
      amqpUtil.codeEmailSend(email, code);
      userCode = code;
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
  @Override public Boolean forget(ForgetDTO forgetDTO) {
    User user = userMapper.selectByEmail(forgetDTO.getEmail());
    Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
    if (userCode.equals(forgetDTO.getCode())) {
      user.setPassword(passwordEncoder.encode(forgetDTO.getPassword()));
      UserDTO userDTO = mainMapper.user2DTO(user);
      userMapper.updateById(userDTO);
      return userMapper.updateById(userDTO) > 0;
    } else {
      return false;
    }
  }
}