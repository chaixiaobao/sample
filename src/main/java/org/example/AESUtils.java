package org.example;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * AES信息加密
 *
 * @author Hai
 * @since 17.2.24
 */
public class AESUtils {

    private static final byte[] keybits = {-55, -119, -7, 82, -99, -115, -53, 108, -118, -126, 43, -27, 102, -120, 67,
            -64};

    private SecretKey key;
    private Cipher c;

    public AESUtils() throws NoSuchAlgorithmException, NoSuchPaddingException {

        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(keybits);
        keygen.init(128, secureRandom);
        this.key = keygen.generateKey();

        c = Cipher.getInstance("AES");
    }

    /**
     * 对字符串加密
     *
     * @param str 明文
     * @return 密文
     */
    public String encrypt(String str) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        String result;
        byte[] src = str.getBytes();
        c.init(Cipher.ENCRYPT_MODE, key);
        result = bytesToHexString(c.doFinal(src));

        return result;
    }

    /**
     * 对字符串解密
     *
     * @param str 密文
     * @return 铭文
     */
    public String decrypt(String str) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException{
        byte[] buff = hexStringToBytes(str);
        String result;
        c.init(Cipher.DECRYPT_MODE, key);
        result = new String(c.doFinal(buff));
        return result;
    }

    /**
     * 16进制字符串转换为byte[]
     *
     * @param hexString 16进制字符串
     * @return byte[]
     */
    private static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase().replace(" ", "");
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    /**
     * byte[]转换成16进制字符串
     *
     * @param src byte[]
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte b : src) {
            int v = b & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

}

