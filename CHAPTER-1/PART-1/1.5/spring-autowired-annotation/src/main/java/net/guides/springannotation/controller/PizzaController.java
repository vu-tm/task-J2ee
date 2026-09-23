/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.guides.springannotation.controller;

/**
 *
 * @author Hi
 */
import net.guides.springannotation.service.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class PizzaController {
    @Autowired
    @Qualifier("vegPizza")
    private Pizza pizza;
    // contstrutor ịnjection
//    @Autowired
//    public PizzaController(@Qualifier("vegPizza") Pizza pizza){
//        System.out.println("inside pizza controller constructor");
//        this.pizza=pizza;
//    }
    
    //setter injection
//    @Autowired
//    @Qualifier("vegPizza")
//    public void setPizza(Pizza pizza){
//        System.out.println("SET PIZZA duoc goi!");
//        this.pizza = pizza;
//               //neu goi ham nay thi se set doi tuong pizza co kieu VegPizza 
//        
//    }
    public String getPizza(){
        return pizza.getPizza();
    }
}
