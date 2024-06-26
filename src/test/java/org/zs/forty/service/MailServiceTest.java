package org.zs.forty.service;

import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.zs.forty.model.dto.EmailDTO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/27
 * @description:
 **/
@SpringBootTest
class MailServiceTest {
  @Resource
  private MailService mailService;
  
  @Test
  void sendSimpleMail() {
    System.out.println(RandomUtil.randomNumbers(6));
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
    mailService.sendModelMail("2084035767@qq.com", "注册成功", emailDTO);
  }
}