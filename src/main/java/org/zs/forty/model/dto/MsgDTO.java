package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@Schema(description = "通知参数")
public class MsgDTO implements Serializable {
        @Schema(description = "通知id")
        @NotNull(message = "通知id不能为空")
        private Long msgId;
        @Schema(description = "发送者")
        @NotNull(message = "发送者不能为空")
        private Long senderId;
        @Schema(description = "接受者")
        @NotNull(message = "接受者不能为空")
        private Long receiverId;
        @Schema(description = "消息内容")
        @NotNull(message = "消息内容不能为空")
        private String msgContent;
        @Schema(description = "消息类型")
        private int msgType;
        @Schema(description = "是否已读")
        private Boolean isRead;
        @Schema(description = "是否归档")
        private Boolean isArchive;
        @Schema(description = "是否删除")
        private Boolean isDelete;

    }

