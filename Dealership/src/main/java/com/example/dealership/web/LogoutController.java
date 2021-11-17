package com.example.dealership.web;

import com.example.dealership.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    private final UserService userService;

    public LogoutController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/logout")
    private String logout() {
        userService.logout();
        return "redirect:/";
    }
}
