package org.zs.forty.common.exception;

import lombok.NoArgsConstructor;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/23
 * @Description:
 **/
@NoArgsConstructor
public class MyException extends RuntimeException {
  
  public MyException(String message) {
    super(message);
  }
  
  public MyException(String message, Throwable cause) {
    super(message, cause);
  }
  
  public MyException(Throwable cause) {
    super(cause);
  }
  
  protected MyException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}