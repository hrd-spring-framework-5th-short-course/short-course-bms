package com.example.shortcoursebms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/swagger-ui")
    public String showSwaggerForm() {

        return "swagger/swagger-index";
    }
}
