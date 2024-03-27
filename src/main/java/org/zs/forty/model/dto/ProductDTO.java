package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 产品参数
 **/
@Getter
@Schema(description = "产品参数")
public class ProductDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  
  private Long id;
  @Schema(description = "产品名称")
  @Size(min = 12, max = 20, message = "字符长度在 12 -20 之间")
  @NotBlank(message = "productName不能为空")
  private String productName;
  @Schema(description = "产品信息")
  @Size(min = 12, max = 100, message = "字符长度在 12 -100 之间")
  @NotBlank(message = "productInfo不能为空")
  private String productInfo;
  @Schema(description = "产品价格")
  @PositiveOrZero(message = "productPrice必须为正数")
  @NotBlank(message = "productPrice不能为空")
  private Long productPrice;
  @Schema(description = "产品图片")
  @NotBlank(message = "productImg不能为空")
  private String productImg;
  @Schema(description = "产品状态")
  private int status;
  @Schema(description = "产品类别")
  @NotBlank(message = "category不能为空")
  private String category;
}