package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Schema(description = "通知参数")
public class MsgConditionDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  @Schema(description = "接受者")
  @NotNull(message = "接受者不能为空")
  private Long receiverId;
  @Schema(description = "消息类型")
  @NotNull(message = "消息类型不能为空")
  private int msgType;
}