package com.atm.api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "transacties")
public class Transactions {
    //id
    //van
    //naar
    //datum
    //status
    //one to many with transacion_log
}
