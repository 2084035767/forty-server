package org.zs.forty.service.impl;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.zs.forty.model.dto.EmailDTO;
import org.zs.forty.service.MailService;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/26
 * @description:
 **/
@Slf4j
@Service
public class MailServiceImpl implements MailService {
  @Resource
  private JavaMailSender mailSender;
  
  @Resource
  private TemplateEngine templateEngine;
  
  @Value("${spring.mail.from}")
  private String from;
  
  /**
   * 发送简单邮件
   *
   * @param to      收件人
   * @param subject 主题
   * @param content 内容
   */
  @Override
  public void sendSimpleMail(String to, String subject, String content) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(from); // 邮件发送人
    message.setTo(to); // 邮件接收人
    message.setSubject(subject); // 邮件主题
    message.setText(content); // 邮件内容
    mailSender.send(message); // 发送邮件
    log.info("html邮件已经发送"); // 日志信息
  }
  
  /**
   * 发送html邮件
   *
   * @param to      收件人
   * @param subject 主题
   * @param code    验证码
   */
  @Override
  public void sendHtmlMail(String to, String subject, String code) {
    MimeMessage message = mailSender.createMimeMessage();
    String html = """
        <!DOCTYPE html>
        <html lang="zh">
        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>验证码</title>
        </head>
        <body>
            <div style="max-width: 600px; margin: 0 auto; padding: 20px; font-family: Arial, sans-serif;">
                <h2 style="text-align: center;">验证码邮件</h2>
                <p>尊敬的用户，您的验证码是：<strong style="font-size: 20px; color: #007bff;">123456</strong></p>
                <p>请使用上述验证码完成您的操作。</p>
                <p style="margin-top: 20px;">感谢您的使用！</p>
            </div>
        </body>
        </html>""";
    String content = html.replace("123456", code);
    try {
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setFrom(from);
      helper.setTo(to);
      message.setSubject(subject);
      helper.setText(content, true); // 邮件内容，html格式
      mailSender.send(message);
      log.info("html邮件已经发送");
    } catch (MessagingException e) {
      log.error("发送邮件时发生异常！", e);
    }
  }
  
  /**
   * 发送带附件的邮件
   *
   * @param to       收件人
   * @param subject  主题
   * @param content  内容
   * @param filePath 附件路径
   */
  @Override
  public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
    MimeMessage message = mailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(content, true);
      ClassPathResource resource = new ClassPathResource(filePath);
      FileSystemResource file = new FileSystemResource(resource.getFile());
      helper.addAttachment(Objects.requireNonNull(file.getFilename()), file);
      // 可以同时添加多个附件,只需要在这里直接添加第2,第3...附件就行了.
      // helper.addAttachment(fileName2, file2);
      mailSender.send(message);
      log.info("附件邮件已经发送");
    } catch (MessagingException e) {
      log.error("发送邮件时发生异常！", e);
    } catch (IOException e) {
      log.error("发送附件时发生异常！", e);
    }
  }
  
  /**
   * 发送带模板的邮件
   *
   * @param to       收件人
   * @param subject  主题
   * @param emailDTO 邮件参数
   */
  @Override
  public void sendModelMail(String to, String subject, EmailDTO emailDTO) {
    MimeMessage mimeMessage = mailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      Context ctx = new Context();
      // 给模板的参数的上下文
      ctx.setVariable("emailDTO", emailDTO);
      String emailText = templateEngine.process("email", ctx);
      helper.setText(emailText, true);
      mailSender.send(mimeMessage);
      
      log.info("邮件已经发送...");
    } catch (MessagingException e) {
      log.error("发送邮件时发生异常！", e);
    }
  }
}