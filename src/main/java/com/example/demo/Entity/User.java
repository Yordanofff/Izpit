package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @Size(min = 2)
    private String firstName;

    private String lastName;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean enabled;
}

//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
