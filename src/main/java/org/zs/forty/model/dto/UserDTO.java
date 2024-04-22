package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 用户参数
 **/
@Getter
@Setter
@Builder
@Schema(description = "用户参数")
public class UserDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  @Schema(description = "用户id")
  private Long id;
  // @Size(min = 12, max = 20, message = "字符长度在 12 -20 之间")
  @Schema(description = "用户名")
  @NotBlank(message = "用户名为必传参数")
  private String username;
  @Schema(description = "昵称")
  private String nickname;
  
  // @Size(min = 12, max = 20, message = "字符长度在 12 -20 之间")
  @NotBlank(message = "密码为必传参数")
  @Schema(description = "密码")
  private String password;
  @Schema(description = "邮箱")
  private String email;
}