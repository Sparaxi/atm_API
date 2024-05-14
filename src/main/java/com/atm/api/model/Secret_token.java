package com.atm.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Secret_token")
public class Secret_token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "secret_token", nullable = false)
    private String secret_token;


    public Secret_token(String secret_token) {
        this.secret_token = secret_token;
    }

    public String getSecret_token() {
        return secret_token;
    }

    public void setSecret_token(String secret_token) {
        this.secret_token = secret_token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Secret_token{" +
                "id=" + id +
                ", secret_token='" + secret_token + '\'' +
                '}';
    }
}
