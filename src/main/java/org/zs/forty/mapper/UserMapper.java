package org.zs.forty.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.entity.User;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/1/14
 * @Description: UserMapper
 **/

@Mapper
public interface UserMapper {
  
  User selectById(Long id);
  
  User selectByUsername(String username);
  
  User selectRoleByUsername(@Param("username") String username);
  
  List<User> selectList();
  
  int deleteById(Long id);
  
  int updateById(UserDTO userDTO, Long id);
  
  Long insert(UserDTO userDTO);
}