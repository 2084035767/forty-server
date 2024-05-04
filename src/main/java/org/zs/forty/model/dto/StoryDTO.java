package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.io.Serial;
import java.io.Serializable;
import lombok.Builder;
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
@Builder
@Schema(description = "故事参数")
public class StoryDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "用户id")
  @NotNull(message = "createUser 不能为空")
  private Long createUser;
  @Schema(description = "标题")
  @NotBlank(message = "title 不能为空")
  private String title;
  @Schema(description = "内容")
  @NotBlank(message = "context 不能为空")
  private String context;
  @Schema(description = "图片地址")
  @PositiveOrZero(message = "storyImg 不能为空或负数")
  private String storyImg;
  @Schema(description = "浏览量")
  @PositiveOrZero(message = "storyView 不能为空或负数")
  private Integer storyView;
  @Schema(description = "点赞量")
  @PositiveOrZero(message = "storyLike 不能为空或负数")
  private Integer storyLike;
  @Schema(description = "评论量")
  @PositiveOrZero(message = "storyComments 不能为空或负数")
  private Integer storyComments;
  @Schema(description = "分类量")
  @PositiveOrZero(message = "storyShare 不能为空或负数")
  private Integer storyShare;
  @Schema(description = "是否公开")
  @NotNull(message = "isOpen 不能为空")
  private Boolean isOpen;
}