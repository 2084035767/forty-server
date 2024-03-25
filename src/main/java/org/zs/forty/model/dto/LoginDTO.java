package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/14
 * @Description:
 **/
@Getter
@Schema(description = "登录参数")
public class LoginDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  @NotBlank(message = "用户名不能为空")
  @Schema(description = "用户名")
  private String username;
  @NotBlank(message = "密码不能为空")
  @Schema(description = "密码")
  private String password;
}