package basic.day15;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		//new File(".")在内存中创建一个对象，并不是在文件系统上创建目录或文件
		File dir = new File(".");
		//getCanonicalPath()获取标准的绝对路径名
		String pathname = dir.getCanonicalPath();
		// 在eclipse中，当前目录是”项目文件夹“
		System.out.println(pathname);//pwd
		
		//在内存中创建一个File对象，不代表在文件系统上创建目录或文件
		File demo = new File(dir,"demo");//第一个parameter是父目录，第二个parameter是子目录
		File file = new File(demo,"file.dat");//demo下有个子目录file.dat
		//可以利用File API方法检测这文件／目录是否存在 
		System.out.println(demo.exists());//exists相当于ls .|grep demo命令
		if(!demo.exists()){
			demo.mkdir();//在文件系统创建文件夹,相当于命令mkdir demo
		}
		System.out.println(demo.exists());//true
		if(!file.exists()){
			file.createNewFile();//在文件系统创建新的空白文件。
		}
		long create = demo.lastModified();//最后编辑时间
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(demo.isFile());//false
		System.out.println(demo.isDirectory());//true
		System.out.println(demo.canRead());//true
		System.out.println(demo.canWrite());//true
		System.out.println(demo.isHidden());//false
		System.out.println(demo.length());//文件长度long,4k
		System.out.println(demo.getName());//文件名
		System.out.println(demo.getParent());//..父目录
		System.out.println(demo.getCanonicalPath());//.的所在路径，规范路径名，不会有"."
		file.delete();//rm,delete只能删空文件夹，所以不能和下面的反过来写
		demo.delete();//rm
	}
}
