package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.common.mapstruct.MainMapper;
import org.zs.forty.mapper.OrderMapper;
import org.zs.forty.model.dto.OrderDTO;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.vo.OrderVO;
import org.zs.forty.service.OrderService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/2/20
 * @description:
 **/
@Slf4j //  log 日志
@Service // 注册 service 类
@MappingIgnore
@CacheConfig(cacheNames = "OrderService")
public class OrderServiceImpl implements OrderService {
  @Resource private OrderMapper orderMapper;
  @Resource private MainMapper mainMapper;
  
  @Override
  @Cacheable(key = "#productId")
  public List<OrderVO> findByProductId(Long productId) {
    return mainMapper.orderList2VO(orderMapper.selectByProductId(productId));
  }
  
  @Override
  @Cacheable(key = "#storyId")
  public OrderVO findByStoryId(Long storyId) {
    return mainMapper.order2VO(orderMapper.selectByStoryId(storyId));
  }
  
  @Override
  @Cacheable(key = "#createUser")
  public List<OrderVO> findByCreateUser(Long createUser, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.orderList2VO(orderMapper.selectByCreateUser(createUser));
  }
  
  @Override
  @Cacheable(key = "#orderDTO.id")
  public OrderVO insert(OrderDTO orderDTO) {
    return mainMapper.order2VO(orderMapper.selectById(orderMapper.insert(orderDTO)));
  }
  
  @Override
  @CacheEvict(key = "#id")
  public Boolean deleteById(Long id) {
    return orderMapper.deleteById(id) > 0;
  }
  
  @Override
  @CacheEvict(key = "#createUser")
  public Boolean deleteByUserId(Long createUser) {
    return orderMapper.deleteByCreateUser(createUser) > 0;
  }
  
  @Override
  @CachePut(key = "#orderDTO.id")
  public Boolean updateById(OrderDTO orderDTO) {
    return orderMapper.updateById(orderDTO) > 0;
  }
}