package basic.day16;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;

/**
 * 输出流演示
 */
public class OutputStreamDemo {
	public static void main(String[] args) throws IOException{
		String file = "out.demo";
		//OutputString是输出流，代表从内存（变量／对象）到外部（文件）的输出，
		//方法out.write(int)每次可以输出一个byte
		//FileOutputStream是OutputStream的实现类，在磁盘文件上
		//实现了输出方法，out.write(int)每次向文件输出一个byte
		//重载的out.write(byte[])方法可以将byte数组的内容全部写入文件中
		OutputStream out = new FileOutputStream(file);
		//data:	  41	42	43	d6	d0	??	??
		//index:   0	1	2	3	4	5	6	7	8	9	10
		//pointer:	
		out.write(0x841);
		out.write(66);
		out.write('C');//67.十六位的，只把低八位写出来了。
		byte[] buf = "中国".getBytes("GBK");//{d6,d0,??,??}
		out.write(buf);
		out.write(buf, 0, 2);
		out.flush();//清理系统缓存，保证数据的可靠写入
		out.close();//清理缓存，关闭文件，文件使用完一定关闭
		//父类收用指向子类对象
		//
		InputStream in = new FileInputStream(file);
		int b ;
		while((b = in.read())!=-1){
			if(b<=0xf){
				System.out.println("0");
			}
			System.out.print(Integer.toHexString(b)+" ");
		}
		System.out.println();
		in.close();
	}
}
