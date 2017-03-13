package basic.day16;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * 文件内容随即访问 RandomAccessFile
 */
public class RAFDemo {
	public static void main(String[] args) throws IOException {
		String file = "ra.dat";
		// 八位相当于一个字节，如果是32位可以切割成4份
		// 快捷键："Alt + /"编码助手
		//打开一个文件
		//date:	  41 42 42 ff ff ff fe d6 d0 ??  ??  08									十六进制
		//index:   0  1  2  3  4  5  6  7  8  9  10  11  12 
		//pointer:                                        ^
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		System.out.println(raf.length());// 0,新文件长度：0
		System.out.println(raf.getFilePointer());// 0   指针位置
		raf.write(0x841);// 将低八位“41”写入文件
		System.out.println(raf.length());// 1
		System.out.println(raf.getFilePointer());// 1
		raf.write(66);// 十进制，二进制42，相当于raf.write('B');
		raf.write('B');
		int a = -2;// Oxfffffffe;
		// raf.write((a);//丢数了，高位去除了。
		// raf.write(a >>> 24);// 三个叫无符号移位。移位后是000000ff;，前边应有24个零，为了把高八位移动到低八位上。
		// raf.write(a>>24);//2个移位符叫有符号移位，正数补1，正数补零
		raf.write(a >>> 24);// 000000ff
		raf.write(a >>> 16);// 0000ffff
		raf.write(a >>> 8);// 0000ffff
		raf.write(a);// fffffffe
//		raf.close();
		byte[] buf= "中国".getBytes("GBK");//把字符串，按GBK编码成字符数列
		raf.write(buf);
//		raf.write(8);
//		raf.write(0);
//		raf.write(-1);
		System.out.println(raf.length());
		
		///读取文件
		raf.seek(0);//移动游标到开始位置
		int b = raf.read();//正常返回00-ff，-1代表到了文件末尾（EOF）
		System.out.println(b+":"+Integer.toHexString(b));
		
		b = raf.read();
		System.out.println(b+":"+Integer.toHexString(b));
		//...
		//打开一个文件
//		java文件模型，文件是byte by byte是数据有序集合
//		data :	41	42	42	ff	ff	ff	fe	d6	d0	??	??	08	00	ff ....
//		index: 	0	1	2	3	4	5	6	7	8 	9	10	11	12	13	14....
//		pointer:														^
		//读取文件 的全部内容，按照Hex形式打印出来
		raf.seek(0);
		while((b=raf.read())!=-1){
			if(b<=0xf){//单位HEX数补“0”，为了显示的“好看”
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+"");
		}
		System.out.println();
		raf.seek(3);//返回到int 数据的起始位置
		int b1 = raf.read();// 00 00 00 ff
		int b2 = raf.read();// 00 00 00 ff
		int b3 = raf.read();// 00 00 00 ff
		int b4 = raf.read();// 00 00 00 fe
		//<<低位永运补零。
		//b1<<24 -->ff 00 00 00
		//b2<<16 -->00 ff 00 00
		//b3<<8	-->00 00 ff 00
		//b4	= 00 00 00 fe
		int i = (b1<<24)+(b2<<16)+(b3<<8)+b4;
		System.out.println("i:"+i);//i=-2
		
		//打开一个文件
//		java文件模型，文件是byte by byte是数据有序集合
//		data :	41	42	42	ff	ff	ff	fe	d6	d0	??	??	08	00	ff ....
//		index: 	0	1	2	3	4	5	6	7	8 	9	10	11	12	13	14....
//		pointer:							^
		raf.seek(7);
		byte[] ary = new byte[4];//{00,00,00,00};
//		raf.read(ary);尽可能多的读取raf中的数据填充到数组ary中
		int num = raf.read(ary);//从当前光标位置开始，尽可能多的往数组里填充(ary)
		System.out.println("num:"+num+Arrays.toString(ary));
		num = raf.read(ary);
		System.out.println("num:"+num+Arrays.toString(ary));
		num = raf.read(ary);
		System.out.println("num:"+num+Arrays.toString(ary));
		//?
		raf.seek(7);
		num = raf.read();
		String str = new String(ary,"GBK");
		System.out.println(str);//中国
		raf.close();

	}
}
