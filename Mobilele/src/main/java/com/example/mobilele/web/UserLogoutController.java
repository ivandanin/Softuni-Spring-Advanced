package com.example.mobilele.web;

import com.example.mobilele.services.UserEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLogoutController {

    private final UserEntityService userService;

    public UserLogoutController(UserEntityService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }
}
