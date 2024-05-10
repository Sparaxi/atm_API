package com.atm.api.model;

import jakarta.persistence.*;

import java.util.Date;

public class Token_log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "token_log", nullable = false)
    private String token_log;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "validation_id")
    private Validation validation;

}
