package org.zs.forty.common.consumer;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.zs.forty.model.dto.EmailDTO;
import org.zs.forty.model.dto.ForgetDTO;
import org.zs.forty.service.MailService;

import static org.zs.forty.config.AmqpConfig.CODE_EMAIL_QUEUE;
import static org.zs.forty.config.AmqpConfig.EMAIL_QUEUE;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/4/1
 * @description:
 **/
@Slf4j
@Component
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
  
  @RabbitListener(queues = CODE_EMAIL_QUEUE)
  public void codeEmailReceive(ForgetDTO forumDTO) {
    mailService.sendHtmlMail(forumDTO.getEmail(), "重置验证码", forumDTO.getCode());
    log.info("邮件发送成功");
  }
}