package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Schema(description = "日志参数")
public class LogDTO implements Serializable {
    @Serial private static final long serialVersionUID = 1L;
    /**
     * IP地址
     */
    @Schema(description = "ip地址")
    private String ipAdd;
    @Schema(description = "日志id")
    private Long logid;
    /**
     * 日志等级 0信息，1警告
     */
    @Schema(description = "日志等级")
    private Boolean logLevel;
    /**
     * 日志名称
     */
    @Schema(description = "日志名称")
    @NotNull(message = "日志名称不能为空")
    private String logName;
    /**
     * 日志消息
     */
    @Schema(description = "日志消息")
    @NotNull(message = "日志消息不能为空")
    private String message;
    /**
     * 用户ID
     */
    @Schema(description = "用户id")
    @NotNull(message = "用户id不能为空")
    private long userid;
    @Schema(description = "是否删除")
    private Boolean isDelete;
}
