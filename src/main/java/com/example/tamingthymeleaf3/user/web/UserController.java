package com.example.tamingthymeleaf3.user.web;

import com.example.tamingthymeleaf3.infrastructure.web.EditMode;
import com.example.tamingthymeleaf3.user.Gender;
import com.example.tamingthymeleaf3.user.User;
import com.example.tamingthymeleaf3.user.UserId;
import com.example.tamingthymeleaf3.user.UserServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
                               BindingResult bindingResult, Model model) {

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

    @GetMapping("/users/{id}")
    public String editUserForm(@PathVariable("id") UserId userId, Model model) {

        User user = userService.getUser(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        model.addAttribute("user", EditUserFormData.fromUser(user));
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER));
        model.addAttribute("editMode", EditMode.UPDATE);

        return "users/edit";
    }

    @PostMapping("/users/{id}")
    public String saveEditedUser(@PathVariable("id") UserId userId, @Validated(EditUserValidationGroupSequence.class) @ModelAttribute("user") EditUserFormData formData,
                                 BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER));
            model.addAttribute("editMode", EditMode.UPDATE);
            return "users/edit";
        }

        userService.editUser(userId, formData.toParameters());

        return "redirect:/users";
    }

    @PostMapping("/users/{id}/delete")
    public String doDeleteUser(@PathVariable("id") UserId userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }

}