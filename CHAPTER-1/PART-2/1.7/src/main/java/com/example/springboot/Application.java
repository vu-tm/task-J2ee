package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  /*
  * Code chạy khi Spring Boot khởi động xong
  * Lấy và in danh sách các Bean mà Spring Boot đã tạo
  *  + ctx.getBeanDefinitionNames() lấy danh sách tên các bean trong Spring.
  *  + String[] beanNames lưu danh sách đó vào mảng chuỗi.
  *  + Arrays.sort(beanNames) sắp xếp mảng theo thứ tự alphabet.
  * */
  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {
      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }
    };
  }
}

/*
* ./gradlew bootRun
* Let's inspect the beans provided by Spring Boot:
* application
* applicationAvailability
* applicationTaskExecutor
* applicationTaskExecutorAsyncConfigurer
* basicErrorController
* beanNameHandlerMapping
  ...
* */