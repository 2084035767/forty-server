package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/1/13
 * @Description:
 **/

@Getter
@Schema(description = "用户参数")
public class UserInfoDTO implements Serializable {
  
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @SchemaProperty(name = "id")
  private Long userId;
  
  @Pattern(regexp = "^1[3456789]\\d{9}$", message = "手机号格式不正确")
  @SchemaProperty(name = "phone")
  private String phone;
  @SchemaProperty(name = "email")
  @Email(message = "email格式错误，请重新填写")
  @NotBlank(message = "email为必传参数")
  private String email;
  
  private String addr;
  
  private int sex;
  
  private Integer age;
  
  private String userImg;
}