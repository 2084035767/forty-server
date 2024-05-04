package org.zs.forty.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/13
 * @description: 评论响应
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "评论响应")
public class CommentVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "评论人id")
  private Long fromUid;
  @TableField(exist = false)
  @Schema(description = "评论人")
  private UserInfoVO from;
  @Schema(description = "被评论人id")
  private Long toUid;
  @Schema(description = "故事id")
  private Long storyId;
  @Schema(description = "评论内容")
  private String context;
}