package org.zs.forty.service;

import org.zs.forty.model.dto.EmailDTO;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/26
 * @description:
 **/

public interface MailService {
  /**
   * 发送文本邮件
   *
   * @param to      收件人
   * @param subject 主题
   * @param content 内容
   */
  void sendSimpleMail(String to, String subject, String content);
  
  /**
   * 发送HTML邮件
   *
   * @param to      收件人
   * @param subject 主题
   * @param content 内容
   */
  void sendHtmlMail(String to, String subject, String content);
  
  /**
   * 发送带附件的邮件
   *
   * @param to       收件人
   * @param subject  主题
   * @param content  内容
   * @param filePath 附件
   */
  void sendAttachmentsMail(String to, String subject, String content, String filePath);
  
  /**
   * 发送模板邮件
   *
   * @param to       收件人
   * @param subject  主题
   * @param emailDTO 邮件内容
   */
  void sendModelMail(String to, String subject, EmailDTO emailDTO);
}