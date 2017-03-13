package test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class ListFielDemo {
	public static void main(String[] args) {
		File dir = new File("/etc");
		File[] files = dir.listFiles();
		System.out.println(files);
		Arrays.sort(files,new Comparator<File>(){
			public int compare(File o1,File o2){
				if(o1.isDirectory()==o2.isDirectory()){
					return o1.getName().compareTo(o2.getName());
				}
				return o1.isDirectory() ?-1:1	;
			}
			
		});//排序，内部类
		
		//方法
	}
}
