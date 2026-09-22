/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationJavaConfig {
    public static void main(String[] args) {
        // 1. Khởi tạo Spring IoC Container bằng Java Config
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Lấy Bean từ Container ra sử dụng
        GreetingService greetingService = (GreetingService) context.getBean("greetingService");
        greetingService.getMessage();

        // 3. Đóng Container
        ((AnnotationConfigApplicationContext) context).close();
    }
}
