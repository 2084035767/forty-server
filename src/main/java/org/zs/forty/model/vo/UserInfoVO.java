package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 用户信息响应
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户信息响应")
public class UserInfoVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "用户id")
  private Long userId;
  @Schema(description = "地址")
  private String userAdd;
  @Schema(description = "电话")
  private String userPhone;
  @Schema(description = "邮箱")
  private String userEmail;
  @Schema(description = "性别")
  private Integer userSex;
  @Schema(description = "年龄")
  private Integer userAge;
  @Schema(description = "头像")
  private String userImg;
}