package basic.day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils_1 {
	// 读取,1K X 1024

	public static void cp(String src, String dst) {
		try {
			// in代表读取文件，out代表写出文件
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);
			int b;
			while ((b = in.read()) != -1) {// 读取源文件(in)到b
				out.write(b);// 将b写入到目标文件(out)
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	// 读取加速，每1K,提高性能
	public static void cp2(String src, String dst) {
		try {
			// in代表读取文件，out代表写出文件
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);
			byte[] buf = new byte[1024];// 1K Byte
			int num;
			while ((num = in.read(buf)) != -1) {
				out.write(buf, 0, num);
				System.out.println("num:" + num);// 用于测试
			}
			;
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public static void print(String file) {
		try {
			InputStream in = new FileInputStream(file);
			int b;
			int i = 1;
			while ((b = in.read()) != -1) {
				if (b <= 0xf) {
					System.out.println("0");
				}
				System.out.println(Integer.toHexString(b) + " ");
				if (i++ % 16 == 0) {
					System.out.println();
				}
				System.out.println();
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	// 将ary内容按照16进制形式打印，每16个byte为一行 @param ary数据
	public static void print(byte[] ary) {

	}

}