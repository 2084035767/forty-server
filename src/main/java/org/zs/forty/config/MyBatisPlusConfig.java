package org.zs.forty.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.zs.forty.handler.MyMetaObjectHandler;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/25
 * @Description:
 **/
// @Configuration
public class MyBatisPlusConfig {
  @Bean
  public MetaObjectHandler metaObjectHandler() {
    return new MyMetaObjectHandler();
  }
}