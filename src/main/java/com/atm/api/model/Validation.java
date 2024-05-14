package com.atm.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "validation")
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_bsn")
    private User user;

    @ManyToOne
    @JoinColumn(name = "secret_token_id")
    private Secret_token secret_token;

    public Validation(User user, Secret_token secret_token) {
        this.user = user;
        this.secret_token = secret_token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Secret_token getSecret_token() {
        return secret_token;
    }

    public void setSecret_token(Secret_token secret_token) {
        this.secret_token = secret_token;
    }

    @Override
    public String toString() {
        return "Validation{" +
                "id=" + id +
                ", user=" + user +
                ", secret_token=" + secret_token +
                '}';
    }
}
