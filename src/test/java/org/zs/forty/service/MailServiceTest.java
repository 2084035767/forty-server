package org.zs.forty.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.EmailDTO;

/**
 * -*- coding: utf-8 -*-
 *
 * @Author: 子十
 * @Date: 2024/3/27
 * @Description:
 **/
@SpringBootTest
class MailServiceTest {
  @Resource
  private MailService mailService;
  
  @Test
  void sendSimpleMail() {
  }
  
  @Test
  void sendHtmlMail() {
  }
  
  @Test
  void sendAttachmentsMail() {
  }
  
  @Test
  void sendModelMail() {
    EmailDTO emailDTO = new EmailDTO();
    emailDTO.setNick("傻子");
    mailService.sendModelMail("2084035767@qq.com", "注册成功", emailDTO);
  }
}