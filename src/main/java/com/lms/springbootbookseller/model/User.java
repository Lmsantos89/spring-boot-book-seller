package com.lms.springbootbookseller.model;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name =" create_time", nullable = false)
    private LocalDateTime createTime;

    @Enumerated(STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Transient
    private String token;
}
