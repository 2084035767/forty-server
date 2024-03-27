package org.zs.forty.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.User;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/14
 * @description: UserMapper
 **/

@Mapper
public interface UserMapper {
  
  User selectById(Long id);
  
  User selectByUsername(String username);
  
  User selectRoleByEmail(String email);
  
  List<User> selectList();
  
  int deleteById(Long id);
  
  int updateById(UserDTO userDTO, Long id);
  
  Long insert(UserDTO userDTO);
}