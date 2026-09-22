/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.guides.springboot2.springpropertysourceexample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // Khởi tạo Spring IoC Container và nạp ProperySourceDemo
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(ProperySourceDemo.class);

        // Đóng Container sau khi chạy xong
        context.close();
    }
}
