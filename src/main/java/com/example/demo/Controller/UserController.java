package com.example.demo.Controller;

import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/registration")
    private String addUser(Model model) {
        model.addAttribute("UserRequestDto", new UserRequestDto());
        return "registration";
    }

    @PostMapping("/registration")
    private String addUser(@Valid @ModelAttribute UserRequestDto UserRequestDto, BindingResult bindingResult, Model model) {
        return userService.addUser(UserRequestDto, bindingResult, model);
    }

}
