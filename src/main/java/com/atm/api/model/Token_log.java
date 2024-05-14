package com.atm.api.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "token_log")
public class Token_log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "token_log", nullable = false)
    private String token_log;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "validation_id")
    private Validation validation;

    public Token_log(String token_log, Date date, Validation validation) {
        this.token_log = token_log;
        this.date = date;
        this.validation = validation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken_log() {
        return token_log;
    }

    public void setToken_log(String token_log) {
        this.token_log = token_log;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Validation getValidation() {
        return validation;
    }

    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    @Override
    public String toString() {
        return "Token_log{" +
                "id=" + id +
                ", token_log='" + token_log + '\'' +
                ", date=" + date +
                ", validation=" + validation +
                '}';
    }
}
