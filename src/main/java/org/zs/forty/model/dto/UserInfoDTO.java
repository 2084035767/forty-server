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
 * @date: 2024/1/13
 * @description: 用户信息参数
 **/

@Getter
@Setter
@Schema(description = "用户信息参数")
public class UserInfoDTO implements Serializable {
  
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(name = "用户id")
  private Long userId;
  
  @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确")
  @Schema(name = "phone")
  
  private String phone;
  
  @Schema(name = "email")
  @Email(message = "email格式错误，请重新填写")
  private String email;
  @NotBlank(message = "realName为必传参数")
  @SchemaProperty(name = "addr")
  private String addr;
  @Schema(description = "用户性别")
  private int sex;
  @Schema(description = "用户年龄")
  private Integer age;
  @Schema(description = "用户头像")
  private String userImg;
}