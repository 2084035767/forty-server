package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Schema(description = "通知参数")
public class MsgDTO implements Serializable {
        @Schema(description = "通知id")
        @NotNull(message = "通知id不能为空")
        private long msgid;
        /**
         * 发送者
         */
        @Schema(description = "发送者")
        @NotNull(message = "发送者不能为空")
        private long senderid;
        /**
         * 接收者
         */
        @Schema(description = "接受者")
        @NotNull(message = "接受者不能为空")
        private long receiverid;
        /**
         * 消息内容
         */
        @Schema(description = "消息内容")
        @NotNull(message = "消息内容不能为空")
        private String msgContent;
        /**
         * 消息的类型 0系统通知，1私信
         */
        @Schema(description = "消息类型")
        private long msgType;
        /**
         * 是否已读=0否 1是
         */
        @Schema(description = "是否已读")
        private long isRead;
        /**
         * 是否归档=0否 1是
         */
        @Schema(description = "是否归档")
        private long isArchive;
        /**
         * 是否删除=0否 1是
         */
        @Schema(description = "是否删除")
        private long isDelete;

    }

