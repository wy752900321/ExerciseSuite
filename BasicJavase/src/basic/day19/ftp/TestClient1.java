package basic.day19.ftp;

import java.io.*;
import java.net.*;

/*范例名称：简单的client/server程序
 * 源文件名称：TestClient1.java/TestServer1.java
 * 要点：
 * 	1.Java Socket编程步骤
 *	2.Socket/ServerSocket类用法
 *	3.通过Socket对象可以获取通信对方Socket的信息
 */
public class TestClient1 {
	public static void main(String[] args) {
		try{
			Socket s1 = new Socket("127.0.0.1",6000);
			InputStream is = s1.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
			dis.close();
			s1.close();
		}catch(ConnectException connExe){
			connExe.printStackTrace();
			System.out.println("服务器连接失败！");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
