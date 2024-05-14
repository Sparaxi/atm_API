package com.atm.api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bank_account")
public class Bank_account {
        @Id
        private Integer id;

        @Column(name = "pasnummer", nullable = false)
        private String pasnummer;

        @Column(name = "pincode", nullable = false)
        private Integer pincode;

        @Column(name = "balance", nullable = false, precision = 10, scale = 2)
        private BigDecimal balance;

        @ManyToOne
        @JoinColumn(name = "user_bsn")
        private User user;

        public Bank_account() {
        }

        public Bank_account(String pasnummer, Integer pincode, BigDecimal balance, User user) {
                this.pasnummer = pasnummer;
                this.pincode = pincode;
                this.balance = balance;
                this.user = user;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getPasnummer() {
                return pasnummer;
        }

        public void setPasnummer(String pasnummer) {
                this.pasnummer = pasnummer;
        }

        public Integer getPincode() {
                return pincode;
        }

        public void setPincode(Integer pincode) {
                this.pincode = pincode;
        }

        public BigDecimal getBalance() {
                return balance;
        }

        public void setBalance(BigDecimal balance) {
                this.balance = balance;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User user) {
                this.user = user;
        }

        @Override
        public String toString() {
                return "Bank_account{" +
                        "id=" + id +
                        ", pasnummer='" + pasnummer + '\'' +
                        ", pincode=" + pincode +
                        ", balance=" + balance +
                        ", user=" + user +
                        '}';
        }
}



