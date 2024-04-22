package org.zs.forty.service;

import java.util.List;
import org.zs.forty.model.dto.OrderDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.OrderVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description:
 **/
public interface OrderService {
  List<OrderVO> findByProductId(Long productId);
  
  OrderVO findByStoryId(Long storyId);
  
  List<OrderVO> findByCreateUser(Long createUser, PageDTO pageDTO);
  
  OrderVO insert(OrderDTO orderDTO);
  
  Boolean deleteById(Long id);
  
  Boolean deleteByUserId(Long createUser);
  
  Boolean updateById(OrderDTO orderDTO);
}