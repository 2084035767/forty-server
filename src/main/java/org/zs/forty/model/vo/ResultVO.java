package org.zs.forty.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import org.zs.forty.common.enums.StatusEnum;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/1/14
 * @description: 统一响应结果
 **/
@Data
@Schema(description = "统一响应结果")
public class ResultVO<T> implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  
  @Schema(description = "响应状态")
  private Boolean success;
  @Schema(description = "响应状态码")
  private Integer code;
  @Schema(description = "响应信息")
  private String msg;
  @Schema(description = "响应数据")
  private T data;
  
  public ResultVO(StatusEnum statusEnum) {
    this.success = statusEnum.code == 200;
    this.code = statusEnum.code;
    this.msg = statusEnum.msg;
  }
  
  public ResultVO(StatusEnum statusEnum, T data) {
    this.success = statusEnum.code == 200;
    this.code = statusEnum.code;
    this.msg = statusEnum.msg;
    this.data = data;
  }
  
  public ResultVO(Integer code, String msg) {
    this.success = code == 200;
    this.code = code;
    this.msg = msg;
  }
  
  /**
   * 封装成功响应的方法
   *
   * @param data 响应数据
   * @return ResultVO
   */
  
  public static <T> ResultVO<T> success(T data) {
    return new ResultVO<>(StatusEnum.SUCCESS, data);
  }
  
  /**
   * 封装成功响应的方法
   *
   * @return ResultVO
   */
  public static <T> ResultVO<T> success() {
    
    return new ResultVO<>(StatusEnum.SUCCESS);
  }
  
  public static <T> ResultVO<T> success(StatusEnum statusEnum, String msg) {
    return new ResultVO<>(statusEnum.getCode(), msg);
  }
  
  /**
   * 封装error的响应
   *
   * @param statusEnum error响应的状态值
   * @return ResultVO
   */
  public static <T> ResultVO<T> error(StatusEnum statusEnum) {
    return new ResultVO<T>(statusEnum);
  }
  
  public static <T> ResultVO<T> error() {
    return new ResultVO<>(StatusEnum.SYSTEM_INNER_ERROR);
  }
  
  /**
   * 封装error的响应  可自定义错误信息
   *
   * @param statusEnum error响应的状态值
   * @param errorMsg   自定义错误信息
   * @return ResultVO
   */
  public static <T> ResultVO<T> error(StatusEnum statusEnum, String errorMsg) {
    return new ResultVO<>(statusEnum.code, errorMsg);
  }
}