package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "排行榜响应")
public class RankVO implements Serializable {
    private long rankid;
    @Schema(description = "商品ID")
    private long productid;
    @Schema(description = "排行名")
    private String rankName;
    @Schema(description = "排名")
    private long rankPosition;
    @Schema(description = "分数")
    private long rankScore;
    @Schema(description = "用户ID")
    private long userid;
}
