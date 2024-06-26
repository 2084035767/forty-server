package org.zs.forty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("org.zs.forty.mapper")
@EnableTransactionManagement
@SpringBootApplication
public class FortyApplication {
  
  public static void main(String[] args) {
    SpringApplication.run(FortyApplication.class, args);
  }
}