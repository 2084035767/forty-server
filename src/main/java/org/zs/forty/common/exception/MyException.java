package org.zs.forty.common.exception;

import lombok.NoArgsConstructor;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/23
 * @description: 自定义异常
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