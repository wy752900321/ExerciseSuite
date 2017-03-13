package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 解压缩,demo/demo.zip,demo.zip是demo1.txt的压缩文件
 */
public class ZipFileDemo02 {
	public static void main(String[] args) throws Exception {
		File file = new File("demo" + File.separator + "demo.zip");// 找到压缩文件
		File outputFile = new File("demo" + File.separator + "demo.txt");// 定义解压缩的文件名称,随便取
		ZipFile zipFile = new ZipFile(file);// 实例化ZipFile对象
		// 得到一个压缩实体，解压的是demo1.txt的压缩包，名字不能变
		ZipEntry entry = zipFile.getEntry("demo1.txt");
		InputStream input = zipFile.getInputStream(entry);// 得到一个压缩实体
		OutputStream out = new FileOutputStream(outputFile);// 实例化输出流对象
		int temp = 0;// 保存接收数据
		while ((temp = input.read()) != -1) {// 读取内容
			out.write(temp);// 输出内容
		}
		input.close();// 关闭输入流
		out.close();// 关闭输出流
	}
}
