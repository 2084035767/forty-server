package org.zs.forty.service;

import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.vo.UserVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/21
 * @Description:
 **/

public interface AuthService {
  String login(String username, String password);
  
  UserVO register(UserDTO userDTO);
  
  Boolean logout();
}