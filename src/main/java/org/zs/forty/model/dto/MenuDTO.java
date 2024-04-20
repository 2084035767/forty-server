package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/5
 * @description: 菜单参数
 **/
@Getter
@Builder
@Schema(description = "菜单参数")
public class MenuDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long menuId;
  @Schema(description = "菜单路径")
  @NotNull(message = "menuPath不能为空")
  private String menuPath;
  @Schema(description = "菜单名称")
  @NotNull(message = "menuPath不能为空")
  private String menuName;
  @Schema(description = "菜单标记")
  @NotNull(message = "menMark不能为空")
  private String menuMark;
}