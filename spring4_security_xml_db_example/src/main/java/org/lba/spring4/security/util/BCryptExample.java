package org.lba.spring4.security.util;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptExample {

	static final Logger logger = Logger.getLogger(BCryptExample.class);
	
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		logger.debug("Encrypted password: " + encoder.encode("m123"));
		/**/
		//$2a$10$LJveX4oEWZ/NNl4zNcNRAuwLaHcsFnun.wR2.4Xfn9qwnX3dEqDee
		String password = "m123";
		String encodedPassword = "$2a$10$LJveX4oEWZ/NNl4zNcNRAuwLaHcsFnun.wR2.4Xfn9qwnX3dEqDee";
		/**/
		boolean isPasswordMatch = encoder.matches(password, encodedPassword);
		logger.debug("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);

	}
}
