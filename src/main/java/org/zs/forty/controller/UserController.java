package org.zs.forty.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.UserDTO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.model.vo.UserVO;
import org.zs.forty.service.UserService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description: 用户管理
 **/
@Tag(name = "用户管理")
@RestController
@RequestMapping("/api/user")
public class UserController {
  
  @Resource
  private UserService userService;
  
  @GetMapping("/info/{id}")
  @Operation(summary = "获取用户信息")
  public UserVO UserInfo(@PathVariable Long id) {
    return userService.findUserById(id);
  }
  
  @PutMapping("/info/{id}")
  @Operation(summary = "更新用户信息")
  public ResultVO<Object> UpdateUserInfo(@PathVariable Long id,
      @Valid @RequestBody UserDTO userdto) {
    userdto.setId(id);
    return userService.updateUser(userdto) ? ResultVO.success() : ResultVO.error();
  }
  
  @DeleteMapping
  @Operation(summary = "删除用户")
  public ResultVO<Object> DeleteUser(@RequestParam Long id) {
    return userService.deleteUser(id) ? ResultVO.success() : ResultVO.error();
  }
  
  @PostMapping("/list")
  @Operation(summary = "获取用户列表")
  public PageInfo<UserVO> ALLUser(@RequestBody PageDTO pageDTO) {
    return new PageInfo<>(userService.allUserByList(pageDTO));
  }
}