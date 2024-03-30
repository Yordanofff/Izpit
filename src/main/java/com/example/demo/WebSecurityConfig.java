package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                                // disabling the security while testing....
                                .anyRequest().permitAll()
//                                .requestMatchers("/", "/about", "/registration", "/icon.jpg", "/info").permitAll()
//                                .requestMatchers("/category").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")
//                                .anyRequest().authenticated()

                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .usernameParameter("username")  // this is needed in the html form.
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
}
