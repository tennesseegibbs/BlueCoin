package com.buecoin01.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Component
@Entity
public class Transactions {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String transactionId;
    @Column(name = "fromId")
    private String fromId;

    @Column(name = "toId")
    private String toId;

    @Column(name = "amount")
    private double amount;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public Transactions(){}

    public Transactions(String transactionId, String fromId, String toId, double amount, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.fromId = fromId;
        this.toId = toId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getFromId() {
        return this.fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getToId() {
        return this.toId;
    }

    public void setToId(String toId) {
        this.toId = toId;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }



}
