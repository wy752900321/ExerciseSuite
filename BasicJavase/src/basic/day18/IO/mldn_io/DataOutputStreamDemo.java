package basic.day18.IO.mldn_io;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *	将定单写入到文件order.txt中：
 *以下程序：每条数据之间使用’\n'分隔，每条数据中每个内容之间使用‘\t'分隔。
 *可以从DataOutputStreamDemo2.java中读取order.txt的内容
 */
public class DataOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		DataOutputStream dos = null;	//声明数据输出流对象
		File f =new File("test"+File.separator+"xiya.txt");//指定文件的保存路径
		dos = new DataOutputStream(new FileOutputStream(f));//实例化数据输出流对象
		String names[] = {"衬衣","手套","围巾"};//商品名称
		float prices[] = {98.3f,30.3f,50.5f	};//商品价格
		int nums[] ={3,2,1};//商品数量
		for(int i=0;i<names.length;i++){//循环写入
			dos.writeChars(names[i]);	//写入字符串
			dos.writeChar('\t');//加入分隔符
			dos.writeFloat(prices[i]);//写入小数
			dos.writeChar('\t');//写入分隔符
			dos.writeInt(nums[i]);//写入整数
			dos.writeChar('\n');//换行
		}
		dos.close();//关闭输出流
	}
}
