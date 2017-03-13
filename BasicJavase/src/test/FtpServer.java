package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/** 
 * 模拟FTP服务器, 支持命令pwd,ls,get file
 * 
 * 协议:  type,length,value  TLV格式
 * 
 *   文本: text,5\nline1\nline2\nline3\nline4\nline5\n
 *   文件: file,4,filename\n 41 42 43 44 
 *   
 *   text,5\nline1\nline2\nline3\nline4\nline5\nfile,4,filename\n 41 42 43 44
 */

public class FtpServer {
  public static void main(String[] args)
    throws IOException{
    FtpServer server = new FtpServer();
    server.start();
  }
  
  public void start() throws IOException{
    ServerSocket ss = new ServerSocket(6666);
    while(true){
      Socket s = ss.accept();
      new Agent(s).start();
    }
  }
  class Agent extends Thread{
    Socket s;
    public Agent(Socket s) {
      this.s = s;
    }
    public void run() {
      try{
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        //向客户端发送, 先发协议头,再发送文本行
        out.write("text,1\n".getBytes());//协议头
        //发送消息内容, 一行文本消息
        out.write("欢迎使用FTP演示服务器!\n".getBytes());
        out.flush();
        while(true){
          //读取客户端发送到命令
          String cmd = IOUtils.readLine(in).trim();
          if("pwd".equals(cmd)){//显示当前目录
            pwd(out);
          }else if("ls".equals(cmd)){
            ls(out);
          }else if(cmd.startsWith("get ")){
            get(cmd, out);
          }else if("bye".equalsIgnoreCase(cmd)){
            IOUtils.println(out, "text,1");
            IOUtils.println(out, "Bye, Bye!");
            s.close();
          }else{
            out.write("text,1\n".getBytes());//协议头
            out.write("只支持pwd,ls,get,bye!\n".getBytes());
            out.flush();
          }
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
  public void pwd(OutputStream out) 
    throws IOException{
    File dir = new File(".");
    IOUtils.println(out, "text,1");
    IOUtils.println(out, dir.getCanonicalPath());
  }
  public void ls(OutputStream out)
    throws IOException{
    File dir = new File(".");
    File[] files = dir.listFiles();
    IOUtils.println(out, "text,"+files.length);
    for (File f : files) {
      if(f.isDirectory()){
        IOUtils.println(out, "["+f.getName()+"]");
      }else{
        IOUtils.println(out, f.getName());
      }
    }
  }

  public void get(String cmd, OutputStream out)
    throws IOException{
    //cmd="get filename"
    String name = cmd.split("\\s+")[1];
    File file = new File(name);
    if(! file.exists()){
      IOUtils.println(out, "text,1");
      IOUtils.println(out, "没有文件呀!"+name);
      return;
    }
    //文件协议头: 
    IOUtils.println(out, 
        "file,"+file.length()+","+name);
    FileInputStream in = 
      new FileInputStream(file);
    IOUtils.cp(in, out);
    out.flush();
    in.close();
    IOUtils.println(out, "text,1");
    IOUtils.println(out, "发送成功:"+name);
  }
}





