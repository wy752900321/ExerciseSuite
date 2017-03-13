package basic.day16;
/**InputStream基本方法
 *	1. 读取一个字节并以整数的形式返回（0－255）。如果返回－1已到输入流的末尾
 *		int read() throws IOException
 *	2. 读取一系列字节并存储到一个数组buffer，返回实际读取的字节数，末尾－1
 *		int read(byte[] buffer) throws IOExcetion
 *	3. 读取length个字节，并存储到一个字节数组buffer，从length位置
 *		返回实际读取的字节数，如果读取前以到输入流的末尾返回－1
 *		int read(byte[] buffer,int offset,int length)throw IOException
 *	4. 关闭流释放内存资源
 *		void close() throws IOExcetion
 *	5.跳过n个字节不读，返回实际跳过的字节数
 *		long skip(long n)throws IOException
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestFileInputStream {
	public static void main(String[] args) {
		int b = 0;
		FileInputStream in = null;
		try {
			in = new FileInputStream("/etc");
		} catch (FileNotFoundException e) {
			System.out.println("找不到指定文件！");
			System.exit(-1);
		}
		try {
			long num = 0;
			while ((b = in.read()) != -1) {
				System.out.println((char) b);
				num++;
			}
			in.close();
			System.out.println();
			System.out.println("共读取了" + num + "个字节");
		} catch (IOException e1) {
			System.out.println("文件读取错误");
			System.exit(-1);
		}

	}
}
