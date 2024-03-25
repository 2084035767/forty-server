package org.zs.forty.common.filter;

import io.jsonwebtoken.Claims;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
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
 * @Author: 子十
 * @Date: 2024/3/5
 * @Description:
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
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    // 登录或者注册放行
    if (request.getRequestURI().contains("/api/auth")) {
      filterChain.doFilter(request, response);
      return;
    }
    String authorization = request.getHeader(AUTHORIZATION);
    if (authorization != null && authorization.startsWith("Bearer ")) {
      String token = authorization.substring(7);
      Claims claims = jwtUtil.parseClaims(token);
      String username = claims.get("username", String.class);
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