package basic.day18.IO;

import java.io.File;
import java.io.IOException;

/**
 * java.io.File类 File可以创建和删除一个文件，也可以创建和删除一个空目录
 * 注：File类是不可能访问得到文件的内容的！！
 * isDirectory()和isFile()可以用来判断是一具文件或目录。
 * delete()方法可以删除一个文件或目录；如果要删除目录，目录必需为空才行
 * deleteOnExit()方法：此方法不会立即删除文件或目录，而是要等到程序运行结束后，
 *					才会去删除；常用于控制临时文件
 *list()方法：返回由此抽象路径名所表示的目录中的文件和目录的名称所组成字符串数组.
 *		如果此抽象路径并不表示一个目录，则此方法将返回null
 */
public class TestFileDemo {
	public static void main(String[] args) throws IOException {
		File file = new File(".");
		String path = file.getAbsolutePath();
		System.out.println(path);// /home/soft01/work/JSD1202_2/当前工程目录

		File f1 = new File("file1.txt");// 创建一个File对象，此时磁盘上还没有file.txt文件
		f1.createNewFile();// 此时才会在磁盘上创建一个文件，名为file.txt
		File dir = new File("test/test2/test3");
		// 在当前目录下的test/test2子目录中创建test3子目录，如果没有test/test2子目录则创建不成功
		dir.mkdir();
		// 在当前目录下，如果父目录test/test2不存在，则会先把父目录创建好，再建子目录。如果父目录存在，则直接创建子目录
		dir.mkdirs();
		File home = new File("/etc");
		String[] list = home.list();
		for(int i=0;i<list.length;i++){
			//可以得到此目录中的所有的目录名和文件名所表示的字符串
		}
	}
}
