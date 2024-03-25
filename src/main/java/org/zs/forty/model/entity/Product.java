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
 * @Date: 2024/1/13
 * @Description:
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
  @TableId(value = "id", type = IdType.AUTO)
  protected Long id;
  private Long shopId;
  private String productName;
  private String productInfo;
  private Long productPrice;
  private String productImg;
  private String category;
  private Integer status;
  private Boolean isDelete;
  @TableField(exist = false)
  private List<Story> stories;
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  protected LocalDateTime createTime;
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  protected LocalDateTime updateTime;
}