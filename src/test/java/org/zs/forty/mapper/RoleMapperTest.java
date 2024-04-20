package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description:
 **/
@SpringBootTest
class RoleMapperTest {
  @Resource
  private RoleMapper roleMapper;
  
  @Test
  void selectRoleById(){
    roleMapper.selectRoleById(1L);

  }
}