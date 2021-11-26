package com.example.mobilele.web;

import com.example.mobilele.models.bindingModels.LoginBindingModel;
import com.example.mobilele.models.serviceModels.LoginServiceModel;
import com.example.mobilele.services.UserEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

    private final UserEntityService userService;

    public UserLoginController(UserEntityService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/login")
    public String login(LoginBindingModel loginBindingModel) {

        boolean loginSuccessful = userService.login(
                new LoginServiceModel()
                .setUsername(loginBindingModel.getUsername())
                .setPassword(loginBindingModel.getPassword()));

        LOGGER.info("User tried to login. User with name {} tried to login. Success = {}?",
                loginBindingModel.getUsername(),
                loginSuccessful);

        if (loginSuccessful) {
            return "redirect:/";
        }
    return "redirect:/users/login";
    }
}
