package org.zs.forty.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @description: 用户信息实体类
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_info")
public class UserInfo {
  private Long id;
  private Long userId;
  private String userAdd;
  private String userPhone;
  private String userEmail;
  private Integer userSex;
  private Integer userAge;
  private String userImg;
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private LocalDateTime createTime;
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;
}