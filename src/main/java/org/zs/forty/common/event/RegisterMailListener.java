// package org.zs.forty.common.event;
//
// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import java.io.UnsupportedEncodingException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.event.EventListener;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Component;
// import org.thymeleaf.context.Context;
// import org.thymeleaf.spring6.SpringTemplateEngine;
//
// /**
//  * -*- coding: utf-8 -*-
//  *
//  * @Author: 子十
//  * @Date: 2024/3/27
//  * @Description:
//  **/
// @Component
// public class RegisterMailListener {
//   @Value("${spring.mail.username}")
//   private String sender;
//   @Autowired
//   private JavaMailSender mailSender;
//   @Autowired
//   private SpringTemplateEngine templateEngine;
//
//   @EventListener
//   public void sentMail(UserRegisterEvent event)
//       throws MessagingException, UnsupportedEncodingException {
//
//     BaseUser user = event.getUser();
//     MimeMessage message = mailSender.createMimeMessage();
//     MimeMessageHelper helper = new MimeMessageHelper(message, true);
//     // 发件人设置昵称
//     helper.setFrom();
//     // 收件人
//     helper.setTo(user.getEmail());
//     // 邮件标题
//     helper.setSubject("【邮件通知】：初始口令");
//     // 利用Thymeleaf 模板构建HTML文本
//     Context context = new Context();
//     // 给模板的参数的上下文
//     context.setVariable("user", user);
//     // 执行模板引擎，执行模板引擎需要传入模板名、上下文对象
//     // Thymeleaf的默认配置期望所有HTML文件都放在 **resources/templates ** 目录下，以.html扩展名结尾。
//     String emailText = templateEngine.process("email", context);
//     helper.setText(emailText, true);
//     mailSender.send(message);
//   }
// }