package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.zs.forty.model.entity.User;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/
@SpringBootTest
class UserMapperTest {
  
  @Resource
  private UserMapper userMapper;
  @Resource
  private PasswordEncoder passwordEncoder;
  
  @Test
  void selectById() {
    User user = userMapper.selectById(1L);
    System.out.println(passwordEncoder.encode(user.getPassword()));
  }
  
  @Test
  void selectByUsername() {
    User user1 = userMapper.selectByUsername("user1");
    System.out.println(user1);
    assert user1 != null;
  }
  
  @Test
  void selectMenuByUsername() {
    User user1 = userMapper.selectRoleByEmail("user1");
    System.out.println(user1);
  }
  
  @Test
  void selectList() {
    List<User> users = userMapper.selectList();
    assert !users.isEmpty();
  }
  
  @Test
  void deleteById() {
  }
  
  @Test
  void updateById() {
  }
  
  @Test
  void insert() {
  }
}