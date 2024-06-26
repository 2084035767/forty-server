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
 * @author: 子十
 * @date: 2024/1/13
 * @description: 故事响应
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
  // @TableField(exist = false)
  private UserInfoVO createUser;
  @Schema(description = "标题")
  private String title;
  @Schema(description = "内容")
  private String context;
  @Schema(description = "图片")
  private String storyImg;
  @Schema(description = "浏览量")
  private Integer storyView;
  @Schema(description = "点赞量")
  private Integer storyLike;
  @Schema(description = "评论量")
  private Integer storyComments;
  @Schema(description = "分享量")
  private Integer storyShare;
  @Schema(description = "是否公开")
  private Boolean isOpen;
}