package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 评论参数
 **/
@Getter
@Setter
@Schema(description = "评论参数")
public class CommentDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  
  @NotNull(message = "fromUid不能为空")
  @Schema(description = "评论者id", example = "1")
  private Long fromUid;
  
  @NotNull(message = "toUid不能为空")
  @Schema(description = "被评论者id", example = "2")
  private Long toUid;
  
  @NotNull(message = "storyId不能为空")
  @Schema(description = "故事id", example = "3")
  private Long storyId;
  
  @NotBlank(message = "context不能为空")
  @Schema(description = "评论内容")
  private String context;
}