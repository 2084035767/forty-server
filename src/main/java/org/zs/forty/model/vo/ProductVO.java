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
 * @description: 产品响应
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "产品响应")
public class ProductVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "产品名称")
  private String productName;
  @Schema(description = "产品信息")
  private String productInfo;
  @Schema(description = "产品价格")
  private String productPrice;
  @Schema(description = "产品图片")
  private String productImg;
  @Schema(description = "状态")
  private Integer status;
  @Schema(description = "类别")
  private String category;
}