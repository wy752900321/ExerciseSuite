package basic.day17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.stream.FileImageInputStream;

import basic.day16.IOUtils;

/**
 * 编码重点 UTF－8，UTF-16BE，GBK(GB2312)，ISO8859－1
 * utf-16be是2个字节  UTF-8英文1个字节，中文三个字节
 */
public class CharEncodingDemo {
	public static void main(String[] args) throws IOException {
		String str = "ABCDE中国";// char(unicode)序列
		System.out.println(str);
		// 将十六位unicode char序列编码为byte序列，使用编码方案utf-16be
		// utf-16be,将一个16位的char从中间拆分为两个byte
		// 如：‘A’（0041）拆分为［00 41］
		System.out.println("UTF-16BE");
		byte[] utf16be = str.getBytes("UTF-16BE");
		String file = "utf16be.txt";// utf-16编码的文本文件
		OutputStream out = new FileOutputStream(file);
		out.write(utf16be);
		out.close();

		IOUtils.print(file);// 00 41 00 42 00 43 00 44 00 45 4e 2d 56 fd

		System.out.println("UTF-8");
		// 中： 4e2d 0100 1110 0010 1101
		// utf-8:e4 b8 ad: 1110 0100 1011 1000 1010 1101
		// 符号位：1110 10.. .... 10.. ....形式
		// 中： 4e2d: 1110 0100 1011 1000 1010 1101
		// utf-8:e4 b8 ad: 1110 0100 1011 1000 1010 1101
		byte[] utf8 = str.getBytes("utf-8");
		file = "utf8.txt";
		out = new FileOutputStream(file);
		out.write(utf8);
		out.close();
		IOUtils.print(file);// 41 42 43 44 45 e4 b8 ad e5 9b bd
		// GBK中文本地编码，中国标准支持全部中国字符（20000＋）字符
		// 采用编码：1－2字节 其中英文是1字节，中文2字节
		// GBK不能支持全部国际字符
		// 中： 4e 2d
		// GBK: d6 d0
		// GB2312:d6 d0
		// java内部是用散列表实现的查找
		// GB2312是GBK的子集，GB2312支持6000多个常用汉字
		System.out.println("GBK");
		byte[] gbk = str.getBytes("GBK");
		file = "gbk.txt";
		out = new FileOutputStream(file);
		out.write(gbk);
		out.close();
		IOUtils.print(file);// 41 42 43 44 45 d6 d0 b9 fa

		// 关于ISO8859-1编码：是西欧编码方案，支持字母和符号，不支持中文
		System.out.println("ISO8859-1");
		byte[] iso8895 = str.getBytes("ISO8859-1");
		file = "iso8859.txt";
		out = new FileOutputStream(file);
		out.write(iso8895);
		IOUtils.print(file);// 41 42 43 44 45 3f 3f,所有汉字输出3f

		// 文字的编码：文字(unicode char)。编码为byte序列的方案
		// 文字的解码：将编码的byte序列解析为字符序列(unicode char)
		System.out.println("读取utf8.txt并且解码：");
		file = "utf8.txt";
		InputStream in = new FileInputStream(file);
		// in.available()流in中可以连续读取“可用”的byte数量
		// 小文件时候，一般是文件的长度
		byte[] buf = new byte[in.available()];// buf与文件长度一样,读小文件到内存中的一个方案
		in.read(buf);// 将小文件一次性读取到byte数组中
		in.close();// 关流
		String s = new String(buf, "utf-8");
		System.out.println(s);// ABCDE中国
		// 什么叫乱码
		String s2 = new String(buf, "gbk");// 解码写错了
		System.out.println("乱码：" + s2);// 乱码：ABCDE涓??
		// 系统默认文本编码
		// System.getProperty(key)查询系统属性散列表，获得系统默认属性
		String encoding = System.getProperty("file.encoding");
		System.out.println(encoding);// GB2312，返回当前系统文本的默认编码
	}
}
