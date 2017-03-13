package org.colin.dang.util;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

public class EncryptUtil {
   public static String md5(String str) throws Exception{
	   MessageDigest  md=
		    MessageDigest.getInstance("MD5");
	   byte[] bts=md.digest(str.getBytes());
	   BASE64Encoder encoder=
		    new BASE64Encoder();
	   return encoder.encode(bts);
	   
   }
}
