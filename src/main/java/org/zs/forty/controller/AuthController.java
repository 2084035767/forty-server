package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.ForgetDTO;
import org.zs.forty.model.dto.LoginDTO;
import org.zs.forty.model.dto.SignupDTO;
import org.zs.forty.model.vo.LoginUserVO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.model.vo.UserVO;
import org.zs.forty.service.AuthService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description: 登录注册
 **/

@Tag(name = "登录注册")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Resource
  private AuthService authService;
  
  @Operation(summary = "用户登录")
  @PostMapping("/login")
  public LoginUserVO userLogin(@Valid @RequestBody LoginDTO loginDTO) {
    return authService.login(loginDTO.getEmail(), loginDTO.getPassword());
  }
  
  @Operation(summary = "用户注册")
  @PostMapping("/register")
  public UserVO userRegister(@Valid @RequestBody SignupDTO signupDTO) {
    return authService.register(signupDTO);
  }
  
  @Operation(summary = "用户注销")
  @PostMapping("/logout")
  public ResultVO<Object> userLogout() {
    return authService.logout() ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "验证码")
  @GetMapping("/code")
  public ResultVO<Object> getUserCode(@Valid @Email @RequestParam("email") String email) {
    return authService.getUserCode(email) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "忘记密码")
  @PostMapping("/forget")
  public ResultVO<Object> forgetUser(@Valid @RequestBody ForgetDTO forgetDTO) {
    return authService.forget(forgetDTO) ? ResultVO.success() : ResultVO.error();
  }
}