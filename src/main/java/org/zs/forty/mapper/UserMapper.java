package org.zs.forty.mapper;

import org.zs.forty.model.dto.SignupDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.User;
import org.zs.forty.model.vo.LoginUserVO;

import java.util.List;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/14
 * @description: UserMapper
 **/

public interface UserMapper {
  
  User selectById(Long id);
  
  User selectByUsername(String username);
  
  User selectByEmail(String email);
  
  LoginUserVO selectLoginUser(String email);
  
  User selectRoleByEmail(String email);
  
  List<User> selectList();
  
  // todo；条件查询
  // List<User> selectListByCondition(UserDTO userDTO);
  
  Long insert(SignupDTO signupDTO);
  
  int updateById(UserDTO userDTO);
  
  int updateByEmail(UserDTO userDTO);
  
  int deleteById(Long id);
//  List<User> selectOrderByUser(Long id);
}