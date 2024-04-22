package org.zs.forty.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.entity.Role;
import org.zs.forty.model.vo.RoleVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/5
 * @description:
 **/
@Mapper
public interface RoleMapper {
  
  Role selectRoleById(Long id);
  
  RoleVO selectRoleByRoleId(Long roleId);
  
  List<RoleVO> selectByName(String roleName);
  
  List<RoleVO> selectAllRole(String roleName);
  
  Long insert(RoleDTO roleDTO);
  
  int update(RoleDTO roleDTO);
  
  int deleteById(Long id);
}