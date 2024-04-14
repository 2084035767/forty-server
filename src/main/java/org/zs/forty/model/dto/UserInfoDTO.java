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
  
  private String addr;
  
  private int sex;
  
  private Integer age;
  
  private String userImg;
}