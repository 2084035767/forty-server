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
 * @Author: 子十
 * @Date: 2024/1/13
 * @Description:
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
  private String addr;
  @Schema(description = "电话")
  private String phone;
  @Schema(description = "邮箱")
  private String email;
  @Schema(description = "性别")
  private Integer sex;
  @Schema(description = "年龄")
  private Integer age;
  @Schema(description = "头像")
  private String userImg;
}