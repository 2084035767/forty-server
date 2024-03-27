package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/14
 * @description: 登录参数
 **/
@Getter
@Schema(description = "登录参数")
public class LoginDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  @NotBlank(message = "邮箱不能为空")
  @Schema(description = "邮箱")
  private String email;
  @NotBlank(message = "密码不能为空")
  @Schema(description = "密码")
  private String password;
}