package basic.day10;

/**
 	String = char[] + 数组的操作方法（indexOf,concat..)
 	String API特点：
 		1.String对象是不可改变的！不变特性，不会改变char[]内容
 			是String是不可改变的,String变量可改变
 		2.String 为性能优化，API尽可能优化
 */
public class StringAPIDemo {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 =s1;
		s1  = s1+s2;
		System.out.println(s1);//abcabc
		
		//API如果返回结果与原字符串不同，结果一定是新字符串对象
		//如果返回结果与原字符串相同，一般是原字符串，性能好！
		String s3 = s1.toUpperCase();
		System.out.println(s3==s1);//false
		String s4 = s1.toLowerCase();
		System.out.println(s4==s1);//true
		
		String name = "tom";
		String login = name.trim();//去掉字符串两端的空白()
		name = " \t 	\r 	\n Jerry	 \n 	\t ";
		login = name.trim();
		System.out.println(login);//Jerry
		//		    012345678901234567890123456789
		String url="http://www.tarena.com.cn/index.html";
		int index = url.lastIndexOf('/');//24,输出最后一个‘／’
		System.out.println(index);//24
		index = url.indexOf('/',7);//从第7个位置开始找，看第几个是'/'
		System.out.println(index);//24
		//				01234567890123345
		String email = "295445156@qq.com";
		name = email.substring(0,email.indexOf("@"));//包含前不包含后，［0，11）,取出从0－＞11
		System.out.println(name);//295445156
		String host = email.substring(email.indexOf("@")+1);//从这个位置开始，后边所有的
		System.out.println(host);//qq.com
		
		String filename = "tom.png";
		if( filename.endsWith(".png")){
			System.out.println("这是PNG格式照片文件！");
		}
//		boolean isPhoto = filename.endsWith(".png");//检验：以..什么结尾的
//		System.out.println(isPhoto);//true
		
		String filename1 = "jiadongpo";
		if(filename1.startsWith("jia")){
			System.out.println("贾氏！");
		}
	}

}
