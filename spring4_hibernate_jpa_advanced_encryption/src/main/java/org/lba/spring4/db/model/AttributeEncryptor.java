package org.lba.spring4.db.model;

import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;

import org.springframework.stereotype.Component;

@Component
public class AttributeEncryptor implements AttributeConverter<String, String> {

	private static final String AES = "AES";
	private static final String SECRET = "secret-key-12345";

	private final Key key;
	private final Cipher cipher;


	public AttributeEncryptor() throws Exception {
		byte[] decodedKey =  Base64.getMimeDecoder().decode(SECRET);
		key = new SecretKeySpec(Arrays.copyOf(decodedKey, 16), "AES");
		cipher = Cipher.getInstance(AES);
	}

	@Override
	public String convertToDatabaseColumn(String attribute) {
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			/**/
			byte[] decodedKey =  Base64.getMimeDecoder().decode(SECRET);
			String normalizedAttribute = AttributeEncryptor.bytesToHex(attribute.getBytes());
			byte[] cipherText = cipher.doFinal(normalizedAttribute.getBytes());
			/**/
			return Base64.getEncoder().encodeToString(cipher.doFinal(cipherText));//qbW0xZRuTv04K1zME8P2HW9ltR73NbTbBLYlaEQB5/g=
			
		} catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
			throw new IllegalStateException(e);
		} 
	
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			/**/
			byte[] decodedKey =  Base64.getMimeDecoder().decode(SECRET);
			System.out.println("Secret: " + SECRET);
			System.out.println("decodedKey: " + decodedKey);
			System.out.println("decodedKey st: " + new String(decodedKey));
			System.out.println("decodedKey st clean: " + AttributeEncryptor.bytesToHex(dbData.getBytes()) );
						 
			 String normalizedAttribute = AttributeEncryptor.bytesToHex(dbData.getBytes());
			 
			 byte[] cipherText = cipher.doFinal(Base64.getDecoder().decode(normalizedAttribute));
	            return new String(cipherText);
			/**/
		} catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
			throw new IllegalStateException(e);
		}
	}

	private static String bytesToHex(byte[] bytes) {

		StringBuilder sb = new StringBuilder();

		for(byte b : bytes) {
			sb.append(String.format("%02x",b));
		}

		return sb.toString();
	}
}
