package basic.day16;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RafDemo2 {
	public static void main(String[] args) throws IOException {
		String file = "raf.demo";
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// raf.write(-2);
		raf.writeInt(-2);// 将-2序列化为4个byte写入到时文件中
		raf.writeLong(-2L);//按八个字节将 long 写入该文件，先写高字节。
		raf.writeDouble(3.141592653589793);
		raf.seek(0);
		int b;
		while((b=raf.read())!=-1){
			if(b<=0xf){
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+" ");
		}
		System.out.println();
		//必须足够了解文件内容才能合理读取文件
		raf.seek(12);//移动游标到时double数据的起始位置，读取数据
		double pi = raf.readDouble();
		System.out.println(pi);
		//一个简单办法：按照写入是顺序读取
		
		raf.close();
	}
}
