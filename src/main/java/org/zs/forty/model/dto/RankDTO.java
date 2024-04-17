package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
// @Builder
@Schema(description = "排行榜参数")
public class RankDTO implements Serializable {
    @Serial private static final long serialVersionUID = 1L;
    /**
     * 商品ID
     */
    @Schema(description = "商品id")
    @NotNull(message = "商品id不能为空")
    private long productid;
    @Schema(description = "排行榜id")
    private long rankid;
    /**
     * 排行名
     */
    @Schema(description = "排行名")
    @NotNull(message = "排行名不能为空")
    private String rankName;
    /**
     * 排名
     */
    @Schema(description = "排名")
    @NotNull(message = "排名不能为空")
    private long rankPosition;
    /**
     * 分数
     */
    @Schema(description = "分数")
    @NotNull(message = "分数不能为空")
    private long rankScore;
    /**
     * 用户ID
     */
    @Schema(description = "用户ID")
    @NotNull(message = "用户ID不能为空")
    private long userid;
}
