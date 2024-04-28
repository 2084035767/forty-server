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
 * @description: 故事实体类
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Story {
  private Long id;
  private Long createUser;
  private String title;
  private String context;
  private Integer storyImg;
  private Integer storyView;
  private Integer storyLike;
  private Integer storyComments;
  private Integer storyShare;
  private Boolean isOpen;
  private Boolean isDelete;
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private LocalDateTime createTime;
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;
}