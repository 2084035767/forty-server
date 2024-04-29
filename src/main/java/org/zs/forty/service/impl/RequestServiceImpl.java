package org.zs.forty.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.springframework.stereotype.Service;
import org.zs.forty.service.MyRequestService;

@Service
public class RequestServiceImpl implements MyRequestService {
  @Override public String getAiRequest(String content) {
    String JSON = "{content:" + content + "}";
    String body = HttpRequest.post("http://localhost/ai").body(JSON).execute().body();
    if (!body.isEmpty()) {
      return body;
    }
    return null;
  }
  
  @Override public String getYanRequest() {
    String yan = HttpUtil.get("http://localhost/yan");
    if (!yan.isEmpty()) {
      return yan;
    }
    return null;
  }
}