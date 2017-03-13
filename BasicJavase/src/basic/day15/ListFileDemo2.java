package basic.day15;

import java.io.File;
import java.io.FileFilter;

public class ListFileDemo2 {
	public static void main(String[] args) {
		// ls /etc
		// ls /etc | grep pass
		File etc = new File("/etc");// new File("c:/window");
		// 方法3,这个做点改变，只接受文件。
		File[] files = etc.listFiles(new FileFilter() {
			public boolean accept(File file) {
				System.out.println("正在过滤：" + file.getName());
				boolean accept = file.getName().matches(".*pass.*")
						&& file.isFile();// 并且是文件
				if (accept)
					System.out.println("接受了文件" + file.getName());
				else
					System.out.println("过滤掉：" + file.getName());
				return accept;
			}
		});
		//		
		// // 方法2，工作中
		// File[] files = etc.listFiles(new FileFilter() {
		// public boolean accept(File file) {
		// System.out.println("正在过滤：" + file.getName());
		// return file.getName().matches(".*pass.*");//改成如下：
		//
		// }
		// });

		// listFiles(filter)方法会将etc目录中的每个文件(目录)交给filter.accept(file)进行过滤，
		// 如果这个方法返回true则这个文件就被接受下来，作为返回结果。
		// filter.accept(file)方法是被listFiles(filter)方法调用的。accept(file)方法的参数file
		// 会动态绑定到每个etc文件夹中的文件／目录。

		// 方法1
		// FileFilter filter = new FileFilter(){
		// public boolean accept(File file) {
		// System.out.println("正在过滤："+file.getName());
		// return file.getName().matches(".*pass.*");
		// }};//内部类，过滤器，过滤结果
		// File[] files = etc.listFiles(filter);

		for (File file : files) {
			System.out.println(file.getName());
		}
	}
}
/**
 * 
 * boolean accept = file.getName().matches(".*pass.*")&&file.isFile();//并且是文件
 * if(accept) System.out.println("接受了文件"+file.getName()); else
 * System.out.println("过滤掉："+file.getName());
 */
