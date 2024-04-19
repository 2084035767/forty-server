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
import org.zs.forty.model.dto.OrderDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.OrderVO;
import org.zs.forty.service.OrderService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description: 订单管理
 **/
@Tag(name = "订单管理")
@RestController

@RequestMapping("/api/relation")
public class OrderController {
  @Resource private OrderService relationService;
  
  @Operation(summary = "获取用户订单列表")
  @PostMapping("/user/{createUser}/list")
  public PageInfo<OrderVO> userOrder(@Valid @PathVariable Long createUser,
      @Valid @RequestBody PageDTO pageDTO) {
    return new PageInfo<>(relationService.findByCreateUser(createUser,pageDTO));
  }
  
  @Operation(summary = "添加订单")
  @PostMapping
  public OrderVO insert(@Valid @RequestBody OrderDTO relationDTO) {
    return relationService.insert(relationDTO);
  }
  
  @Operation(summary = "更新订单")
  @PutMapping
  public Boolean update(@Valid @RequestBody OrderDTO relationDTO) {
    return relationService.updateById(relationDTO);
  }
  
  @Operation(summary = "删除订单")
  @DeleteMapping
  public Boolean delete(@Valid @RequestParam Long createUser) {
    return relationService.deleteById(createUser);
  }
}