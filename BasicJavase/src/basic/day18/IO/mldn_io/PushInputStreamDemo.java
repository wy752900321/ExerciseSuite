package basic.day18.IO.mldn_io;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

/**回退流 
 *	内存中有一个"www.mldnjava.cn"字符串，只要输入的内容是"."则执行回退操作，即不读取"."
 */
public class PushInputStreamDemo {
	public static void main(String[] args) throws Exception {
		String str = "www.mldnjava.cn";//定义字符串
		PushbackInputStream push =null;//定义回退流对象
		ByteArrayInputStream bai = null;//定义内存输入流
		bai = new ByteArrayInputStream(str.getBytes());//实例化内存输入流
		push = new PushbackInputStream(bai);//实例回退流对象
		System.out.println("读取之后的数据为：");
		int temp = 0;//接收数据
		while((temp=push.read())!=-1){//读取内容
			if(temp=='.'){
				push.unread(temp);//回退到缓冲区前面
				temp=push.read();//空出此数据
				System.out.println("(退回"+(char)temp+")");
			}else{
				System.out.println((char)temp);//输出内容
			}
		}
	}
}
