package org.zs.forty.common.utils;

import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/
@SpringBootTest
class JwtUtilTest {
  @Resource
  private JwtUtil jwtUtil;
  
  @Test
  void createToken() {
    HashMap<String, Object> hashMap = new HashMap<>();
    hashMap.put("username", "zs");
    String token = jwtUtil.createToken(hashMap);
    System.out.println(token);
  }
  
  @Test
  void parseToken() {
    // LocalDateTime token = jwtUtil.getExpirationLocalDateTimeFromToken(
    //     "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InpzIiwiZXhwIjoxNzExMDEwODg3fQ.r-I3JFRzOKZnskoNb_1tOq0kTdQjcJcSxQ4IVHitez8");
    // System.out.println(token);
    // Map<String, Object> map = jwtUtil.parseToken(
    //     "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InpzIiwiZXhwIjoxNzExMDI1NTUwfQ.oot1ix8mY-78ZIQ6WmmUDFsL0L3KumQNDItcHy61g7o");
    // map.forEach((k, v) -> System.out.println(k + " : " + v));
  }
  
  @Test
  void validateToken() {
  }
  
  @Test
  void parseClaims() {
    Claims claims = jwtUtil.parseClaims(
        "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InpzIiwiaWF0IjoxNzExMDEyMjY4LCJleHAiOjE3MTEwMjY2Njh9.wLonxKIY3ksDguRoHvQO_DeoBorJY2iPcJWa176pxeo");
    System.out.println(claims.getExpiration());
  }
}