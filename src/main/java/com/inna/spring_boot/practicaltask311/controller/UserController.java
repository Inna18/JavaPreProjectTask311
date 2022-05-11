package com.inna.spring_boot.practicaltask311.controller;

import com.inna.spring_boot.practicaltask311.model.User;
import com.inna.spring_boot.practicaltask311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.findAll();
        model.addAttribute("allUsers", allUsers);

        return "all-users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-info";
        }

        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);

        return "user-info";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteById(id);

        return "redirect:/";
    }

}
