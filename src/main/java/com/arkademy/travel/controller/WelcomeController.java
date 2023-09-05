package com.arkademy.travel.controller;

import com.arkademy.travel.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    private TravelService travelService;

    @Autowired
    public WelcomeController(TravelService travelService) {
        this.travelService = travelService;
    }
    @GetMapping("")
    public String travelWelcome(Model model) {
        String title = "A Better way to Travel";
        model.addAttribute("title", title);
        return "index";
    }


}
