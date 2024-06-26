package org.zs.forty.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.util.function.Supplier;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;
import org.zs.forty.mapper.MenuMapper;
import org.zs.forty.model.entity.Menu;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/24
 * @description: JWT权限管理器
 **/
@Component
public class JwtAuthorizationManager implements AuthorizationManager<RequestAuthorizationContext> {
  @Resource
  private MenuMapper menuMapper;
  
  @Override public AuthorizationDecision check(Supplier<Authentication> authentication,
      RequestAuthorizationContext object) {
    HttpServletRequest request = object.getRequest();
    // todo: redis + jwt
    String requestURI = request.getRequestURI().replaceAll("/\\d+$", "");
    if (requestURI.contains("/api/auth/") || requestURI.contains("/error")) {
      return new AuthorizationDecision(true);
    }
    Menu menu =
        menuMapper.selectOne(new LambdaQueryWrapper<Menu>().
            eq(Menu::getMenuPath, requestURI).last("limit 1"));
    if (menu == null) {
      return new AuthorizationDecision(false);
    }
    String menuMark = menu.getMenuMark();
    if (menuMark == null || menuMark.trim().isEmpty()) {
      return new AuthorizationDecision(true);
    }
    
    return new AuthorizationDecision(authentication.get().getAuthorities().stream()
        .anyMatch(a -> a.getAuthority().equals(menuMark)));
  }
}