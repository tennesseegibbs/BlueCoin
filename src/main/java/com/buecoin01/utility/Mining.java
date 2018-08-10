package com.buecoin01.utility;

public class Mining {

    public static void main(String[] args) {
        String prevHash = "";
        String block = "";
        String data = "";
        Mining test = new Mining();
        test.mine(prevHash, block, data);
    }

    public String hash(String string) {
        String hashed = org.apache.commons.codec.digest.DigestUtils.sha256Hex(string);
        return hashed;
    }

    public void mine(String prevHash, String block, String data) {
        int nonce = 0;
        boolean mined = false;
        while (mined == false) {
            String newHash = hash(prevHash + block + data + Integer.toString(nonce));
            System.out.println(newHash);
            if (newHash.startsWith("00000")) {
                mined = true;
            } else {
                nonce++;
            }
        }
        System.out.println(nonce);

    }
}

