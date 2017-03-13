package basic.day17.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class IOUtils_02 {
	/**
	 * 读取文件并且按照16进制输出，第10byte为一行
	 * @throws IOException 
	 */
	public static void printHex(String fileName) throws IOException{
		//1.创建文件输入流对象
		FileInputStream in = new FileInputStream(fileName);
		int b ;
		//2.循环读取byte
		while((b=in.read())!=-1){
			if(b<=0xf){
				System.out.println("0");
			}
			System.out.println(Integer.toHexString(b)+" ");
		}
		in.close();
	}
	//printHex（String fileName)的重载方法
	public static void printHex(File file) throws IOException{
//		1创建文件输入流对象
		FileInputStream in= new FileInputStream(file);
		int b;
		//2循环读取byte
		while((b=in.read())!=-1){
			if(b<=0xf){
				System.out.println("0");
			}
			System.out.println(Integer.toHexString(b)+" ");
		}
		in.close();
	}
	//printHex(String fileName)的重载方法
	public static void printHex(InputStream in) throws IOException{
		int b;
		while((b=in.read())!=-1){
				if(b<=0xf){
					System.out.println("0");
				}
				System.out.println(Integer.toHexString(b)+" ");
		}
		in.close();
	}
}
