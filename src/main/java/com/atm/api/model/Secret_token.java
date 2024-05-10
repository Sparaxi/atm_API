package com.atm.api.model;

import jakarta.persistence.*;

public class Secret_token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "secret_token", nullable = false)
    private String secret_token;


}
