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
import org.zs.forty.model.vo.ResultVO;
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
@RequestMapping("/api/order")
public class OrderController {
  @Resource private OrderService orderService;
  
  @Operation(summary = "获取用户订单列表")
  @PostMapping("/user/list/{createUser}")
  public PageInfo<OrderVO> userOrder(@Valid @PathVariable Long createUser,
      @Valid @RequestBody PageDTO pageDTO) {
    return new PageInfo<>(orderService.findByCreateUser(createUser, pageDTO));
  }
  
  @Operation(summary = "添加订单")
  @PostMapping
  public OrderVO insert(@Valid @RequestBody OrderDTO orderDTO) {
    return orderService.insert(orderDTO);
  }
  
  @Operation(summary = "更新订单")
  @PutMapping
  public ResultVO<Object> update(@Valid @RequestBody OrderDTO orderDTO) {
    return orderService.updateById(orderDTO) ? ResultVO.success() : ResultVO.error();
  }
  
  @Operation(summary = "删除订单")
  @DeleteMapping
  public ResultVO<Object> delete(@Valid @RequestParam Long createUser) {
    return orderService.deleteById(createUser) ? ResultVO.success() : ResultVO.error();
  }
}