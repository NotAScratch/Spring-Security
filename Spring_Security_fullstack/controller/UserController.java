package com.example.fullstack.controller;

import org.springframework.ui.Model;
import com.example.fullstack.services.IUserService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private  final IUserService userService;

    @GetMapping
    public String getUser(Model model){
    model.addAttribute("users",userService.getAllUsers());
    return "users";
    }

}

