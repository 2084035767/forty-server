package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.RoleMapper;
import org.zs.forty.model.entity.Role;
import org.zs.forty.service.RoleService;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/14
 * @Description:
 **/
@Slf4j
@Service
@MappingIgnore
public class RoleServiceImpl implements RoleService {
  @Resource
  private RoleMapper roleMapper;
  
  @Override public void addRole() {
  
  }
  
  @Override public void deleteRole() {
  
  }
  
  @Override public void updateRole() {
  
  }
  
  @Override public Role findRole(String name) {
    return null;
  }
}