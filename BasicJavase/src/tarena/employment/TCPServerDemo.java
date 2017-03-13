package tarena.employment;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerDemo {
  public static void main(String[] args) throws IOException {
    TCPServerDemo server = new TCPServerDemo();
    server.start();
  }
  public void start() throws IOException {
    //ServerSocket 构造器会绑定当前服务器的端口8000
    //一个端口只能被绑定一次, 如果重复绑定, 会发生前异常!
	//服务器要先启动，才能去连接
	// new Socket()构造方法会连接服务器(与accept()方法相关联)，
	// 连接成功返回Socket实例s, 连接失败抛出异常，s代表客户端到服务器的连接
    ServerSocket ss = new ServerSocket(8000);
    while(true){
      //accept() 方法发生IO Block(IO阻塞), 等到IO完成才继续执行
      //目的: 在端口8000上等待客户端的连接, 如果客户连接成功
      // 就结束Block继续执行, 并且返回Socket(套接字)实例 s
      // s 代表客户端连接, 这个连载中包含两个流 in和out
      // in 代表客户到服务端的输入
      // out 代表服务器到客户端的输出
      Socket s = ss.accept();
      // 一般会创建客户端服务线程为客户提供业务服务
      new Service(s).start();
    }
  }
  /** 客户服务线程, 为每个客户开启一个线程实例 */
  private class Service extends Thread{
    Socket s;
    public Service(Socket s) {
      this.s = s;
    }
    /** run方法中要完成对客户的服务处理 */
    public void run(){
      try{
        //服务端的in代表客户端的到服务器的信息发送
        //服务端的out代表服务器到客户端信息发送
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        //约定客户端发送来的是文本, 文本消息使用换行作为间隔
        //Scanner s = new Scanner(in);
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(in));
        out.write("您好, 您点啥?\n".getBytes());
        out.flush();
        while(true){
          String str = reader.readLine();
          if(str.equals("粗面")){
            out.write("没有粗面\n".getBytes());
            out.flush();
          }if(str.equals("ls")){
            File dir=new File(".");
            File[] files = dir.listFiles();
            for (File file : files) {
              out.write((file.getName()+"\n").getBytes());
            }
            out.flush();
          }else if(str.equals("包子")){
            out.write("给你包子\n".getBytes());
            out.flush();
          }else if(str.equals("bye")){
            out.write("再见, 欢迎下次再来!\n".getBytes());
            out.flush();
            this.s.close();
            break;
          }
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
}