package org.zs.forty.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import java.lang.annotation.Annotation;
import java.util.Objects;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.zs.forty.common.annotate.ResponseIgnore;
import org.zs.forty.model.vo.ResultVO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/21
 * @description: 统一返回结果处理类
 **/
@RestControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {
  @Resource
  private ObjectMapper objectMapper;
  
  private static final Class<? extends Annotation>
      ANNOTATION_TYPE = ResponseIgnore.class;
  
  /**
   * 判断类或者方法是否使用了 ResponseResult 注解
   */
  @Override
  public boolean supports(MethodParameter returnType,
      Class<? extends HttpMessageConverter<?>> converterType) {
    
    return !AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE)
        && !returnType.hasMethodAnnotation(ANNOTATION_TYPE);
  }
  
  /**
   * 当类或者方法使用了 ResponseResult 注解 不会调用这个方法
   */
  @SneakyThrows
  @Override
  public Object beforeBodyWrite(Object body, MethodParameter returnType,
      MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType,
      ServerHttpRequest request, ServerHttpResponse response) {
    // 如果返回类型是string，那么springmvc是直接返回的，此时需要手动转化为json
    // 当body都为null时，下面的if判断条件都不满足，如果接口返回类似为String，会报错com.shepherd.fast.global.ResponseVO cannot be cast to java.lang.String
    Class<?> returnClass = Objects.requireNonNull(returnType.getMethod()).getReturnType();
    
    if (body instanceof String || Objects.equals(returnClass, String.class)) {
      return objectMapper.writeValueAsString(ResultVO.success(body));
    }
    // 防止重复包裹的问题出现
    if (body instanceof ResultVO) {
      return body;
    }
    return ResultVO.success(body);
  }
}