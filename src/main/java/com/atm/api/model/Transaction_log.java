package com.atm.api.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction_log")
public class Transaction_log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "log", nullable = false)
    private String log;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transactions;

    public Transaction_log(Date date, String log, Transaction transactions) {
        this.date = date;
        this.log = log;
        this.transactions = transactions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Transaction getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Transaction_log{" +
                "id=" + id +
                ", date=" + date +
                ", log='" + log + '\'' +
                ", transactions=" + transactions +
                '}';
    }
}
