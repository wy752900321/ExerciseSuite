package basic.day17;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//缓冲流要”套接“在相应的节点流之上，对读写的数据提供了缓冲的功能，提高了读写的效率，同时增加了一些新的方法
//缓冲输入流支持其父类的mark和reset方法

//BufferedReader(Reader in)
//BufferedReader(Reader in,int sz)//sz为自定义缓存区的大小 
//BufferedWriter(Writer out)
//BuffereWriter(Writer out,int sz)
//BufferedInputStream(InputStream in)
//BufferedInputStrame(InputStream in,int size)
//BufferedOutputStream(OutputStream out)
//BufferedOutputStream(OutputStream out,int size)

//BufferedReader提供了readLine方法用于读取一行字符串（以\r或\n分隔）
//BufferedWriter提供了newLine用于写入一个行分隔符
//对于输出的缓冲流，写出的数据会先放在内存中缓存，使用flush方法将会使内存中的数据立刻写出
public class TestBufferStream1 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("test/xiya.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int c = 0;
			System.out.println(bis.read());
			System.out.println(bis.read());
			bis.mark(100);//在此输入流中标记当前的位置。
			for(int i=0;i<=10&&(c=bis.read())!=-1;i++){
				System.out.println(c+" ");
			}
			System.out.println();
			bis.reset();//将此流重新定位到最后一次对此输入流调用 mark 方法时的位置
			for(int i=0;i<=10&&(c=bis.read())!=-1;i++){
				System.out.println(c+"");
			}
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
