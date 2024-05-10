package com.atm.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_bsn")
    private User user;
}
