/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.example.validation.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Hi
 */
@SpringBootApplication
public class ValidationDemo {
//file nay dung de chay springboot
    public static void main(String[] args) {
        SpringApplication.run(ValidationDemo.class, args);
    }
    //su dung postman de test
//    {
//    "firstName": "",
//    "lastName": "",
//    "email": "abc",
//    "password": "12"
//    }
//    {
//    "firstName": "Minh",
//    "lastName": "Thuan",
//    "email": "thuan@gmail.com",
//    "password": "123456"
//    }
}
