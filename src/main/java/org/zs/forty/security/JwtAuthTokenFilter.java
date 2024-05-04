package org.zs.forty.security;

import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.zs.forty.common.utils.JwtUtil;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/5
 * @description: JWT认证过滤器
 **/
@Slf4j
@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {
  public static final String AUTHORIZATION = "Authorization";
  @Resource
  private JwtUtil jwtUtil;
  @Resource
  private UserDetailsService userDetailsService;
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response,
      @NonNull FilterChain filterChain) throws ServletException, IOException {
    // 登录或者注册放行
    if (request.getRequestURI().contains("/api/auth")) {
      filterChain.doFilter(request, response);
      return;
    }
    String authorization = request.getHeader(AUTHORIZATION);
    if (authorization != null && authorization.startsWith("Bearer ")) {
      String token = authorization.substring(7);
      Claims claims = jwtUtil.parseClaims(token);
      String username = claims.get("email", String.class);
      UserDetails userDetails = userDetailsService.loadUserByUsername(username);
      UsernamePasswordAuthenticationToken authentication =
          new UsernamePasswordAuthenticationToken(
              userDetails,
              null,
              userDetails.getAuthorities());
      authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    filterChain.doFilter(request, response);
  }
}