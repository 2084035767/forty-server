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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Log {
    @TableId(value = "id", type = IdType.AUTO)
    /**
     * IP地址
     */
    private String ipAdd;
    /**
     * 是否删除=0否 1是
     */
    private Boolean isDelete;

    private long logid;
    /**
     * 日志等级 0信息，1警告
     */
    private long logLevel;
    /**
     * 日志名称
     */
    private String logName;
    /**
     * 日志消息
     */
    private String message;
    /**
     * 用户ID
     */
    private long userid;
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;
}
