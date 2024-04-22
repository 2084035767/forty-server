package org.zs.forty.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.UserInfoDTO;
import org.zs.forty.model.vo.UserInfoVO;
import org.zs.forty.service.UserInfoService;

@Tag(name = "用户信息管理")
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Resource private UserInfoService userInfoService;

    @Operation(summary = "获取用户信息列表")
    @PostMapping("/getUserInfoList")
    public PageInfo<UserInfoVO> AllUserInfo (@Valid@RequestBody PageDTO pageDTO){
        return new PageInfo<>(userInfoService.findAll(pageDTO));

    }
    @Operation(summary = "添加用户信息")
    @PostMapping()
    public UserInfoVO addUserInfo(@Valid @RequestBody UserInfoDTO userInfoDTO){
        return userInfoService.insert(userInfoDTO);
    }
    @Operation(summary = "删除用户信息")
    @DeleteMapping("/id")
    public Boolean  deleteUserInfo(@Valid @RequestBody Long id){
        return userInfoService.deleteById(id);
    }
    @Operation(summary = "更新用户信息")
    @PutMapping()
    public Boolean updateUserInfo(@Valid @RequestBody UserInfoDTO userInfoDTO){
        return userInfoService.update(userInfoDTO);
    }


}
