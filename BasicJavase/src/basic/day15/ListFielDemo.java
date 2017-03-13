package basic.day15;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class ListFielDemo {
	public static void main(String[] args) {
		// File dir = new File(".");
		File dir = new File("/etc");
		File[] files = dir.listFiles();// ls -a .
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File o1, File o2) {
				// 如果同时是目录或文件，按照文件名比较
				// File类默认的比较方法compareTo是按照文件名比较的
				if (o1.isDirectory() == o2.isDirectory()) {
					// return o1.compareTo(o2);//相当下边这句，按文件名比
					return o1.getName().compareTo(o2.getName());
				}
				// 如果是目录，一定比文件小，返回-1
				return o1.isDirectory() ? -1 : 1;
			}
		});// 排序,内部类
		// 方法2
		for (File file : files) {// java 5提供的简化版for迭代！for ..each..
			if (file.isDirectory()) {
				System.out.println("[" + file.getName() + "]");
			} else {
				System.out.println(file.getName());
			}
		}
		// 方法1
		// for(int i = 0;i<files.length;i++){
		// File file = files[i];
		// if(file.isDirectory()){
		// System.out.println("["+file.getName()+"]");
		// }else{
		// System.out.println(file.getName());
		// }
		// }
	}
}
