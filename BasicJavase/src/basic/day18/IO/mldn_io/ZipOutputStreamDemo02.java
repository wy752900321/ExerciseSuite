package basic.day18.IO.mldn_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**压缩文件夹
 *	1.列出全部文件
 *	2.是否还是文件？
 *		是,取出每个File
 *	3.设置ZipEntry
 *	4.保存ZipEntry,将内容写入压缩输出流
 *	5.返回，继续判断2内容。
 *	如果2中不成立，直接关闭压缩输出流。
 *
 * 	在每一个压缩文件中都会存在多个子文件，那么每一个子文件在java中使用ZipEntry表示。ZipEntry常用方法如下：
 	public ZipEntry(string name)	构造		创建对象并指定要创建的ZipEnty名称
 	public boolean isDirectory()	普通		判断此ZipEnty是否是目录
 	
 	ZipOutputStream类的常用方法：
 		public ZipOutputStream(OutputStream out)	构造	创建新的ZIP输出流
 		public void putNextEntry(ZipEnty e)throw IOEception 设置每一个ZipEntry对象
 		pulic void setConment(string connment)		设置ZIP文件的注释
 */
public class ZipOutputStreamDemo02 {
	public static void main(String[] args) throws Exception {
		File file = new File("demo" + File.separator + "file");//要压缩的文件夹
		File zipFile = new File("demo" + File.separator + "file.zip");// 压缩文件的名称
		InputStream input = null;// 定义文件输入流
		ZipOutputStream zipOut = null; // 定义压缩输出流
		zipOut = new ZipOutputStream(new FileOutputStream(zipFile));// 实例化压缩输出流
		zipOut.setComment("www.mldnjava.cn");// 设置注释
		if (file.isDirectory()) {// 判断是否是目录
			File lists[] = file.listFiles();// 列出全部文件
			for (int i = 0; i < lists.length; i++) {
				input = new FileInputStream(lists[i]);// 设置文件输入流
				// 每一个被压缩的文件都用ZipEntry表示，需要为每一个压缩后的文件设置名称
				zipOut.putNextEntry(new ZipEntry(file.getName()
						+ File.separator + lists[i].getName()));// 创建ZipEntry
				int temp = 0;// 接收输入数据
				while ((temp = input.read()) != -1) {// 读取内容
					zipOut.write(temp);// 压缩输出内容
				}
				input.close();// 关闭输入流
			}
		}
		zipOut.close();// 关闭压缩输出流
	}
}
