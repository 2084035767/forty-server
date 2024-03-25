package org.zs.forty.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/21
 * @Description:
 **/
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
  
  // 插入时的填充策略
  @Override
  public void insertFill(MetaObject metaObject) {
    log.info("start insert fill.....");
    this.strictInsertFill(metaObject, "createTime", LocalDateTime::now, LocalDateTime.class);
    this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
  }
  
  // 更新时的填充策略
  @Override
  public void updateFill(MetaObject metaObject) {
    log.info("start update fill.....");
    this.strictInsertFill(metaObject, "updateTime", LocalDateTime::now, LocalDateTime.class);
  }
}