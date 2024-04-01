package org.zs.forty.model.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/27
 * @Description:
 **/
@Data
public class EmailDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private String nickname;// 用户昵称
  private String email;// 收件人
}