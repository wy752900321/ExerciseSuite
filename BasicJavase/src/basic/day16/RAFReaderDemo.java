package basic.day16;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**文件读取操作
 *任务：
 *	A 只读打开文件，移动到int数据位置
 *	B 连续读取4个byte，拼接为int (反序列化）
 *文件模型：
 *		data:	41	42	7f	ff	ff	ff	d6	d0	...
 *		index:	0	1	2	3	4	5	6	7	8
 *		pointer:		^
 */
public class RAFReaderDemo {
	public static void main(String[] args) throws IOException {
		//A-1只读打开文件
		RandomAccessFile raf = new RandomAccessFile("demo/raf.dat","r");
		int i=0;
		//A-2移动到int位置
		raf.seek(2);
		//B-1.1读取第1个byte
		int b =raf.read();//7f
		System.out.println(raf.getFilePointer());//3
		//B-1.2 开始拼接为int
		i = i|(b<<24);	//7f 00 00 00 00
		
	}
}
