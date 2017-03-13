package basic.day19.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/*
 * 只有当食堂开门，我们才能去。我们相当于客户端，食堂相当于服务端，所以要先开启服务端才行
 * 大学时去食堂2餐厅买饭，选一个窗口去买。
 * 命令：telnet localhost 端口号   指连到这个端口的服务器
	telnet 127.0.0.1 8000		 和上边一样
	Server端：
	ServerSocket绑定端口号，new完成后，服务器端就算完成 了，端口为客户提供服务
	.acceput()启动客户端监听
	Socket实例交给客户服务线程处理（Service）
	Client端：
		new Socket（）实例
		与服务器连接成功后，创建Socket实例
		用两个线程write,reader监听
		
		先启支服务端，再启动客户端
 */
public class TCPServerDemo {
	public static void main(String[] args) throws IOException {
		TCPServerDemo server = new TCPServerDemo();
		server.start();
	}
	private void start() throws IOException {
		//端口范围：0～65535，约定我们用不超过10000的，10000以内让系统用
		//ServerSocket构造器会绑定当前服务器的端口8000
		//一个端口只以被绑定一次，如果重复绑定，会发生前异常
		ServerSocket ss = new ServerSocket(8000);//占卖饭窗口
		while(true){
		//accept()方法发生IO Block(IO阻塞),等到IO完成才继续执行
		//目的：在端口8000上等待客户端的连接，如果客户连接成功，
		//就结束Block继续执行，并且返回Socket(套接字)实例s
		//s代表客户端连接，这个连接中包含两个流in和out
		//in代表客户到服务端的输入
		//out代表服务器到客户端的输出
		Socket s = ss.accept();//开始接受服务，向外卖
		//一般会创建客户端服务线程为客户提供业务服务
		new Service(s).start();//一个卖饭窗口可以有n个服务员卖，多个服务员同时外卖，多线程
		}
	}
	/**客户服务线程，为每个客户开启一个线程实例*/
	private class Service extends Thread{
		Socket s;//s代表客户
		public Service(Socket s){
			this.s = s ;
		}
		/**在run方法中要提供为客户的服务处理*/
		public void run(){//run的异常不能外抛的,不然run
			try{
			//服务端的in代表客户端的到服务器的信息发送
			//客户说什么都从in 中获得
			//服务端的out代表服务器到客户端信息发送
			//服务员对客户的反馈在out中
			InputStream in = s.getInputStream();
			OutputStream out = s.getOutputStream();
			//约定客户端发送来的是文本，文本消息使用换行作为间隔
			//因为流中可以传任何对象，所以要约定
//			Scanner s = new Scanner(in);//和下面两行一样，从客户端读
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			out.write("hello,what do you want?\n".getBytes());//表示在获取客户说话前，给客户打个招呼。
			out.flush();
			while(true){
			//readLine()时，出现IOBlock，等待！只有流中有信息时才行，流中信息就是客户端发来的信息
			String str = reader.readLine();//出现回车才进行下一步。
			if(str.equals("apple")){
				out.write("我们没有苹果啊！\n".getBytes());//看到\n(换行)才进行下一步
				out.flush();//写出，目标是客户端，不写出，客户端可能看不见
			}if(str.equals("ls")){
				File dir = new File(".");
				File[] files = dir.listFiles();
				for(File file:files){
					out.write((file.getName()+"\n").getBytes());
				}
				out.flush();
			}else if (str.equals("fish")){
				out.write("不乖的孩子没鱼吃！\n".getBytes());
				out.flush();
			}else if(str.equals("dumpling")){
				out.write("就你，还想吃饺了！\n".getBytes());
				out.flush();
			}else if(str.equals("bye")){
				out.write("再见，欢迎下次再来！\n".getBytes());
				out.flush();
				this.s.close();//in和out属于Socket。所以只要关了Socket就行了
				break;
			}
			}
			
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
