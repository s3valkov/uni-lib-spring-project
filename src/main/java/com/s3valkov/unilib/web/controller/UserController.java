package com.s3valkov.unilib.web.controller;

import com.s3valkov.unilib.dto.binding.auth.UserRegisterBindingModel;
import com.s3valkov.unilib.dto.binding.auth.UserServiceModel;
import com.s3valkov.unilib.dto.view.UserDetailsViewModel;
import com.s3valkov.unilib.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


    public UserController(UserServiceImpl userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView register() {
        return super.view("user/register");
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel model) {
        if (!model.getPassword().equals(model.getConfirmPassword())) {
            return super.view("user/register");
        }

        this.userService.createAndLoginUser(this.modelMapper.map(model, UserRegisterBindingModel.class));

        return super.redirect("/login");
    }

    @GetMapping("/login")
    @PreAuthorize("isAnonymous()")
    public ModelAndView login() {
        LOGGER.info("Trying to log in the application!");
        return super.view("user/login");
    }


    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView profile(Principal principal, ModelAndView modelAndView){
        LOGGER.info("I'm here");
        modelAndView
                .addObject("model", this.modelMapper
                        .map(this.userService.loadUserByUsername(principal.getName()), UserDetailsViewModel.class));
        return super.view("user/profile", modelAndView);
    }
}
