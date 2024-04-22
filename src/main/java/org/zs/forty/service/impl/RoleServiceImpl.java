package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.RoleMapper;
import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.vo.RoleVO;
import org.zs.forty.service.RoleService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/14
 * @description:
 **/
@Slf4j
@Service
@MappingIgnore
public class RoleServiceImpl implements RoleService {
  @Resource
  private RoleMapper roleMapper;
  
  @Override
  public RoleVO findRoleId(Long roleId) {
    return roleMapper.selectRoleById(roleId);
  }
  
  @Override
  public RoleVO insert(RoleDTO roleDTO) {
    return roleMapper.insert(roleDTO);
  }
  
  @Override
  public Boolean deleteById(Long id) {
    return roleMapper.deleteById(id) >0;
  }
  
  @Override
  public Boolean update(RoleDTO roleDTO) {
    return roleMapper.update(roleDTO) >0;
  }
}