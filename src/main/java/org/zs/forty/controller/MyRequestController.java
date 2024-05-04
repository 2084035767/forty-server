package org.zs.forty.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zs.forty.model.dto.AiReqDTO;
import org.zs.forty.service.MyRequestService;

@Tag(name = "第三方请求")
@RequestMapping("/api/my")
@RestController
public class MyRequestController {
  @Resource
  private MyRequestService myRequestService;
  
  @PostMapping(value = "/ai")
  public String getAiRequest(@RequestBody AiReqDTO aiReqDTO) {
    return myRequestService.getAiRequest(aiReqDTO.getContent()).replace("\"", "");
  }
  
  @GetMapping(value = "/yan")
  public String getYanRequest() {
    return myRequestService.getYanRequest().replace("\"", "");
  }
}