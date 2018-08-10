package com.buecoin01.model;


import com.buecoin01.utility.Encryption;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Entity
@Component
public class Block {

    private String minerID;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String hash;
    private String previousHash;
    private String data;
    public String merkleRoot;
    public ArrayList<Transactions> transactionList = new ArrayList<>();
    private LocalDateTime timeStamp;
    private int nonce;

    public Block() {
    }

    public Block(String previousHash, LocalDateTime time, int nonce) {
        this.timeStamp = time;
        this.previousHash = previousHash;
        this.hash = calculateHash();
        this.nonce = nonce;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public String calculateHash() {
        return Encryption.applySha256(
                  previousHash +
                        timeStamp.toString() +
                        Integer.toString(nonce) +
                        merkleRoot);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
            System.out.println(hash);
        }
        System.out.println("Block Mined " + hash);
        System.out.println("You have been awarded 1 Zip!");
    }

    }
