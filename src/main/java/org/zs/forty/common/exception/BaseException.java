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
public class BaseException extends RuntimeException {
  public BaseException(String message, Throwable cause) {
    super(message, cause);
  }
  
  public BaseException(Throwable cause) {
    super(cause);
  }
  
  protected BaseException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
  
  public BaseException(String message) {
    super(message);
  }
}