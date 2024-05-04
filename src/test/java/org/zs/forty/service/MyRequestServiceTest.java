package org.zs.forty.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyRequestServiceTest {
  @Resource private MyRequestService myRequestService;
  
  @Test
  void getAiRequest() {
    String request = myRequestService.getAiRequest("你好");
    System.out.println(request);
  }
  
  @Test
  void getYanRequest() {
  }
}