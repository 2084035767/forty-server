package org.zs.forty.mapper;

import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.entity.Role;
import org.zs.forty.model.vo.RoleVO;

import java.util.List;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/5
 * @description:
 **/

public interface RoleMapper {

  Role selectRoleById(Long id);

  RoleVO selectRoleByRoleId(Long roleId);
  
  List<RoleVO> selectAllRole(String roleName);
   Long insert(RoleDTO roleDTO);
  // List<RoleVO> selectByName(String roleName);

  List<RoleVO> selectAllRole();

  int update(RoleDTO roleDTO);
  
  int deleteById(Long roleId);
}