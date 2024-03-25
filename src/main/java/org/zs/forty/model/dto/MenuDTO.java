package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/5
 * @Description:
 **/
@Getter
@Schema(description = "菜单参数")
public class MenuDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "菜单路径")
  private String menuPath;
  @Schema(description = "菜单名称")
  private String menuName;
  @Schema(description = "菜单标记")
  private String menuMark;
}