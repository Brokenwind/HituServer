package com.zju.iot.common.utils;


import com.zju.iot.common.Constants;

import java.util.regex.Matcher;


public class ValidateUtil {

	public static boolean isValidUsername(String username) {
		if (StringUtil.isEmpty(username)) {
			return false;
		}
		Matcher m = Constants.PATTERN_USERNAME.matcher(username);
	    return m.matches();
	}
	
	public static boolean isValidPassword(String password) {
		if (StringUtil.isEmpty(password)) {
			return false;
		}
		Matcher m = Constants.PATTERN_PASSWORD.matcher(password);
		return m.matches();
	}
	
	public static boolean isValidEmail(String email) {
		if (StringUtil.isEmpty(email)) {
			return false;
		}
		Matcher m = Constants.PATTERN_EMAIL.matcher(email);
		return m.matches();
	}
	
}
