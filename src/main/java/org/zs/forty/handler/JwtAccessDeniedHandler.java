package org.zs.forty.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.zs.forty.model.vo.ResultVO;

import static org.zs.forty.common.enums.StatusEnum.PERMISSION_NO_ACCESS;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/23
 * @description: 权限不足处理类
 **/
@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
  @Override public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException accessDeniedException) throws IOException {
    response.setContentType("application/json;charset=UTF-8");
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    new ObjectMapper().writeValueAsString(
        ResultVO.error(PERMISSION_NO_ACCESS, "权限不足")
    );
  }
}