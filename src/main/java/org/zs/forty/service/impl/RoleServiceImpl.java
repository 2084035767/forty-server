package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
@CacheConfig(cacheNames = "RoleService")
public class RoleServiceImpl implements RoleService {
  @Resource
  private RoleMapper roleMapper;
  
  @Override
  @Cacheable(key = "#roleId")
  public RoleVO findRoleId(Long roleId) {
    return roleMapper.selectRoleByRoleId(roleId);
  }
  
  @Override
  @Cacheable(key = "#roleDTO.roleId")
  public RoleVO insert(RoleDTO roleDTO) {
    return roleMapper.selectRoleByRoleId(roleMapper.insert(roleDTO));
  }
  
  @Override
  @CacheEvict(key = "#roleId")
  public Boolean deleteById(Long roleId) {
    return roleMapper.deleteById(roleId) > 0;
  }
  
  @Override
  @CachePut(key = "#roleDTO.roleId")
  public Boolean update(RoleDTO roleDTO) {
    return roleMapper.update(roleDTO) > 0;
  }
}