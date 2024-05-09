package com.atm.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bank_account")
public class Bank_acount {
        @Id
        private Integer rekening_nummer;

        @Column(name = "pasnummer", nullable = false)
        private String pasnummer;

        @Column(name = "pincode", nullable = false)
        private Integer pincode;

        @Column(name = "balance", nullable = false, precision = 10, scale = 2)
        private BigDecimal balance;

}


