package org.colin.dang.util;

import java.util.UUID;

public class VerifyUtil {
 public static String createEmailVerifyCode(){
	 UUID uuid=UUID.randomUUID();
	 return uuid.toString();
 }
}
