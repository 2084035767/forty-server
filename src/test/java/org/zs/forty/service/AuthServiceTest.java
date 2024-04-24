package org.zs.forty.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuthServiceTest {
  @Resource
  AuthService authService;
  
  @Test
  void login() {
    // String token = authService.login("1452730037@qq.com", "123456");
    // System.out.println(token);
  }
  
  @Test
  void register() {
  }
  
  @Test
  void logout() {
  }
}