package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@Builder
@Schema(description = "排行榜参数")
public class RankDTO implements Serializable {
    @Serial private static final long serialVersionUID = 1L;
    @Schema(description = "商品id")
    @NotNull(message = "商品id不能为空")
    private Long productId;
    @Schema(description = "排行榜id")
    private Long rankId;
    @Schema(description = "排行名")
    @NotNull(message = "排行名不能为空")
    private String rankName;
    @Schema(description = "排名")
    @NotNull(message = "排名不能为空")
    private Long rankPosition;
    @Schema(description = "分数")
    @NotNull(message = "分数不能为空")
    private Long rankScore;
    @Schema(description = "用户ID")
    @NotNull(message = "用户ID不能为空")
    private Long userId;
    @Schema(description = "故事ID数组")
    @NotNull(message = "故事ID数组不能为空")
    private String storyIds;
}
