package tarena.employment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/** rfc tcp */
public class TCPClientDemo {
  public static void main(String[] args) {
    TCPClientDemo clent = new TCPClientDemo();
    clent.open();
  }
  public void open(){
    try{
      //服务器要先启动, 才能去连接
      //new Socket() 构造方法会连接服务器, 连接成功返回Socket
      //实例 s, 连接失败抛出异常, s代表客户端到服务器的连接
      Socket s = new Socket("localhost", 8000);
      InputStream in = s.getInputStream();
      OutputStream out = s.getOutputStream();
      new Writer(in, s).start();
      new Reader(out, s).start();      
    }catch(IOException e){
      e.printStackTrace();
      System.out.println("服务器连接失败!"); 
    }
  }
  /** 负责将服务器发送来的消息写的控制台上 */
  class Writer extends Thread{
    InputStream in;
    Socket s;
    public Writer(InputStream in, Socket s) {
      this.in = in;
      this.s = s;
      setDaemon(true);
    }
    public void run(){
      //负责将服务器发送来的消息写的控制台上
      Scanner sc = new Scanner(in);
      while(true){
        String str = sc.nextLine();
        System.out.println(str);
      }
    }
  }
  /** 将控制台上的消息发送到服务器端 */
  class Reader extends Thread{
    OutputStream out;
    Socket s;
    public Reader(OutputStream out, Socket s) {
      this.out = out;
      this.s = s;
    }
    public void run() {
      Scanner sc = new Scanner(System.in);
      try{
        while(true){
          String str = sc.nextLine();
          out.write((str+"\n").getBytes());
          out.flush();
          if(str.equals("bye")){
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










