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
@Schema(description = "日志参数")
public class LogDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  @Schema(description = "ip地址")
  private String ipAdd;
  @Schema(description = "日志id")
  private Long logId;
  @Schema(description = "日志等级")
  private int logLevel;
  @Schema(description = "日志名称")
  @NotNull(message = "日志名称不能为空")
  private String logName;
  @Schema(description = "日志消息")
  @NotNull(message = "日志消息不能为空")
  private String message;
  @Schema(description = "用户id")
  @NotNull(message = "用户id不能为空")
  private long userId;
  @Schema(description = "是否删除")
  private Boolean isDelete;
}