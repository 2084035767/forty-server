package org.zs.forty.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/21
 * @Description:
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