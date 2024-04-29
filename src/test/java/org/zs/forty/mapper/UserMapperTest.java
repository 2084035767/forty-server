package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.zs.forty.model.dto.SignupDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.User;
import org.zs.forty.model.vo.LoginUserVO;

import java.util.List;

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
    // User user = userMapper.selectById(1L);
    System.out.println(passwordEncoder.encode("Zs555666"));
  }
  
  @Test
  void selectByUsername() {
    User user1 = userMapper.selectByUsername("2452730037");
    System.out.println(user1);
    assert user1 != null;
  }
  
  @Test
  void selectByEmail() {
    LoginUserVO user1 = userMapper.selectLoginUser("2084035767@qq.com");
    System.out.println(user1);
    assert user1 != null;
  }
  
  @Test
  void selectMenuByUsername() {
    User user1 = userMapper.selectRoleByEmail("2452730037@qq.com");
    System.out.println(user1);
  }
  
  @Test
  void selectList() {
    List<User> users = userMapper.selectList();
    assert !users.isEmpty();
  }
  
  @Test
  void deleteById() {
    userMapper.deleteById(4L);
  }
  
  @Test
  void updateById() {
    userMapper.updateById(
        UserDTO.builder()
            .id(2L)
            .password(passwordEncoder.encode("Xx123456"))
            .build());
  }
  
  @Test
  @Transactional
  void insert() {
    userMapper.insert(
        SignupDTO.builder()
            .nickname("hao")
            .email("555")
            .username("sss")
            .password(passwordEncoder.encode("566"))
            .build());
    
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