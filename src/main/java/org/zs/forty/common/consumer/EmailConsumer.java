package org.zs.forty.common.consumer;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.zs.forty.model.dto.EmailDTO;
import org.zs.forty.service.MailService;

import static org.zs.forty.config.AmqpConfig.EMAIL_QUEUE;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/4/1
 * @description:
 **/

@Component
@Slf4j
public class EmailConsumer {
  @Resource private MailService mailService;
  
  /**
   * 简单模式接收
   */
  @RabbitListener(queues = EMAIL_QUEUE)
  public void emailReceive(EmailDTO emailDTO) {
    mailService.sendModelMail(emailDTO.getEmail(), "注册成功", emailDTO);
    log.info("邮件发送成功");
  }
}