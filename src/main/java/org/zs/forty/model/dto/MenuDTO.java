package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/5
 * @description: 菜单参数
 **/
@Getter
@Setter
@Schema(description = "菜单参数")
public class MenuDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  
  @NotBlank(message = "菜单路径不能为空")
  @Schema(description = "菜单路径", example = "/api/user")
  private String menuPath;
  
  @NotBlank(message = "菜单名称不能为空")
  @Schema(description = "菜单名称", example = "用户管理")
  private String menuName;
  
  @NotBlank(message = "菜单标记不能为空")
  @Schema(description = "菜单标记", example = "sys:user:list")
  private String menuMark;
}