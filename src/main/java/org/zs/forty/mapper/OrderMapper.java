package org.zs.forty.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.OrderDTO;
import org.zs.forty.model.entity.Order;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/14
 * @description:
 **/
@Mapper // 注册 mapper 类
public interface OrderMapper extends BaseMapper<Order> {
  /**
   * 根据id查询
   *
   * @param id id
   * @return Order
   */
  Order selectById(Long id);
  
  /**
   * 根据产品id查询
   *
   * @param productId 产品id
   * @return List<Order>
   */
  List<Order> selectByProductId(Long productId);
  
  /**
   * 根据故事id查询
   *
   * @param storyId 故事id
   * @return Order
   */
  Order selectByStoryId(Long storyId);
  
  /**
   * 根据创建人查询
   *
   * @param createUser 创建人
   * @return List<Order>
   */
  List<Order> selectByCreateUser(Long createUser);
  
  /**
   * 插入
   */
  Long insert(OrderDTO orderDTO);
  
  /**
   * 根据id删除
   *
   * @param id id
   * @return int
   */
  int deleteById(Long id);
  
  /**
   * 根据创建人删除
   *
   * @param UserId 创建人
   * @return int
   */
  int deleteByCreateUser(Long UserId);
  
  /**
   * 根据id更新
   *
   * @return int
   */
  int updateById(OrderDTO orderDTO);
}