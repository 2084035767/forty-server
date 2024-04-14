package org.zs.forty.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 订单实体类
 **/
@Data // 生成getter,setter等函数
@Builder // 使用建造者模型
@AllArgsConstructor // 生成全参数构造函数
@NoArgsConstructor // 生成无参构造函数
public class Order {
  private Long id;
  private Long createUser;
  private Long storyId;
  private Long productId;
  private Integer status;
  // 自动填充
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private LocalDateTime createTime;
  // 自动填充
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;
}