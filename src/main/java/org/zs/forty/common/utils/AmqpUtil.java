package org.zs.forty.common.utils;

import jakarta.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;
import org.zs.forty.model.dto.EmailDTO;

import static org.zs.forty.config.AmqpConfig.DIRECT_EXCHANGE;
import static org.zs.forty.config.AmqpConfig.EMAIL_QUEUE;
import static org.zs.forty.config.AmqpConfig.FANOUT_EXCHANGE;
import static org.zs.forty.config.AmqpConfig.SIMPLE_QUEUE;
import static org.zs.forty.config.AmqpConfig.TOPIC_EXCHANGE;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/4/1
 * @description:
 **/
@Component
public class AmqpUtil {
  @Resource
  private AmqpTemplate amqpTemplate;
  
  /**
   * 简单模式发送
   */
  public void simpleSend(String message) {
    amqpTemplate.convertAndSend(SIMPLE_QUEUE, message);
  }
  
  public void emailSend(EmailDTO emailDTO) {
    amqpTemplate.convertAndSend(EMAIL_QUEUE, emailDTO);
  }
  
  /**
   * 发布/订阅模式发送
   */
  public void psSend(String message) {
    amqpTemplate.convertAndSend(FANOUT_EXCHANGE, "", message);
  }
  
  /**
   * 路由模式发送
   */
  public void routingSend(String routingKey, String message) {
    amqpTemplate.convertAndSend(DIRECT_EXCHANGE, routingKey, message);
  }
  
  /**
   * 主题模式发送
   */
  public void topicSend(String routingKey, String message) {
    amqpTemplate.convertAndSend(TOPIC_EXCHANGE, routingKey, message);
  }
}