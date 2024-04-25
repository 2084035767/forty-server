package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "日志响应")
public class LogVO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;
  
  @Schema(description = "日志id")
  private Long logId;
  @Schema(description = "日志等级")
  private int logLevel;
  @Schema(description = "日志名称")
  private String logName;
  @Schema(description = "日志信息")
  private String message;
  @Schema(description = "用户ID")
  private Long userId;
  @Schema(description = "ip地址")
  private String ipAdd;
}