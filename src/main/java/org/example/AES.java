package org.example;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        AESUtils aes = new AESUtils();
//        String pwd = aes.encrypt("bcrdb");
        String pwd = aes.decrypt("8b1ab3bb7eeeff8419e28a4867375da9");
        System.out.println(pwd);
    }
}
