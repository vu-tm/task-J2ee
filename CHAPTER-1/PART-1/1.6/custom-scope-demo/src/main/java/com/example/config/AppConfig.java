/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.config;
import com.example.custom.scope.demo.MyBean;
import com.example.scope.ThreadLocalScope;
import com.example.custom.scope.demo.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.config.CustomScopeConfigurer;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Hi
 */
@Configuration
public class AppConfig {
    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {

        CustomScopeConfigurer configurer =
                new CustomScopeConfigurer();

        Map<String, Object> scopes = new HashMap<>();

        scopes.put("thread-local", new ThreadLocalScope());

        configurer.setScopes(scopes);

        return configurer;
    }

    @Bean
    @org.springframework.context.annotation.Scope("thread-local")
    public MyBean myBean() {
        return new MyBean();
    }
}
