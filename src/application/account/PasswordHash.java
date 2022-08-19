package application.account;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {
    private String password;
    private byte[] hashByte;

    public PasswordHash(String password) {
        this.password = password;
        hashByte=generateByteHash();
    }

    private byte[] generateByteHash(){
        MessageDigest sha1;
        try {
            sha1=MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return sha1.digest(password.getBytes());
    }

    public byte[] getHashByte(){
        return hashByte;
    }
}
