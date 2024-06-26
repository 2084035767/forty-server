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
 * @description: 用户响应
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "用户响应")
public class UserVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "用户名")
  private String username;
  @Schema(description = "昵称")
  private String nickname;
  @Schema(description = "邮件")
  private String email;
  @Schema(defaultValue = "状态")
  private Integer status;
}