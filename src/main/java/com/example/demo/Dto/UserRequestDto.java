package com.example.demo.Dto;


import lombok.Data;

@Data
public class UserRequestDto {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String repeatPassword;
    private String email;
}
