package org.zs.forty.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/5
 * @Description:
 **/
@Getter
@Schema(description = "邮件参数")
public class MailDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  @Schema(description = "发送者")
  private String to;
  @Schema(description = "接收者")
  private String subject;
  @Schema(description = "邮件内容")
  private String content;
  @Schema(description = "附件路径")
  private String filePath;
}