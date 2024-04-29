package org.zs.forty.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/4/1
 * @description:
 **/
@Configuration
public class AmqpConfig {
  //=============简单、工作队列模式===============
  
  public static final String SIMPLE_QUEUE = "simple_queue";
  public static final String EMAIL_QUEUE = "email_queue";
  public static final String CODE_EMAIL_QUEUE = "code_email_queue";
  public static final String CODE_EMAIL_EXCHANGE = "code_email_queue_exchange";
  public static final String EMAIL_EXCHANGE = "email_queue_exchange";
  
  @Bean
  public DirectExchange exchange1() {
    return new DirectExchange(EMAIL_EXCHANGE);
  }
  
  @Bean
  public Binding binding1(Queue emailQueue, DirectExchange exchange1) {
    return BindingBuilder.bind(emailQueue).to(exchange1).with("email");
  }
  
  @Bean
  public DirectExchange exchange2() {
    return new DirectExchange(CODE_EMAIL_EXCHANGE);
  }
  
  @Bean
  public Binding binding2(Queue codeEmotionQueue, DirectExchange exchange2) {
    return BindingBuilder.bind(codeEmotionQueue).to(exchange2).with("code_email");
  }
  
  @Bean
  public Queue queue() {
    return new Queue(SIMPLE_QUEUE, true);
  }
  
  @Bean
  public Queue emailQueue() {
    return new Queue(EMAIL_QUEUE, true);
  }
  
  @Bean
  public Queue codeEmotionQueue() {
    return new Queue(CODE_EMAIL_QUEUE, true);
  }
  //
  // //===============发布/订阅模式============
  //
  // public static final String PS_QUEUE_1 = "ps_queue_1";
  // public static final String PS_QUEUE_2 = "ps_queue_2";
  // public static final String FANOUT_EXCHANGE = "fanout_exchange";
  //
  // @Bean
  // public Queue psQueue1() {
  //   return new Queue(PS_QUEUE_1, true);
  // }
  //
  // @Bean
  // public Queue psQueue2() {
  //   return new Queue(PS_QUEUE_2, true);
  // }
  //
  // @Bean
  // public FanoutExchange fanoutExchange() {
  //   return new FanoutExchange(FANOUT_EXCHANGE);
  // }
  //
  // @Bean
  // public Binding fanoutBinding1() {
  //   return BindingBuilder.bind(psQueue1()).to(fanoutExchange());
  // }
  //
  // @Bean
  // public Binding fanoutBinding2() {
  //   return BindingBuilder.bind(psQueue2()).to(fanoutExchange());
  // }
  //
  // //===============路由模式============
  //
  // public static final String ROUTING_QUEUE_1 = "routing_queue_1";
  // public static final String ROUTING_QUEUE_2 = "routing_queue_2";
  // public static final String DIRECT_EXCHANGE = "direct_exchange";
  //
  // @Bean
  // public Queue routingQueue1() {
  //   return new Queue(ROUTING_QUEUE_1, true);
  // }
  //
  // @Bean
  // public Queue routingQueue2() {
  //   return new Queue(ROUTING_QUEUE_2, true);
  // }
  //
  // @Bean
  // public DirectExchange directExchange() {
  //   return new DirectExchange(DIRECT_EXCHANGE);
  // }
  //
  // @Bean
  // public Binding directBinding1() {
  //   return BindingBuilder.bind(routingQueue1()).to(directExchange()).with("user");
  // }
  //
  // @Bean
  // public Binding directBinding2() {
  //   return BindingBuilder.bind(routingQueue2()).to(directExchange()).with("order");
  // }
  //
  // //===============主题模式============
  //
  // public static final String TOPIC_QUEUE_1 = "topic_queue_1";
  // public static final String TOPIC_QUEUE_2 = "topic_queue_2";
  // public static final String TOPIC_EXCHANGE = "topic_exchange";
  //
  // @Bean
  // public Queue topicQueue1() {
  //   return new Queue(TOPIC_QUEUE_1, true);
  // }
  //
  // @Bean
  // public Queue topicQueue2() {
  //   return new Queue(TOPIC_QUEUE_2, true);
  // }
  //
  // @Bean
  // public TopicExchange topicExchange() {
  //   return new TopicExchange(TOPIC_EXCHANGE);
  // }
  //
  // @Bean
  // public Binding topicBinding1() {
  //   return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("user.add");
  // }
  //
  // @Bean
  // public Binding topicBinding2() {
  //   return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("user.#");
  // }
}