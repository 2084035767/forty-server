package org.zs.forty.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.zs.forty.model.vo.ResultVO;

import static org.zs.forty.common.enums.StatusEnum.USER_NOT_LOGGED_IN;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/23
 * @description: 未登录处理类
 **/
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
  @Override public void commence(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException authException) throws IOException {
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(
        new ObjectMapper().writeValueAsString(
            ResultVO.error(USER_NOT_LOGGED_IN, "未登录或token已过期"))
    );
  }
}