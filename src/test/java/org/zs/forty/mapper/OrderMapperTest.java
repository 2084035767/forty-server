package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.OrderDTO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/
@SpringBootTest
class OrderMapperTest {
  @Resource private OrderMapper orderMapper;
  @Test
  void selectById() {
    orderMapper.selectById(1);

  }
  
  @Test
  void selectByProductId() {
    orderMapper.selectByProductId(1L);
  }
  
  @Test
  void selectByStoryId() {
    orderMapper.selectByStoryId(1L);
  }
  
  @Test
  void selectByUserId() {
    orderMapper.selectByCreateUser(1L);
  }
  
  @Test
  void insert() {
    Long test = orderMapper.insert(
            OrderDTO.builder()
                    .storyId(2L)
                    .productId(2L)
                    .status(1)
                    .createUser(2L)
                    .build()
    );
  }
  
  @Test
  void deleteById() {
    orderMapper.deleteById(1L);

  }
  
//  @Test
//  void deleteByCreateUser() {
//  }
  
  @Test
  void updateById() {
    orderMapper.updateById(
            OrderDTO.builder()
                    .id(2L)
                    .storyId(31L)
                    .build()
    );
  }
}