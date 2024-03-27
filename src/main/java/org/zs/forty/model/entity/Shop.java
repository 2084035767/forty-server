package org.zs.forty.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description: 店铺实体类
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
  @TableId(value = "id", type = IdType.AUTO)
  protected Long id;
  private String shopName;
  private String shopInfo;
  private String shopImg;
  private String category;
  private Integer status;
  private Long createUser;
  private Boolean isDelete;
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  protected LocalDateTime createTime;
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  protected LocalDateTime updateTime;
}