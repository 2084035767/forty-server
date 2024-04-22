package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 故事参数
 **/
@Getter
@Setter
@Schema(description = "故事参数")
public class StoryDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "用户id", example = "1")
  @NotNull(message = "createUser 不能为空")
  private Long createUser;
  
  @Schema(description = "标题", example = "我的一天")
  @Size(min = 2, max = 20, message = "title 不能为空")
  private String title;
  
  @Schema(description = "内容", example = "没什么内容")
  @Size(min = 100, max = 500, message = "context 不能为空")
  private String context;
  
  @Schema(description = "浏览量", example = "1")
  @PositiveOrZero(message = "storyView 不能为空或负数")
  private Integer storyView;
  
  @Schema(description = "点赞量", example = "1")
  @PositiveOrZero(message = "storyLike 不能为空或负数")
  private Integer storyLike;
  
  @Schema(description = "是否公开", example = "1")
  private Boolean isOpen;
}