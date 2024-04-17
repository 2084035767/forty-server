package org.zs.forty.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zs.forty.common.annotate.MappingIgnore;
import org.zs.forty.mapper.MainMapper;
import org.zs.forty.mapper.RoleMapper;
import org.zs.forty.model.dto.PageDTO;
import org.zs.forty.model.dto.RoleDTO;
import org.zs.forty.model.entity.Role;
import org.zs.forty.model.vo.RoleVO;
import org.zs.forty.service.RoleService;

import java.util.List;

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
  @Resource
  private MainMapper mainMapper;
  @Override public void addRole() {
  
  }
  
  @Override public void deleteRole() {
  
  }
  
  @Override public void updateRole() {
  
  }
  
  @Override public Role findRole(String name) {
    return null;
  }

  @Override
  public List<RoleVO> findAllRoles(PageDTO pageDTO,Long id) {
    PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
    return mainMapper.roleList2VO(roleMapper.selectRoleById(id));
  }

  @Override
  public List<RoleVO> getRoleList(PageDTO pageDTO,Long id) {
    return mainMapper.roleList2VO(roleMapper.selectRoleById(id));
  }

  @Override
  public RoleVO insert(RoleDTO roleDTO) {
    return mainMapper.roleList2VO(roleMapper.insert(roleDTO));
  }

  @Override
  public Boolean deleteById(Long id) {
    return mainMapper.roleList2VO(roleMapper.delete(id));
  }

  @Override
  public Boolean update(RoleDTO roleDTO) {
    return mainMapper.roleList2VO(roleMapper.update(roleDTO));
  }


}