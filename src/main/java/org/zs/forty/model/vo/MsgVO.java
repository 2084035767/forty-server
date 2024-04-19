package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "信息响应")
public class MsgVO implements Serializable {
        @Serial private static final long serialVersionUID = 1L;
        /**
         * 是否归档=0否 1是
         */
        @Schema(description = "是否归档")
        private long isArchive;
        @Schema(description = "是否删除")
        private long isDelete;

        /**
         * 是否已读=0否 1是
         */
        @Schema(description = "是否已读")
        private long isRead;
        private long msgid;
        /**
         * 消息内容
         */
        @Schema(description = "消息内容")
        private String msgContent;
        /**
         * 消息的类型 0系统通知，1私信
         */
        @Schema(description = "消息类型")
        private long msgType;
        /**
         * 接收者
         */
        @Schema(description = "接收者")
        private long receiverid;
        /**
         * 发送者
         */
        @Schema(description = "发送者")
        private long senderid;
    }

