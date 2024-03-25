package org.zs.forty.model.vo;

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
 * @Author: 子十
 * @Date: 2024/1/13
 * @Description:
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "故事响应")
public class StoryVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "创建人")
  private Long createUser;
  @Schema(description = "标题")
  private String title;
  @Schema(description = "内容")
  private String context;
  @Schema(description = "浏览量")
  private Integer storyView;
  @Schema(description = "点赞量")
  private Integer storyLike;
  @Schema(description = "是否公开")
  private Boolean isOpen;
}