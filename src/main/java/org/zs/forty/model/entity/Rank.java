package org.zs.forty.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rank {
    @TableId(value = "id", type = IdType.AUTO)
    /**
     * 是否删除
     */
    private long isDelete;
    /**
     * 商品ID
     */
    private long productid;
    private long rankid;
    /**
     * 排行名
     */
    private String rankName;
    /**
     * 排名
     */
    private long rankPosition;
    /**
     * 分数
     */
    private long rankScore;
    /**
     * 用户ID
     */
    private long userid;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;
}
