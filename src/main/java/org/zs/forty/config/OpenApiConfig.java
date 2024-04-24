package org.zs.forty.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import java.util.Collections;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * -*- coding: utf-8 -*-
 *
 * @author: 子十
 * @date: 2024/3/23
 * @description: Swagger3 配置
 **/
@Configuration
public class OpenApiConfig {
  private static final String TOKEN_HEADER = "Authorization";
  
  @Bean
  public OpenAPI openApi() {
    return new OpenAPI()
        .components(
            new Components().addSecuritySchemes(TOKEN_HEADER,
                new SecurityScheme()
                    .type(SecurityScheme.Type.APIKEY)
                    // 这里配置 bearer 后，你的请求里会自动在 token 前加上 Bearer
                    .scheme("bearer")
                    .bearerFormat("JWT")
            ).addParameters(TOKEN_HEADER,
                new Parameter()
                    .in("header")
                    .schema(new StringSchema())
                    .name(TOKEN_HEADER)
            ))
        .info(
            new Info()
                .title("Forty API 文档")
                .description("Forty API 文档，- 子十")
                .contact(new Contact().name("子十").email("2084035767@qq.com").url(""))
                .version("1.0.0")
        );
  }
  
  /**
   * GroupedOpenApi 是对接口文档分组，类似于 swagger 的 Docket
   */
  @Bean
  public GroupedOpenApi authApi() {
    return GroupedOpenApi.builder()
        // 组名
        .group("认证接口")
        // 扫描的路径，支持通配符
        // .pathsToMatch("/login")
        // 扫描的包
        .packagesToScan("org.zs.forty.controller")
        .build();
  }
  
  @Bean
  public GroupedOpenApi sysApi() {
    return GroupedOpenApi.builder()
        .group("系统接口")
        .pathsToMatch("/sys/**")
        // 添加自定义配置，这里添加了一个用户认证的 header，否则 knife4j 里会没有 header
        .addOperationCustomizer((operation, handlerMethod) -> operation.security(
            Collections.singletonList(new SecurityRequirement().addList(TOKEN_HEADER)))
        )
        .build();
  }
}