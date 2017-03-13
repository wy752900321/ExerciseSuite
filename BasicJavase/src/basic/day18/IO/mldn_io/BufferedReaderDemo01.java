package basic.day18.IO.mldn_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**键盘输入数据的标准格式
 * 
 *将System.in变为字符流放入到BufferedReader后，可以通过readerLine()方法等待用户输入信息。
 */
 /*BufferedReader类：
	用于从缓冲区中读取内容，所有的输入字节数据都将放在缓冲区中：
	方法:public BufferedReader(Reader in)  构造  接收一个Reader类的实例
	public String readLine() throws IOException 普通  一次性从缓冲区中将内容全部读取进来
	BufferedReader中定义的构造方法只能接收字符输入流的实例，所以必须使用字符输入流和
	字节输入流的转换类InputStreamReader将字节输入流System.in变为字符流。如：
	//BufferedReader实例化过程
	BufferedReader buf = null;
	buf=new BufferedReader (new InputStreamReader(System.in));
	System.in批字节输入流，InputStreamReader()是将字节变为字符流，
	BrfferedReader是将字符流放到字符流缓冲区之中。
 */
public class BufferedReaderDemo01 {
	public static void main(String[] args) {
		BufferedReader buf =null;//声明BufferedReader对象
		buf = new BufferedReader(new InputStreamReader(System.in));//实例化BufferedReader
		
		String str =null;				//接收输入内容
		System.out.println("请输入内容：");
		try {
			str = buf.readLine();		//读取输入内容
		} catch (IOException e) {		//要进行异常处理
			e.printStackTrace();
		}
		System.out.println("输入的内容为："+str);
		
	}
}
