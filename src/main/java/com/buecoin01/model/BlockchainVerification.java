package com.buecoin01.model;

import com.buecoin01.model.Block;
import com.buecoin01.utility.Encryption;
import com.buecoin01.utility.TransactionOutput;
import com.google.gson.GsonBuilder;

import java.security.Security;
import java.util.*;

public class  BlockchainVerification {
    private static List<Block> blockchain = new ArrayList<>();
    private static Map<String, TransactionOutput> UTXOs = new HashMap<>();
    public static float minimumTransaction = 0.1f;
    private static int difficulty = 5;
    public static Wallet walletA;
    public static Wallet walletB;
    //public static Transaction genesisTransaction;

//    public static void main(String[] args) {
//        //Setup Bouncey castle as a Security Provider
//        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
//
//        //Create the new wallets
//        walletA = new Wallet();
//        walletB = new Wallet();
//
//        //Test public and private keys
//        System.out.println("Private and public keys:");
//        System.out.println(Encryption.getStringFromKey(walletA.getPrivateKey()));
//        System.out.println(Encryption.getStringFromKey(walletA.getPublicKey()));
//        //Create a test transaction from WalletA to walletB
//        Transaction transaction = new Transaction(walletA.getPublicKey(), walletB.getPublicKey(), 5, null);
//        transaction.generateSignature(walletA.getPrivateKey());
//
//        //Verify the signature works and verify it from the public key
//        System.out.println("Is signature verified");
//        System.out.println(transaction.verifySignature());

 //   }

    public String chainToJson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create()
                .toJson(blockchain);
    }

    public static Map<String, TransactionOutput> getUTXOs() {
        return UTXOs;
    }

    public static void setUTXOs(Map<String, TransactionOutput> UTXOs) {
        BlockchainVerification.UTXOs = UTXOs;
    }

    public static List<Block> getBlockchain() {
        return blockchain;
    }

    public static void abbBlockToChain(Block block) {
        blockchain.add(block);
    }

    public static Block getBlockFromChain(int i) {
        return blockchain.get(i);
    }

    public static int getChainSize() {
        return blockchain.size();
    }

    public static boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = Encryption.createTarget(difficulty);
        for (int i = 1; i < blockchain.size()-1; i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            if(!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                System.out.println("Current Hashes aren't equal");
                return false;
            }
            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hashes aren't equal");
                return false;
            }
            if (!currentBlock.getHash().substring(0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }
}