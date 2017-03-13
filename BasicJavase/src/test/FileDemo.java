package test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		File dir = new File(".");
		String pathname = dir.getCanonicalPath();
		System.out.println(pathname);///home/soft01/work/JSD1202_2
		
		File demo = new File(dir,"demo");//
		File file = new File(demo,"file.dat");
		if(!demo.exists()){
			demo.mkdir();
		}
		System.out.println(demo.exists());//true
		if(!file.exists()){
			file.createNewFile();
		}
		long create = demo.lastModified();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println(demo.isFile());
		System.out.println(demo.isDirectory());
		System.out.println(demo.canRead());
		System.out.println(demo.canWrite());
		System.out.println(demo.isHidden());
		System.out.println(demo.getParent());
		System.out.println(demo.getCanonicalPath());///home/soft01/work/JSD1202_2/demo
		file.delete();
		demo.delete();
	}
}
