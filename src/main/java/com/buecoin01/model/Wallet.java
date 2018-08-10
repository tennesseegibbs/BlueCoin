package com.buecoin01.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Component
//@Proxy(lazy = false)
public class Wallet {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "pubicId", unique = true)
    private String publicId;
    private double amount;
    private String name;


    public Wallet(){}

    public Wallet(String publicId, long amount, String name) {
        this.publicId = publicId;
        this.amount = amount;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public String getPublicId() {

        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
