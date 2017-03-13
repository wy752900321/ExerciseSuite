package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {
	/**
	 * 	读文件 的通用 方法设计
	 * @param in		把文件读到流中，从硬盘->程序  
	 * @param out		把流中的数据取出来，从程序 ->文件 
	 */
	public static void in2Out(InputStream in,OutputStream out){
		try{
			int len = 0;
			byte buffer[] = new byte[1024];
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			if(in!=null){
				try{
					in.close();
				}catch(IOException e){}
				if(out!=null){
					try{
						out.close();
					}catch(IOException e){}
				}
			}
		}
	}
	public static void in2Out2(InputStream in,OutputStream out){
		try{
			int len=0;
			byte buffer[] = new byte[1024];
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			if(in!=null)
				try{
					in.close();
				}catch(IOException e){}
		}
	}
}
