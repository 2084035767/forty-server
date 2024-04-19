package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/25
 * @description: 分页请求
 **/

@Data
@Schema(description = "分页请求")
public class PageDTO {
  
  @NotNull(message = "页码不能为空")
  @Schema(description = "页码")
  private Integer page = 1;
  
  @NotNull(message = "每页数量不能为空")
  @Schema(description = "每页数量")
  private Integer size = 8;
}