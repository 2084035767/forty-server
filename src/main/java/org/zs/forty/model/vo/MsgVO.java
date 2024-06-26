package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "信息响应")
public class MsgVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long msgId;
  @Schema(description = "消息内容")
  private String msgContent;
  @Schema(description = "消息类型")
  private int msgType;
  @Schema(description = "接收者ID")
  private Long receiverId;
  @Schema(description = "发送者")
  private UserInfoVO sender;
  @Schema(description = "发送者ID")
  private Long senderId;
  @Schema(description = "是否归档")
  private Boolean isArchive;
  @Schema(description = "是否已读")
  private Boolean isRead;
  @Schema(description = "是否删除")
  private Boolean isDelete;
}