package org.zs.forty.service;

import org.zs.forty.model.entity.Role;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/14
 * @Description:
 **/

public interface RoleService {
  void addRole();
  
  void deleteRole();
  
  void updateRole();
  
  Role findRole(String name);
}