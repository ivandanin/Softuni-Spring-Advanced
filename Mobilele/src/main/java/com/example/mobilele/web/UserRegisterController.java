package com.example.mobilele.web;

import com.example.mobilele.models.bindingModels.RegisterBindingModel;
import com.example.mobilele.models.serviceModels.RegisterServiceModel;
import com.example.mobilele.services.UserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    private final UserEntityService userService;
    private final ModelMapper modelMapper;

    public UserRegisterController(UserEntityService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("userModel")
    public RegisterBindingModel userModel() {
        return new RegisterBindingModel();
    }

    @GetMapping("/register")
    public String register() {
        return "auth-register";
    }
    @PostMapping("/register")
    public String register(
            @Valid RegisterBindingModel userModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
            ) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userModel", userModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);

            return "redirect:/users/register";
        }

        RegisterServiceModel serviceModel =
                modelMapper.map(userModel, RegisterServiceModel.class);

        if (!userService.isUsernameFree(serviceModel.getUserName())) {
            redirectAttributes.addFlashAttribute("userModel", userModel)
                    .addFlashAttribute("userNameOccupied", true);

            return "redirect:/users/register";
        } else {
            userService.registerAndLogin(serviceModel);
        }
        return "redirect:/";
    }
}
