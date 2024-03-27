package org.zs.forty.service.impl;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.common.utils.JwtUtil;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.UserMapper;
import org.zs.forty.model.dto.SignupDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.User;
import org.zs.forty.model.vo.UserVO;
import org.zs.forty.service.AuthService;
import org.zs.forty.service.MailService;

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
public class AuthServiceImpl implements AuthService {
  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;
  private final MailService mailService;
  private final UserMapper userMapper;
  private final MainMapper mainMapper;
  private final JwtUtil jwtUtil;
  
  @Override public String login(String email, String password) {
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
    return jwtUtil.createToken(claims);
  }
  
  @Override public UserVO register(SignupDTO signupDTO) {
    User user = userMapper.selectByUsername(signupDTO.getUsername());
    if (user == null) {
      signupDTO.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
      UserDTO userDTO = mainMapper.Signup2DTO(signupDTO);
      return mainMapper.user2VO(userMapper.selectById(userMapper.insert(userDTO)));
    } else {
      throw new RuntimeException("用户名已存在");
    }
  }
  
  @Override public Boolean logout() {
    return null;
  }
}