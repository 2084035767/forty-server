package org.zs.forty.service;

import org.zs.forty.model.dto.ForgetDTO;
import org.zs.forty.model.dto.SignupDTO;
import org.zs.forty.model.vo.LoginUserVO;
import org.zs.forty.model.vo.UserVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/

public interface AuthService {
  LoginUserVO login(String username, String password);
  
  UserVO register(SignupDTO signupDTO);
  
  Boolean logout();
  
  Boolean forget(ForgetDTO forgetDTO);
  
  Boolean getUserCode(String email);
}