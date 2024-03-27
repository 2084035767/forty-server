package org.zs.forty.service;

import org.zs.forty.model.entity.Role;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/14
 * @description:
 **/

public interface RoleService {
  void addRole();
  
  void deleteRole();
  
  void updateRole();
  
  Role findRole(String name);
}