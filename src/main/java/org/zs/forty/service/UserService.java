package org.zs.forty.service;

import java.util.List;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.vo.UserVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description:
 **/
public interface UserService {
  
  UserVO findByUsername(String username);
  
  // User findUserByEmail(String email);
  
  UserVO findUserById(Long id);
  
  Boolean updateUser(UserDTO userDTO);
  
  Boolean deleteUser(Long id);
  
  // User findAddUser(UserDTO userDTO);
  
  // List<User> findAllUserByList(Integer page, Integer size);
  
  UserVO addUser(UserDTO userDTO);
  
  List<UserVO> allUserByList(PageDTO pageDTO);
}