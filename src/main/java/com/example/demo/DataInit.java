package com.example.demo;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.User;
import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Utility.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@RequiredArgsConstructor
public class DataInit implements ApplicationRunner {
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (categoryRepository.count() == 0) {
            categoryRepository.save(new Category("спорт"));
            categoryRepository.save(new Category("изкуство"));
            categoryRepository.save(new Category("обща култура"));
        }

        //Create the initial admin account
        if (userRepository.count() == 0) {
            userRepository.save(User.builder()
                            .username("admin")
                    .firstName("Administrator")
                    .lastName("")
                    .password(encoder.passwordEncoder().encode("123"))
                    .email("admin123@abv.bg")
                    .role("ROLE_ADMIN")
                    .enabled(true)
                    .build());
        }
    }
}
