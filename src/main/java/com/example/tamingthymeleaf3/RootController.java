package com.example.tamingthymeleaf3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class RootController {

    UserDB userDB;

    RootController(@Autowired UserDB userDB) {
        this.userDB = userDB;
    }

    @RequestMapping("/")
    @GetMapping
    public String index(Model model) {
        model.addAttribute("pageTitle", "Taming Thymeleaf");
        model.addAttribute("scientists", List.of("Albert Einstein",
                "Niels Bohr",
                "James Clerk Maxwell"));
        return "index";
    }

    @RequestMapping("/users")
    @GetMapping
    public String users(Model model) {
        model.addAttribute("pageTitle", "Users");
        Map<String, String> userDB = this.userDB.getUserDB();
        model.addAttribute("user", userDB);
        return "users";
    }

    @RequestMapping("/users/{id}")
    @GetMapping @PostMapping
    public String user(@PathVariable("id") String userId, Model model) {
        model.addAttribute("pageTitle", "Users");
        Integer id = Integer.parseInt(userId);
        Map<String, String> userDB = this.userDB.getUserDB();
        String name = userDB.get(id);
        model.addAttribute("user",name);
        return "users/"+id;
    }

}