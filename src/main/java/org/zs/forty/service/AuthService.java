package org.zs.forty.service;

import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.vo.UserVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/

public interface AuthService {
  String login(String username, String password);
  
  UserVO register(UserDTO userDTO);
  
  Boolean logout();
}