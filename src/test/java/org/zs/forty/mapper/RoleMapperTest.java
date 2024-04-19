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
  void selectListByUserId() {
    // List<Role> roles = roleMapper.selectRoleById(1L);
    // for (Role role : roles) {
    //   List<Menu> menus = role.getMenus();
    //   assert menus.size() > 1;
    // }
    
    System.out.println(roleMapper.selectRoleById(1L));
  }
  
  @Test
  void selectRoleByName() {
  }
}