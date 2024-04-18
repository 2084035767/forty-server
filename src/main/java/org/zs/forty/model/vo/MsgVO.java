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
        @Schema(description = "是否归档")
        private Boolean isArchive;
        @Schema(description = "是否删除")
        private Boolean isDelete;
        @Schema(description = "是否已读")
        private Boolean isRead;
        private Long msgId;
        @Schema(description = "消息内容")
        private String msgContent;
        @Schema(description = "消息类型")
        private Long msgType;
        @Schema(description = "接收者")
        private Long receiverId;
        @Schema(description = "发送者")
        private Long senderId;
    }

