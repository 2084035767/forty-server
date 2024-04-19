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
 * @date: 2024/3/5
 * @description: 菜单响应
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "菜单响应")
public class MenuVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "菜单路径")
  private String menuPath;
  @Schema(description = "菜单名称")
  private String menuName;
  @Schema(description = "菜单图标")
  private String menuMark;
}