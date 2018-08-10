package com.buecoin01.utility;

import java.security.PublicKey;

public class TransactionOutput {
    private String id;
    private PublicKey reciepient; //new owner of the coins
    private float value; //the amount of coins they own
    private String parentTransactionId;

    public TransactionOutput(PublicKey reciepient, float value, String parentTransactionId) {
        this.reciepient = reciepient;
        this.value = value;
        this.parentTransactionId = parentTransactionId;
        this.id = Encryption.applySha256(Encryption.getStringFromKey(reciepient)+Float.toString(value)+parentTransactionId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PublicKey getReciepient() {
        return reciepient;
    }

    public void setReciepient(PublicKey reciepient) {
        this.reciepient = reciepient;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getParentTransactionId() {
        return parentTransactionId;
    }

    public void setParentTransactionId(String parentTransactionId) {
        this.parentTransactionId = parentTransactionId;
    }

    //Check if coin belongs to publicKey
    public boolean isMine(PublicKey publicKey) {
        return publicKey == reciepient;
    }
}
