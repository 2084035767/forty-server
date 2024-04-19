package org.zs.forty.service.impl;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zs.forty.mapper.RoleMapper;
import org.zs.forty.mapper.UserMapper;
import org.zs.forty.model.entity.Menu;
import org.zs.forty.model.entity.Role;
import org.zs.forty.model.entity.User;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/22
 * @description:
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserMapper userMapper;
  private final RoleMapper roleMapper;
  
  @Override public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    User user = userMapper.selectRoleByEmail(username);
    Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
    List<Role> roles = user.getRoles();
    List<Menu> menus =
        roles.stream().map(Role::getRoleId).map(roleMapper::selectRoleById)
            .map(Role::getMenus).flatMap(List::stream).distinct().toList();
    List<GrantedAuthority> authorities =
        AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",",
            menus.stream().map(Menu::getMenuMark).distinct().toList()));
    user.setAuthorities(authorities);
    return user;
  }
}