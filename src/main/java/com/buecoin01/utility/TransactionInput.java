package com.buecoin01.utility;


//This class will be used to reference TransactionOutputs that have not yet been spent.
//The transactionOutputId will be used to find the relevant TransactionOutput, allowing miners to check your ownership.
public class TransactionInput {
    private String transactionOutputId;
   // private TransactionOutput UTXO; // UTXO means Unspent Transaction Outputs
   private TransactionOutput UTXO;

    public TransactionInput(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }

    public String getTransactionOutputId() {
        return transactionOutputId;
    }

    public void setTransactionOutputId(String transactionOutputId) {
        this.transactionOutputId = transactionOutputId;
    }

    public TransactionOutput getUTXO() {
        return UTXO;
    }

    public void setUTXO(TransactionOutput UTXO) {
        this.UTXO = UTXO;
    }
}