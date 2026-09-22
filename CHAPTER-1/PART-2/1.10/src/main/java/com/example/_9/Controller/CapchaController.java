package com.example._9.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ThreadLocalRandom;

@Controller
public class CapchaController {

    @GetMapping("/")
    public String index(Model model) {
        // random from 20 pics
        int randomNum = ThreadLocalRandom.current().nextInt(1, 21);
        String imgName = "capcha" +  randomNum + ".png";
        model.addAttribute("imgName", imgName);
        return "index";
    }
}
