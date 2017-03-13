package basic.day17.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//IO工具类中增加读取文件内容的方法read(String filename)及重载方法read(File file)，该方法适用于读取小文件
public class IOUtils {
	/**
	 * 读取文件内容到byte数组中，适用于小文件
	 * @throws IOException 
	 */
	public static byte[] read(String filename) throws IOException{
		File file = new File(filename);
		//1.按照文件长度创建byte数组
		byte[] buf = new byte[(int)file.length()];
		//2.打开文件
		FileInputStream in = new FileInputStream(file);
		//3.读取文件，read方法尽可能多的读取流中数据，填充到buf返回值size是读取的数量
		int size = in.read(buf);//一次读取全部
		in.close();
		return buf;
	}
	//重载方法
	public static byte[] read(File file) throws IOException{
		//1.按照文件长度创建byte数组
		byte[] buf = new byte[(int)file.length()];
		//2.打开文件
		FileInputStream in = new FileInputStream(file);
		//3.读取文件，read方法尽可能多的读取流中数据，填充到buf返回值size是读取的数量
		int size = in.read(buf);//一次读取全部
		in.close();
		return buf;
	}
}
