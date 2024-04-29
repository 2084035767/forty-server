package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

@Data
public class LoginUserVO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private Long id;
  @Schema(description = "用户名")
  private String username;
  @Schema(description = "昵称")
  private String nickname;
  @Schema(description = "邮件")
  private String email;
  @Schema(description = "地址")
  private String userAdd;
  @Schema(description = "电话")
  private String userPhone;
  @Schema(description = "性别")
  private Integer userSex;
  @Schema(description = "年龄")
  private Integer userAge;
  @Schema(description = "头像")
  private String userImg;
  @Schema(description = "令牌")
  private String token;
}