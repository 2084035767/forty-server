package org.zs.forty.service;

import com.github.pagehelper.PageInfo;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.entity.Role;
import org.zs.forty.model.vo.LikeVO;
import org.zs.forty.model.vo.RoleVO;

import java.util.List;

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
  List<RoleVO> findAllRoles(PageDTO pageDTO,Long id);

  List<RoleVO> getRoleList(PageDTO pageDTO,Long id);

  RoleVO insert(RoleDTO roleDTO);

  Boolean deleteById(Long id);

  Boolean update(RoleDTO roleDTO);

}