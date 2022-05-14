package com.example.tamingthymeleaf3.user.web;

import com.example.tamingthymeleaf3.user.Gender;
import com.example.tamingthymeleaf3.user.UserServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    @GetMapping
    public String index(Model model, @SortDefault.SortDefaults({
            @SortDefault("userName.lastName"),
            @SortDefault("userName.firstName")}) Pageable pageable) {
        model.addAttribute("users", userService.getUsers(pageable));
        return "users/list";
    }

    @PostMapping("/users/create")
    public String saveUserForm(@Valid @ModelAttribute("user") CreateUserFormData formData, //<.>
                               BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) { //<.>
            model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER)); //<.>
            return "users/edit";
        }

        userService.createUser(formData.toParameters()); //<.>

        return "redirect:/users";
    }

    @GetMapping("/users/create")
    public String createUserForm(Model model) { //<.>
        model.addAttribute("user", new CreateUserFormData()); //<.>
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER)); //<.>
        return "users/edit";
    }


}