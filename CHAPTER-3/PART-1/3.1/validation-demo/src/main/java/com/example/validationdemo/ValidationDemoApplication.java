/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.validationdemo;


/**
 *
 * @author Hi
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValidationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationDemoApplication.class, args);
    }
// run file nay va dung postman post request http://localhost:8080/api/products
    //se ra
//    {
//    "timestamp": "2026-10-03T21:27:21.0504715",
//    "status": 400,
//    "errors": [
//        {
//            "message": "Price cannot be null",
//            "field": "price"
//        },
//        {
//            "message": "Category ID is required",
//            "field": "categoryId"
//        }
//    ]
//}
}
