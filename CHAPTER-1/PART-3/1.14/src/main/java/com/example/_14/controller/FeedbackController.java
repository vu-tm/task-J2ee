package com.example._14.controller;

import com.example._14.entity.Feedback;
import com.example._14.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback";
    }

    @PostMapping("/submit")
    public String submit(
            @Valid @ModelAttribute("feedback") Feedback feedback,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "feedback";
        }

        feedbackService.saveFeedback(feedback);

        return "submit-success";
    }
}
