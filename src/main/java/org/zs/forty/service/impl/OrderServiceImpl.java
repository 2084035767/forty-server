package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
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
public class OrderServiceImpl implements OrderService {
  @Resource private OrderMapper relationMapper;
  @Resource private MainMapper mainMapper;
  
  @Override public List<OrderVO> findByProductId(Long productId) {
    return mainMapper.relationList2VO(relationMapper.selectByProductId(productId));
  }
  
  @Override public OrderVO findByStoryId(Long storyId) {
    return mainMapper.relation2VO(relationMapper.selectByStoryId(storyId));
  }
  
  @Override public List<OrderVO> findByCreateUser(Long createUser, PageDTO pageDTO) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.relationList2VO(relationMapper.selectByCreateUser(createUser));
  }
  
  @Override public OrderVO insert(OrderDTO relationDTO) {
    return mainMapper.relation2VO(relationMapper.selectById(relationMapper.insert(relationDTO)));
  }
  
  @Override public Boolean deleteById(Long id) {
    return relationMapper.deleteById(id) > 0;
  }
  
  @Override public Boolean deleteByUserId(Long createUser) {
    return relationMapper.deleteByCreateUser(createUser) > 0;
  }
  
  @Override public Boolean updateById(OrderDTO relationDTO) {
    return relationMapper.updateById(relationDTO) > 0;
  }
}