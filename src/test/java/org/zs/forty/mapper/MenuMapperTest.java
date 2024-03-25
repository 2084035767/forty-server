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
class MenuMapperTest {
  @Resource
  private MenuMapper menuMapper;
  
  @Test
  void selectList() {
    // Set<Integer> = menuMapper.selectList();
  }
  
  @Test
  void selectMenuByRoleId() {
    // List<Menu> menu = menuMapper.selectMenuByRoleId(1L);
    // Set<String> menus = new HashSet<>();
    // menus.add(menu.get(0).getMenuPath());
    // menus.add("/user/info");
    // menus.add("/user");
    // System.out.println(menus.toString());
  }
}