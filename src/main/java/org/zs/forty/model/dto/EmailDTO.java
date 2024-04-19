package org.zs.forty.model.dto;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/27
 * @description:
 **/
@Data
public class EmailDTO implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private String nickname;// 用户昵称
  private String email;// 收件人
}