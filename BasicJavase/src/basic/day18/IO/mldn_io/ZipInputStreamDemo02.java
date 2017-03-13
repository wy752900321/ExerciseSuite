package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipInputStreamDemo02 {
	public static void main(String[] args) throws Exception {
		File file = new File("demo"+File.separator+"demo.zip");//找到压缩文件
		File outFile = null;//定义输出的文件对象
		ZipFile zipFile = new ZipFile(file);//实例化ZipFile对象
		ZipInputStream zipInput = new ZipInputStream(new FileInputStream(file));//实例化ZIP输入流
		ZipEntry entry = null;//定义一个ZipEntry对象，用于接收压缩文件中的每一个实体
		InputStream input = null;//定义输入流，用于读取每一个ZipEntry
		OutputStream out =null;//定义输出流，用于输出每一个实体内容
		while((entry=zipInput.getNextEntry())!=null){//得到每一个ZipEntry
			System.out.println("解压缩"+entry.getName()+"文件");
			outFile = new File("demo"+File.separator+entry.getName());//实例化输出文件
			if(!outFile.getParentFile().exists());{//判断文件夹是否存在
				outFile.getParentFile().mkdir();//创建文件夹
			}
			if(!outFile.exists()){//判断文件是否存在
				outFile.createNewFile();
			}
			input = zipFile.getInputStream(entry);//得到压缩实体的输入流
			out = new FileOutputStream(outFile);//实例化输出流对象
			int temp =0;
			while((temp=input.read())!=-1){//读取内容
				out.write(temp);//输出内容
			}
			input.close();//关闭输入流
			out.close();//关闭输出流
		}
	}
}
