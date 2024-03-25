package org.zs.forty.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.common.annotate.ResponseResult;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.RelationDTO;
import org.zs.forty.model.vo.RelationVO;
import org.zs.forty.service.RelationService;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/2/20
 * @Description:
 **/
@Tag(name = "关系管理")
@RestController
@ResponseResult
@RequestMapping("/api/relation")
public class RelationController {
  @Resource private RelationService relationService;
  
  @Operation(summary = "获取用户关系列表")
  @PostMapping("/user/{createUser}/list")
  public PageInfo<RelationVO> userRelation(@Valid @PathVariable Long createUser,
      @Valid @RequestBody PageDTO pageDTO) {
    return new PageInfo<>(relationService.findByCreateUser(createUser, pageDTO));
  }
  
  @Operation(summary = "添加关系")
  @PostMapping
  public RelationVO insert(@Valid @RequestBody RelationDTO relationDTO) {
    return relationService.insert(relationDTO);
  }
  
  @Operation(summary = "更新关系")
  @PutMapping
  public Boolean update(@Valid @RequestBody RelationDTO relationDTO) {
    return relationService.updateById(relationDTO);
  }
  
  @Operation(summary = "删除关系")
  @DeleteMapping
  public Boolean delete(@Valid @RequestParam Long createUser) {
    return relationService.deleteById(createUser);
  }
}