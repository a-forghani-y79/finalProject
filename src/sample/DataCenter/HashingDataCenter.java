package sample.DataCenter;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingDataCenter {
    private String text;
    private MessageDigest md;
    private String txtHash;

    public HashingDataCenter(int message) {
        text = String.valueOf(message);
    }

    public HashingDataCenter(long message) {
        text = String.valueOf(message);
    }

    public HashingDataCenter(String message) {
        text = message;
    }

    private void hash(String text) {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            txtHash = "Error: " + e.getMessage();
        }
        md.update(text.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        txtHash = String.format("%064x", new BigInteger(1, digest));
    }

    public String getHash() {
        hash(text);
        return txtHash;
    }

    public void setMessage(String txt) {
        text = txt;
    }
}