package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.zs.forty.common.utils.AmqpUtil;
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
  private MainMapper mainMapper;
  @Resource
  private AmqpUtil amqpUtil;
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
  @Transactional
  void insert() {
    // SignupDTO signupDTO =
    //     SignupDTO.builder()
    //         .username("user1")
    //         .nickname("老刘")
    //         .password("123456")
    //         .email("2084035767@qq.com")
    //         .build();
    // signupDTO.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
    // UserDTO userDTO = mainMapper.Signup2DTO(signupDTO);
    // UserVO userVO = mainMapper.user2VO(userMapper.selectById(userMapper.insert(userDTO)));
    // amqpUtil.emailSend(mainMapper.email2DTO(signupDTO));
    // System.out.println(userVO);
    
    // UserDTO userDTO = UserDTO.builder()
    //     .username("user144242")
    //     .nickname("老刘")
    //     .password(passwordEncoder.encode("123456")) // 加密
    //     .email("2084035767@qq.com")
    //     .build();
    // userMapper.insert(userDTO);
  }
}