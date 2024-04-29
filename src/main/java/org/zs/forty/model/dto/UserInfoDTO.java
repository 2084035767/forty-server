package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
 * @description: 用户信息参数
 **/

@Getter
@Setter
@Builder
@Schema(description = "用户信息参数")
public class UserInfoDTO implements Serializable {
  
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(name = "用户id")
  private Long userId;
  @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确")
  @Schema(name = "phone")
  private String userPhone;
  @Schema(name = "email")
  @Email(message = "email格式错误，请重新填写")
  private String userEmail;
  @NotBlank(message = "realName为必传参数")
  @Schema(name = "add")
  private String userAdd;
  @Schema(description = "用户性别")
  private int userSex;
  @Schema(description = "用户年龄")
  private Integer userAge;
  @Schema(description = "用户头像")
  private String userImg;
}