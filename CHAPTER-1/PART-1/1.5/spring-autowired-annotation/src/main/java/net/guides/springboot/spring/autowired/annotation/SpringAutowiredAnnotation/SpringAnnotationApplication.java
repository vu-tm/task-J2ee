package net.guides.springboot.spring.autowired.annotation.SpringAutowiredAnnotation;


import net.guides.springannotation.controller.PizzaController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

@SpringBootApplication(scanBasePackages = "net.guides")
public class SpringAnnotationApplication {
    public static void main(String[] args) {
        var context = SpringApplication.run(SpringAnnotationApplication.class,args);
        System.out.println("calling pizzaController.getPizza()");
        PizzaController pizzaController = context.getBean(PizzaController.class);
        String message = pizzaController.getPizza();
        System.out.println(message);
    }
}
