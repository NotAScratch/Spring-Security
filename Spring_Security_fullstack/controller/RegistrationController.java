package com.example.fullstack.controller;

import com.example.fullstack.entities.User;
import com.example.fullstack.entities.VerificationToken;
import com.example.fullstack.event.EmailAlreadyExistsException;
import com.example.fullstack.event.RegistrationCompleteEvent;
import com.example.fullstack.repository.VerificationTokenRepository;
import com.example.fullstack.services.IUserService;
import com.example.fullstack.services.VerificationTokenService;
import com.example.fullstack.utilities.UrlUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {

    private final IUserService userService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenService tokenService;
    private final VerificationTokenService verificationTokenService;

    @GetMapping("/registration-form")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new RegistrationRequest());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") RegistrationRequest registration , HttpServletRequest request){
        if(userService.existsByEmail(registration.getEmail())){
            return "redirect:/registration/registration-form?emailExists";
        }
        User user = userService.registerUser(registration);
        publisher.publishEvent(new RegistrationCompleteEvent(user, UrlUtil.getApplicationUrl(request)));
        return "redirect:/registration/registration-form?success";


    }

    @GetMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token){
        Optional<VerificationToken> theToken = tokenService.findByToken(token);
        if(theToken.isPresent() && theToken.get().getUser().isEnabled()){
            return "redirect:/login/?verified";
        }
        String result = tokenService.validateToken(String.valueOf(token));
        switch (result.toLowerCase()) {
            case "expired":
                return "redirect:/error?expired";
            case "valid":
                return "redirect:/login?valid";
            default:
                return "redirect:/error?invalid";
        }
    }
}
