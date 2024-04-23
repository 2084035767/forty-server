package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@Setter
@Schema(description = "点赞参数")
public class LikeDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  private Long likeId;
  @Schema(description = "用户id")
  @NotNull(message = "userid不能为空")
  private Long userId;
  @Schema(description = "故事id")
  @NotNull(message = "story_id不能为空")
  private Long storyId;
  @Schema(description = "是否删除")
  private Boolean isDelete;
}