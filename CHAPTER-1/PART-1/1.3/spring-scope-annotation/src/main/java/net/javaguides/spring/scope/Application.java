/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.javaguides.spring.scope;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 *
 * @author Hi
 */
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService messageService = context.getBean(MessageService.class);
        messageService.setMessage("TwitterMessageService Implementation");
        System.out.println(messageService.getMessage());
        
        MessageService messageService1 = context.getBean(MessageService.class);
        System.out.println(messageService1.getMessage());
        context.close();
    }
    
}
