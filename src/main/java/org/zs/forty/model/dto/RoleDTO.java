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
@Schema(description = "角色参数")
public class RoleDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  
  private Long id;
  @Schema(description = "角色名称")
  private String roleName;
  @Schema(description = "角色描述")
  private String roleDesc;
}