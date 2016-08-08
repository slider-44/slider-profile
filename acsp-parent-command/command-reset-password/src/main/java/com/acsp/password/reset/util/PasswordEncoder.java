package com.acsp.password.reset.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	public String encode(String password) {
		
		return passwordEncoder.encode(password);
	}
	
	public boolean isMatch(String rawPassword, String encodedPassword) {
		
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}
	
}
