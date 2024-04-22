package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "点赞响应")
public class LikeVO implements Serializable {
    @Serial private static final long serialVersionUID = 1L;
    private Long likeId;
    @Schema(description = "用户id")
    private Long userId;
    @Schema(description = "故事id")
    private Long storyId;


}