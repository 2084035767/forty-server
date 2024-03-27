package org.zs.forty.handler;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ValidationException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zs.forty.common.enums.StatusEnum;
import org.zs.forty.common.exception.BaseException;
import org.zs.forty.model.vo.ResultVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/18
 * @description: 全局异常处理
 **/
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
  
  /**
   * 参数校验异常处理
   */
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({MethodArgumentNotValidException.class, ValidationException.class,
      BindException.class})
  public ResultVO<Object> validExceptionHandler(Exception e) {
    String failMsg = null;
    log.warn("参数异常: {}", e.getMessage());
    if (e instanceof MethodArgumentNotValidException) {
      failMsg = Objects.requireNonNull(((MethodArgumentNotValidException) e).getBindingResult()
              .getFieldError())
          .getDefaultMessage();
    }
    return ResultVO.error(StatusEnum.PARAM_TYPE_BIND_ERROR,
        failMsg == null ? e.getMessage() : failMsg);
  }
  
  /**
   * 自定义异常处理
   */
  @ExceptionHandler(BaseException.class)
  public ResultVO<Object> handlerBaseException(HttpServletResponse response, BaseException e) {
    log.error("请求异常：", e);
    return ResultVO.error(StatusEnum.SYSTEM_INNER_ERROR, e.getMessage());
  }
  
  /**
   * 其他异常处理
   */
  @ExceptionHandler(Exception.class)
  public ResultVO<Object> exceptionHandler(Exception e) {
    log.warn("其他异常: {}", e.getMessage());
    return ResultVO.error(StatusEnum.SYSTEM_INNER_ERROR, e.getMessage());
  }
}