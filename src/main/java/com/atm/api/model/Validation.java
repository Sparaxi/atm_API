package com.atm.api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "validations")
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_bsn")
    private User user;

    @ManyToOne
    @JoinColumn(name = "secret_token_id")
    private Secret_token sc;

}
