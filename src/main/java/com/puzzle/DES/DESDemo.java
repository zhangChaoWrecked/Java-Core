package com.puzzle.DES;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import java.io.*;

/**
 * @author ZhangChao
 * @date 2019.01.16  16:09
 */
public class DESDemo {

    private static void writeToFile(String filename, Object object) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(filename)));
        oos.writeObject(object);
        oos.flush();
        oos.close();
    }

    private static Object readFromFile(String filename) throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(filename)));
        Object object = ois.readObject();
        ois.close();
        return object;
    }
    public static String byte2Hex(byte[] b) {
        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
        }
        return sb.toString().toUpperCase().trim();
    }

    public static void main(String[] args) throws Exception {

        SecretKey key = KeyGenerator.getInstance("DES").generateKey();
        byte[] encoded = key.getEncoded();
        String s = byte2Hex(encoded);
        System.out.println("Text = " + s);
        writeToFile("secretkey.txt", key);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        DESEntity desEntity = new DESEntity("Wrecked",24);
        writeToFile("sealed.txt", desEntity);

        SecretKey secretKey = (SecretKey) readFromFile("secretkey.txt");
        DESEntity so = (DESEntity) readFromFile("sealed.txt");
        cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        System.out.println("Text = " + desEntity.toString());
    }
}
