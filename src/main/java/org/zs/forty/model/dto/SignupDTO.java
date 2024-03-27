package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/14
 * @description: 注册参数
 **/
@Getter
@Schema(description = "注册参数")
public class SignupDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "用户名")
  private String username;
  @Schema(description = "昵称")
  private String nickname;
  @Schema(description = "密码")
  private String password;
  @Schema(description = "邮箱")
  private String email;
  @Schema(description = "状态")
  private int status;
}