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
 * @description: 角色响应
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "角色响应")
public class RoleVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long roleId;
  @Schema(description = "角色名称")
  private String roleName;
  @Schema(description = "角色描述")
  private String roleDesc;
}