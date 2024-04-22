package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
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
 * @description: 订单参数
 **/
@Getter // 生成getter函数
@Builder
@Setter
@Schema(description = "订单参数")
public class OrderDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "用户id")
  @NotNull(message = "createUser不能为空")
  private Long createUser;
  @Schema(description = "故事id")
  @NotNull(message = "storyId不能为空")
  private Long storyId;
  @Schema(description = "产品id")
  @NotNull(message = "productId不能为空")
  private Long productId;
  @Schema(description = "订单状态")
  @NotNull(message = "status不能为空")
  private int status;
}