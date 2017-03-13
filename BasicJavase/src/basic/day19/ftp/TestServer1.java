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
public class TestServer1 {
	public static void main(String[] args) {
		try{
			ServerSocket s = new ServerSocket(6000);
			while(true){
				Socket s1 = s.accept();
				OutputStream os = s1.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				//getInetAddress()是超IP地址，getPort()是实际使用的端口号
				dos.writeUTF("Hello"+s1.getInetAddress()
						+"port#"+s1.getPort()+"bye-bye!");
				dos.close();
				s1.close();
			}
		}catch(IOException e){
			e.printStackTrace();
			System.err.println("程序运行出错："+e);
		}
	}
}
