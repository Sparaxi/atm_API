package com.atm.api.model;

import jakarta.persistence.*;

import java.util.Date;

public class Transaction_log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "log", nullable = false)
    private String log;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transactions transactions;

}
