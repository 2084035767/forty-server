package org.zs.forty.service;

import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.vo.RoleVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/14
 * @description:
 **/

public interface RoleService {
  
  RoleVO findRoleId(Long roleId);
  
  RoleVO insert(RoleDTO roleDTO);
  
  Boolean deleteById(Long roleId);
  
  Boolean update(RoleDTO roleDTO);
}