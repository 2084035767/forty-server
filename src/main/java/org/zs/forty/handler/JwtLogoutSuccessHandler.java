package org.zs.forty.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.zs.forty.common.enums.StatusEnum;
import org.zs.forty.model.vo.ResultVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/22
 * @Description:
 **/
@Slf4j
@Component
public class JwtLogoutSuccessHandler implements LogoutSuccessHandler {
  @Override public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException {
    response.setContentType("application/json;charset=utf-8");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    
    // todo: 退出登录成功
    response.getWriter().write(
        new ObjectMapper().writeValueAsString(ResultVO.error(StatusEnum.PERMISSION_NO_ACCESS)));
  }
}