package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "日志响应")
public class LogVO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

     /**
         * IP地址
         */
        @Schema(description = "ip地址")
        private String ipAdd;
        @Schema(description = "日志id")
        private long logid;
        @Schema(description = "日志等级")

        /**
         * 日志等级 0信息，1警告
         */
        private long logLevel;
        /**
         * 日志名称
         */
        @Schema(description = "日志名称")
        private String logName;
        /**
         * 日志消息
         */
        @Schema(description = "日志信息")
        private String message;
        /**
         * 用户ID
         */
        @Schema(description = "用户ID")
        private long userid;
}
