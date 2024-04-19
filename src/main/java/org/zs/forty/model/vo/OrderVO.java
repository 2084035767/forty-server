package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 订单响应
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "订单响应")
public class OrderVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "创建人")
  private Long createUser;
  @Schema(description = "故事id")
  private Long storyId;
  @Schema(description = "产品id")
  private Long productId;
  @Schema(description = "状态")
  private Integer status;
}