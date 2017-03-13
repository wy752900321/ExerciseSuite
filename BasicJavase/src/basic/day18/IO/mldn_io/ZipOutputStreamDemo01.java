package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * 压缩流：java中可将文件压缩成ZIP,JAR,GZIP等形式
 	ZIP是一种常用的压缩形式，在java中要实现ZIP的压缩需要导入java.util.zip包。可以使用此包中
 	ZipFile,ZipOutputStream,ZipInputStream和ZipEntry几个类来实现操作。
 	
 	ZipOutputStream类的常用方法：
 		public ZipOutputStream(OutputStream out)	构造	创建新的ZIP输出流
 		public void putNextEntry(ZipEnty e)throw IOEception 设置每一个ZipEntry对象
 		pulic void setComment((string connment)		设置ZIP文件的注释
 
 */
public class ZipOutputStreamDemo01 {
	public static void main(String[] args) throws IOException {
		File file = new File("demo"+File.separator+"demo1.txt");//定义要压缩的文件
		File zipFile = new File("demo"+File.separator+"demo.zip");//定义压缩文件名
		InputStream input  =new FileInputStream(file);//定义输入文件流
		
		ZipOutputStream zipOut =null;//定义压缩输出流
		//实例化压缩输出流对象，并指定压缩文件的输出路径
		zipOut=new ZipOutputStream(new FileOutputStream(zipFile));
		//每一个被压缩的文件都用ZipEntry表示，需要每一个压缩后的文件设置名称
		zipOut.putNextEntry(new ZipEntry(file.getName()));//创建ZipEntry
		zipOut.setComment("www.mldnjava.cn");//设置注释
		int temp =0;//接收输入的数据
		while((temp=input.read())!=-1){//读取内容
			zipOut.write(temp);//压缩输出内容
		}
		input.close();//关闭输入流
		zipOut.close();//关闭压缩输出流
	}
}
