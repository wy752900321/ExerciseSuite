package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/**
 * 实例化zipFile对象，并通过getName()方法取得压缩文件的名称
 * 输出：压缩文件的名称为：demo/demo.zip
 */
public class ZipFileDemo01 {
	public static void main(String[] args) throws Exception {
		File file = new File("demo"+File.separator+"demo.zip");//找到压缩文件
		ZipFile zipFile = new ZipFile(file);//实例化ZipFile对象
		System.out.println("压缩文件的名称为："+zipFile.getName());
	}
}
