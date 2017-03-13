package basic.day18.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * 在java中，凡是跨越虚拟机的范围的一定要自己主动释放。
 * 字节流实现文件 的拷贝如下：
 */
public class TestCopy {
	public static void main(String[] args) throws IOException {
//		FileInputStream fis = new FileInputStream("源文件名");
		FileInputStream fis = new FileInputStream("demo.txt");
		BufferedInputStream bis =new BufferedInputStream(fis);
		
//		FileOutputStream fos = new FileOutputStream("目标文件名");
		FileOutputStream fos = new FileOutputStream("utf16be.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] b = new byte[1024];//做为缓冲区，大小为1K
		int len;//保存读到的实际字节节数
		while((len=bis.read(b))!=-1){
			bos.write(b,0,len);//写到SOCKET中
			bos.flush();//清空缓冲区，记得要写哦！！！一定要写
		}
	}
}
