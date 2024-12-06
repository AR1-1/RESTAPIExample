package com.example.RESTAPI.controller;

import com.example.RESTAPI.dto.UserRegDTO;
import com.example.RESTAPI.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegController {

    private UserService userService;

    public UserRegController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegDTO userRegistrationDto() {
        return new UserRegDTO ();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegDTO registrationDto) {
        try {
            userService.save(registrationDto);
            return "redirect:/registration?success";
        } catch (IllegalArgumentException e) {
            return "redirect:/registration?error";
        }
    }
}
