package basic.day16;

import java.io.File;
import java.io.FileFilter;

//FileFilter类是对操作文件的过滤，相当于命令：ls|grep pattern
//API方法：File[] listFile(File Filter)
//回调模式与FilerFilter
/**
 * public interface FileFilter用于抽象路径名的过滤器。 
 * 
 * 此接口的实例可传递给 File 类的 listFiles(FileFilter) 方法。
 * 
 * 接口 boolean accept(File pathname)
 * 
 * 测试指定抽象路径名是否应该包含在某个路径名列表中。
 * 
 * 参数： pathname - 要测试的抽象路径名
 * 
 * 返回：当且仅当应该包含 pathname 时返回 true
 * 
 *   回调模式    accept()方法的调用属于回调模式
 *   
 * 有条件列出目录/home/soft01/work/JSD1202_2/test中的.java文件
 */
public class FileFilterDemo {
	public static void main(String[] args) {
		File dir = new File("/home/soft01/work/JSD1202_2/test");
		//方法1
		File[] files = dir.listFiles(new FileFilter() {
			public boolean accept(File afile) {
				System.out.println(afile.getName());
				return afile.getName().endsWith(".java") && afile.isFile();
			}
		});

		
	}
}
