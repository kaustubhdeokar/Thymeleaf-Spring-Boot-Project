package com.example.tamingthymeleaf3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/users")
    @GetMapping
    public String index(Model model) {
        return "users/list";
    }
}