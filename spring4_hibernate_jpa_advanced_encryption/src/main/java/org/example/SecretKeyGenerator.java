package org.example;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecretKeyGenerator {

	private static final String KEY_INSTANCE_AES = "AES";

	public static void main(String[] args) throws NoSuchAlgorithmException {

		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_INSTANCE_AES);

		SecureRandom secureRandom = new SecureRandom();
		int keyBitSize = 256;
		keyGenerator.init(keyBitSize, secureRandom);

		SecretKey secretKey = keyGenerator.generateKey();

		System.out.println(Base64.getEncoder().encodeToString(secretKey.getEncoded()));
	}

}
