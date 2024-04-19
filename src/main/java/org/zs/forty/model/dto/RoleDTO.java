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
 * @description: 角色参数
 **/

@Getter
@Setter
@Schema(description = "角色参数")
public class RoleDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  
  private Long id;
  @NotBlank(message = "roleName不能为空")
  @Schema(description = "角色名称", example = "管理员")
  private String roleName;
  
  @NotBlank(message = "roleDesc不能为空")
  @Schema(description = "角色描述", example = "掌管一切")
  private String roleDesc;
}