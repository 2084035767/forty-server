package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.ResultVO;
import org.zs.forty.model.vo.UserInfoVO;
import org.zs.forty.service.UserInfoService;

@Tag(name = "用户信息管理")
@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {
  @Resource private UserInfoService userInfoService;
  
  // @Operation(summary = "获取用户信息列表")
  // @PostMapping("/{UserInfo}/List")
  // public PageInfo<UserInfoVO> selectUserInfo (@Valid@RequestBody@NotNull Long id){
  //     return new PageInfo<>();
  //
  // }
  @Operation(summary = "添加用户信息")
  @PostMapping()
  public UserInfoVO addUserInfo(@Valid @RequestBody UserInfoDTO userInfoDTO) {
    return userInfoService.insert(userInfoDTO);
  }
  
  @Operation(summary = "删除用户信息")
  @DeleteMapping("/{id}")
  public ResultVO<Object> deleteUserInfo(@Valid @NotNull @PathVariable Long id) {
    return userInfoService.deleteById(id) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "更新用户信息")
  @PutMapping()
  public ResultVO<Object> updateUserInfo(@Valid @RequestBody UserInfoDTO userInfoDTO) {
    return userInfoService.update(userInfoDTO) ? ResultVO.success() : ResultVO.error();
  }
}