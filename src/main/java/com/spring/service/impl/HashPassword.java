package com.spring.service.impl;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
@Component
public class HashPassword {
	public static String hash(String pass) {
		String salt = BCrypt.gensalt();
		return BCrypt.hashpw(pass, salt);
	}
	public static boolean check(String pass , String hash) {
		return BCrypt.checkpw(pass, hash);
	}
}
