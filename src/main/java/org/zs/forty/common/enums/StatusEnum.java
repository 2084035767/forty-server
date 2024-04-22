package org.zs.forty.common.enums;

import lombok.Getter;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/14
 * @description: 状态码枚举
 **/
@Getter
public enum StatusEnum {
  /* 成功状态码 */
  SUCCESS(200, "成功"),
  /* 参数错误：400 Bad Request */
  PARAM_IS_INVALID(400, "参数无效"),
  PARAM_IS_BLANK(400, "参数为空"),
  PARAM_TYPE_BIND_ERROR(400, "参数类型错误"),
  PARAM_NOT_COMPLETE(400, "参数缺失"),
  /* 用户错误：401 Unauthorized */
  USER_NOT_LOGGED_IN(401, "用户未登录"),
  USER_LOGIN_ERROR(401, "账号不存在或密码错误"),
  PERMISSION_NO_ACCESS(403, "无访问权限"),
  USER_ACCOUNT_FORBIDDEN(403, "账号已被禁用"),
  USER_NOT_EXIST(404, "用户不存在"),
  USER_HAS_EXISTED(409, "用户已存在"),
  /* 业务错误：422 Processable Entity */
  SPECIFIED_QUESTIONED_USER_NOT_EXIST(422, "某业务出现问题"),
  /* 系统错误：500 Internal Server Error */
  SYSTEM_INNER_ERROR(500, "系统繁忙，请稍后重试"),
  /* 数据错误：404 Not Found */
  RESULT_DATA_NONE(404, "数据未找到"),
  DATA_IS_WRONG(400, "数据有误"),
  DATA_ALREADY_EXISTED(409, "数据已存在"),
  /* 接口错误：503 Service Unavailable */
  INTERFACE_INNER_INVOKE_ERROR(503, "内部系统接口调用异常"),
  INTERFACE_OUTER_INVOKE_ERROR(503, "外部系统接口调用异常"),
  INTERFACE_FORBID_VISIT(403, "该接口禁止访问"),
  INTERFACE_ADDRESS_INVALID(404, "接口地址无效"),
  INTERFACE_REQUEST_TIMEOUT(408, "接口请求超时"),
  INTERFACE_EXCEED_LOAD(503, "接口负载过高");
  /* 权限错误：403 Forbidden */
  
  public final Integer code;
  
  public final String msg;
  
  StatusEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}