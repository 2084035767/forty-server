package org.zs.forty.common.utils;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.EmailDTO;
import org.zs.forty.service.MailService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/23
 * @description:
 **/
@SpringBootTest
class MailUtilTest {
  @Resource
  private MailService mailService;
  
  @Test
  void sendSampleMail() {
    EmailDTO emailDTO = new EmailDTO();
    emailDTO.setNick("傻子");
    mailService.sendModelMail("2084035767@qq.com", "注册成功", emailDTO);
  }
  
  @Test
  void sendAttachmentMail() {
  }
  
  @Test
  void sendTemplateMail() {
  }
}