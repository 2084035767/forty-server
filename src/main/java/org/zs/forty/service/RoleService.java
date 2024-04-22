package org.zs.forty.service;

import org.zs.forty.model.dto.RoleDTO;
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


  List<RoleVO> findRoleId(Long roleId );

  RoleVO insert(RoleDTO roleDTO);

  Boolean deleteById(Long id);

  Boolean update(RoleDTO roleDTO);

}