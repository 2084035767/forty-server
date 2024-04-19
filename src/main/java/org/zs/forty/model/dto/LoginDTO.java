package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/14
 * @description: 登录参数
 **/
@Getter
@Setter
@Schema(description = "登录参数")
public class LoginDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  
  @Email
  @Schema(description = "邮箱", example = "2084035767@qq.com")
  private String email;
  
  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$", message = "必须是包含大小写字母和数字的组合，长度在 8-16 之间")
  @Schema(description = "密码", example = "Zs555666")
  private String password;
}