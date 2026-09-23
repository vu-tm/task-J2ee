/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.guides.springannotation.service;
import org.springframework.stereotype.Component;
/**
 *
 * @author Hi
 */
@Component
public class VegPizza implements Pizza{
    

    @Override
    public String getPizza() {
        return "Veg pizza";
    }
}
