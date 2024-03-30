package com.example.demo.Service;

import com.example.demo.Dto.UserRequestDto;
import com.example.demo.Entity.User;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Utility.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;


    public String addUser(UserRequestDto UserRequestDto, BindingResult bindingResult, Model model){
        System.out.println(bindingResult.hasErrors());
        if (bindingResult.hasErrors() || !UserRequestDto.getPassword().equals(UserRequestDto.getRepeatPassword())) {
            model.addAttribute("passwordMessage", !UserRequestDto.getPassword().equals(UserRequestDto.getRepeatPassword()) ? "Паролите не съвпадат!" : "");
            return "/registration";
        }
//        if (bindingResult.hasErrors()) {
//            return "/registration";
//        }
//        if (!UserRequestDto.getPassword().equals(UserRequestDto.getRepeatPassword())) {
//            model.addAttribute("password_error", "Паролите не съвпадат!");
//            return "/registration";
//        }
        User user = UserMapper.toEntity(UserRequestDto);
        user.setPassword(encoder.passwordEncoder().encode(UserRequestDto.getPassword()));
        user.setEnabled(true);
//        user.setRole(Role.ROLE_USER);
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "redirect:/login";
    }
}
