package org.zs.forty.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.User;
import org.zs.forty.model.vo.UserVO;
import org.zs.forty.service.AuthService;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/21
 * @Description:
 **/
@Slf4j
@Service
@MappingIgnore
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final UserMapper userMapper;
  private final MainMapper mainMapper;
  private final JwtUtil jwtUtil;
  
  @Override public String login(String username, String password) {
    UsernamePasswordAuthenticationToken auth =
        new UsernamePasswordAuthenticationToken(username, password);
    Authentication authentication;
    
    try {
      authentication = authenticationManager.authenticate(auth);
    } catch (AuthenticationException e) {
      throw new UsernameNotFoundException("用户名或密码错误");
    }
    Map<String, Object> claims = getClaims(authentication);
    return jwtUtil.createToken(claims);
  }
  
  @Override public UserVO register(UserDTO userDTO) {
    User user = userMapper.selectByUsername(userDTO.getUsername());
    if (Optional.ofNullable(user).isEmpty()) {
      userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
      return mainMapper.user2VO(userMapper.selectById(userMapper.insert(userDTO)));
    }
    return null;
  }
  
  @Override public Boolean logout() {
    return null;
  }
  
  private static Map<String, Object> getClaims(Authentication authentication) {
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    Map<String, Object> claims = new HashMap<>();
    claims.put("username", userDetails.getUsername());
    return claims;
  }
}