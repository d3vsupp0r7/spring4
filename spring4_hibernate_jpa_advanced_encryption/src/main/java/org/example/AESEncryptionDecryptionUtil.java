package org.example;

import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryptionDecryptionUtil {

    private static final String CIPHER_INSTANCE_AES = "AES";

	public static String encrypt(final String secret, final String data) {

    	byte[] decodedKey =  Base64.getMimeDecoder().decode(secret);

        try {
            Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE_AES);
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), CIPHER_INSTANCE_AES);
            cipher.init(Cipher.ENCRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(data.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while encrypting data", e);
        }

    }

    public static String decrypt(final String secret,
            final String encryptedString) {

    	byte[] decodedKey =  Base64.getMimeDecoder().decode(secret);

        try {
            Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE_AES);
            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), CIPHER_INSTANCE_AES);
            cipher.init(Cipher.DECRYPT_MODE, originalKey);
            byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
            return new String(cipherText);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error occured while decrypting data", e);
        }
    }

    public static void main(String[] args) {

        String data = "This is the data to encrypt";
        String key = "MyEncriptionKey_test";
        String encrypted = encrypt(key, data);
        System.out.println(encrypted);
        System.out.println(decrypt(key, encrypted));
      }
  }