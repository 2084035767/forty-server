package org.zs.forty.common.utils;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class RestTemplateUtil {
  public static String post(String url, Map<String, Object> parameter) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters()
        .set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<Map<String, Object>> r =
        new HttpEntity<>(parameter, requestHeaders);
    return restTemplate.postForObject(url, r, String.class);
  }
  
  /**
   * get请求
   *
   * @param url 请求路径
   * @return 返回值
   */
  public static String get(String url) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getMessageConverters()
        .set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    //        log.info("远程调用结果，body为：{}", body);
    return restTemplate.getForEntity(url, String.class).getBody();
  }
}