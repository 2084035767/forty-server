package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 评论参数
 **/
@Getter
 @Setter
 @Builder
@Schema(description = "评论参数")
public class CommentDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @NotNull(message = "fromUid不能为空")
  @Schema(description = "评论者id")
  private Long fromUid;
  @Schema(description = "被评论者id")
  @NotNull(message = "toUid不能为空")
  private Long toUid;
  @Schema(description = "故事id")
  @NotNull(message = "storyId不能为空")
  private Long storyId;
  @Schema(description = "评论内容")
  @NotBlank(message = "context不能为空")
  private String context;
}