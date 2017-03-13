package basic.day17;
//得到本机默认编码
public class CharSetDemo01 {
	public static void main(String[] args) {
		System.out.println("系统默认编码："+System.getProperty("file.encoding"));//获取当前系统编码
	}
}
