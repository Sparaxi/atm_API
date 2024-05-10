package com.atm.api.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transacties")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "van", nullable = false)
    private String van;

    @Column(name = "naar", nullable = false)
    private String naar;

    @Column(name = "datum", nullable = false)
    private Date datum;

    @Column(name = "status", nullable = false)
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "bank_account_id")
    private Bank_account bankAccount;

}
