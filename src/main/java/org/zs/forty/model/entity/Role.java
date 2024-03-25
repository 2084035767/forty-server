package org.zs.forty.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/5
 * @Description:
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {
  @TableId(value = "role_id", type = IdType.AUTO)
  protected Long RoleId;
  private String roleName;
  private String roleDesc;
  private Boolean isDelete;
  @TableField(exist = false)
  private List<Menu> menus;
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  protected LocalDateTime createTime;
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  protected LocalDateTime updateTime;
}