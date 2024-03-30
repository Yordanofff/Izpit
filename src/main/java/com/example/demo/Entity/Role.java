//package com.example.demo.Entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
//}
