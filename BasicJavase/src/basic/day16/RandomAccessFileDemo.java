package basic.day16;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * 随机文件读写演示 任务： A 在demo文件夹中创建raf.dat B 打开这个文件 C 写入‘A’和‘B’ D 写入GBK编码的‘中’，d6d0 E
 * 写入整数0x7fffffff(int类型最大值） F 一次性读取文件内容
 */
/*
 * raf.write( 'A' )的写入过程： 
 * 首先，字符 A 在内存中是 16 位无符号整数 0000 0000 0000 0041
 * 其次，自劢类型转换，转为 int 类型 0000 0000 0000 0000 0000 0000 0000 0041 
 * 最后，截取高 8 位，将低 8位的数据写入“流”中 0000 0041
 * 
 */
public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		// 创建目录 demo
		File demo = new File("demo");
		if (!demo.exists()) {
			demo.mkdir();
		}
		// A 在demo文件夹中创建raf.dat
		File file = new File(demo, "raf.dat");
		if (!file.exists()) {
			file.createNewFile();
		}
		// B 打开这个文件进行随机读取
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		// 输出默认的‘游标“位置
		System.out.println(raf.getFilePointer());// 0
		// C 写入字符‘A’和‘B’
		raf.write('A');
		System.out.println(raf.getFilePointer());// 1
		raf.write('B');
		// D 写入整数0x7fffffff
		// D-1写入int 数据的底层写法
		int i = 0x7fffffff;
		raf.write(i >>> 24);// i>>>24 00 00 00 7f
		raf.write(i >>> 16);// i>>>16 00 00 7f ff
		raf.write(i >>> 8);// i>>>8 00 7f ff ff
		raf.write(i);// i 7f ff ff ff
		// D-2 写入int数据的封装方法
		raf.writeInt(i);
		// E 写入GBK编码的字符‘中’，GBK编码为d6d0
		String s = "中";// 默认系统编码为4e2d
		// E-1 得到‘中’的gbk编码形式
		byte[] gbk = s.getBytes("gbk");// gbk={d6,d0 }
		raf.write(gbk);
		System.out.println(raf.length());// 12
		System.out.println(raf.getFilePointer());// 12

		// 移动文件游标到“头'
		raf.seek(0);
		// F 一次性读取全部内容到buf中
		byte[] buf = new byte[(int) raf.length()];
		// F-1 从文件中读取内容到时buf数组，尽可能填满
		raf.read(buf);
		// F-2 输出byte数组（默认按10进制打印）
		System.out.println(Arrays.toString(buf));
		// F-3 输出16进制形式
		for (byte b : buf) {
			System.out.println(Integer.toHexString(b & 0xff) + "");
		}
		// 关闭
		raf.close();
	}
}
/**
 * 4. RandomAccessFile ** RandomAccessFile 类是 Java 提供的功能丰富的文件内容访问类，它提供了众多方法来访问文件
 * 内容，既可以读取文件内容，也可以向文件输出数据，RandomAccessFile 支持“随机访问”方式，可 以访问文件的任意位置。 1) Java
 * 文件模型 在硬盘上文件是 byte by byte 存储的，是数据的集合 2) 打开文件 有两种模式 "r w"（读写),"r"（只读）
 * RandomAccessFile raf = new RandomAccessFile(file, "r w"); 打开文件时候默认文件指针在开头
 * pointer=0 3) 写入方法 raf.write(int)可以将整数的“低八位”写入到文件中，同时指针自动移动到下一个位置, 准备 再次写入
 * 注意：文件名的扩展名要明确指定, 没有默认扩展名现象！ RandomAccessFile raf = new
 * RandomAccessFile("Hello.java", "r w"); 4) 读取文件 int b = raf.read() 从文件中读取一个
 * byte(8 位) 填充到 int 的低八位, 高 24 位为 0, 返回值 范围正数: 0~255, 如果返回-1 表示读取到了文件末尾!
 * 每次读取后自动移动文件指针, 准备下次读取。 5) 文件读写完成以后一定关闭文件 Sun
 * 官方说明，如果不关闭，可能遇到一些意想不到的错误，根据具体操作平台不同会有不同。 在使用过程中，切忌文件读写完成后要关闭文件。
 */
