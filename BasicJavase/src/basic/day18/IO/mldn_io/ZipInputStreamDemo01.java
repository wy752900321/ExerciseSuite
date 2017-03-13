package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 取得demo.zip中的ZipEntry
 *  ZipInputStream类：是InputStream的子类，通过此类可以方便读取zip格式的文件，常用方法如下：
 	public ZipInputStream(InputStream in)	构造	实例化ZipInputStream对象
 	public ZipEntry getEntry()throws IOException 取得下一个ZipEntry
 	可以像ZipFile一样取得ZIP压缩文件中的每个ZipEntry.
 */
/*
 * ZipInputStream类的getNextEntry()方法可以依次取得每一个ZipEntry。
 * 将此类与ZipFile结合就可以进行解压缩操作。但需要注意的是，在demo.zip文件中本身是包含压缩的文件夹的，所以在进行解压前，
 * 应该先根据ZIP文件中的文件夹的名称在硬盘上创建好一个对应的文件夹，然后才能把文件解压缩进去，而且在操作过程时对于每一个解压缩
 * 文件都必须先创建（File类的createNewFile()方法可以创建新文件）后再将内容输出
 * 
 */
public class ZipInputStreamDemo01 {
	public static void main(String[] args) throws IOException {
		File zipFile = new File("demo"+File.separator+"demo.zip");//定义压缩文件名称
		ZipInputStream input = null;//定义压缩输入流
		input = new ZipInputStream(new FileInputStream(zipFile));//实例化压缩输入流
		ZipEntry entry = input.getNextEntry();//得到一个压缩实体
		System.out.println("压缩实体名称："+entry.getName());//输出实体名称
		input.close();//关闭压缩输入流
	}
}
