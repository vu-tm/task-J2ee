package com.example._14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedbackController {
    @GetMapping("/")
    public String index() {
        return "feedback";
    }
}
