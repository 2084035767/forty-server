package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 用户参数
 **/
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "用户参数")
public class UserDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  @Schema(description = "用户id")
  private Long id;
  
  @Pattern(regexp = "^[a-zA-Z0-9_-]{4,16}$", message = "验证 数字、字母、_、-，不包含特殊字符，长度 4-16 之间。")
  @Schema(description = "用户名", example = "jaywcjlove")
  private String username;
  
  @Pattern(regexp = "^[\\u4e00-\\u9fa5]{2,6}$", message = "2到6位汉字")
  @Schema(description = "昵称", example = "湖北黄冈")
  private String nickname;
  
  @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$", message = "必须是包含大小写字母和数字的组合，长度在 8-16 之间")
  @Schema(description = "密码", example = "Zs555666")
  private String password;
  
  @Email
  @Schema(description = "邮箱", example = "2084035767@qq.com")
  private String email;
  
  @Schema(description = "用户状态")
  private Integer status;
  
  @Schema(description = "是否删除")
  private Boolean isDelete;
}