package basic.day17.IOUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//IO 工具类
public class IOUtils_01 {
	/**
	 * 读取文件并且按照16进制输出，每10byte为一行
	 * 
	 * @param fileName输入文件名
	 * @throws IOException
	 * @throws IOException
	 *             文件读取异常
	 */
	public static void printHex(String fileName) throws IOException {
		// 1。创建文件输入流对象
		FileInputStream in = new FileInputStream(fileName);
		int b;
		// 2.循环读取byte
		while ((b = in.read()) != -1) {// 第次读取一个byte,并检查EOF
			if (b <= 0xf) {// 单位数前面补0，如：8－＞08
				System.out.println("0");
			}
			System.out.println(Integer.toHexString(b) + "");
		}
		in.close();
	}
}
