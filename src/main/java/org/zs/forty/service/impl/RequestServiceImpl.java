package org.zs.forty.service.impl;

import java.util.HashMap;
import org.springframework.stereotype.Service;
import org.zs.forty.common.utils.RestTemplateUtil;
import org.zs.forty.service.MyRequestService;

@Service
public class RequestServiceImpl implements MyRequestService {
  
  @Override public String getAiRequest(String content) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("question", content);
    return RestTemplateUtil.post("http://localhost:8081/ai", map);
  }
  
  @Override public String getYanRequest() {
    return RestTemplateUtil.get("http://localhost:8081/yan");
  }
}