package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 订单参数
 **/
@Getter // 生成getter函数
@Setter
@Schema(description = "订单参数")
public class OrderDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  
  @Schema(description = "用户id", example = "1")
  @NotNull(message = "createUser不能为空")
  private Long createUser;
  
  @Schema(description = "故事id", example = "1")
  @NotNull(message = "storyId不能为空")
  private Long storyId;
  
  @Schema(description = "产品id", example = "1")
  @NotNull(message = "productId不能为空")
  private Long productId;
  
  @Schema(description = "订单状态", example = "1")
  private int status;
}