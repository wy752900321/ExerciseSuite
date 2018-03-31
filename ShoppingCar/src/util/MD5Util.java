package util;
import java.security.MessageDigest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
		public static void test1(){
			try{
				MessageDigest md = MessageDigest.getInstance("md5");
				String str = "ilove";
				byte[] buf = md.digest(str.getBytes());
				BASE64Encoder encoder=new BASE64Encoder();
				String str2=encoder.encode(buf);
				System.out.println("str2:"+str2+""+str2.length());
			}catch(NoSuchAlgorithmException e){
				e.printStackTrace();
			}
		}
		public static String getMD5Str(String origStr) throws Exception{
			MessageDigest md=MessageDigest.getInstance("md5");
			byte[] buf = md.digest(origStr.getBytes());
			BASE64Encoder encoder=new BASE64Encoder();
			String str2 = encoder.encode(buf);
			return str2;
		}
		public static void main(String[] args) {
			test1();
		}
}
