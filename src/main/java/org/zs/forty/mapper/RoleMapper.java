package org.zs.forty.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.vo.RoleVO;

import java.util.List;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/5
 * @description:
 **/
@Mapper
public interface RoleMapper {
  List<RoleVO> selectRoleById(Long id);
  List<RoleVO> selectByName(String roleName);

  RoleVO insert(RoleDTO roleDTO);

  Boolean update(RoleDTO roleDTO);

  Boolean deleteById(Long id);



}