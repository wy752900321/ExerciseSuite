package basic.day16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** IO 工具类, 包含很多IO有关工具方法(静态方法) */
public class IOUtils {

	public static void cp(String src, String dst) {
		try {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);
			byte[] buf = new byte[2 * 1024];// 2k byte
			int n;
			while ((n = in.read(buf)) != -1) {
				out.write(buf, 0, n);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void cp1(String src, String dst) {
		try {
			InputStream in = new FileInputStream(src);
			OutputStream out = new FileOutputStream(dst);
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void print(File file) {
		try {
			InputStream in = new FileInputStream(file);
			int i = 1;
			int b;
			while ((b = in.read()) != -1) {
				if (b <= 0xf) {// 单位数补0
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(b) + " ");
				if (i++ % 16 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			in.close();// 注意
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public static void print(byte[] buf) {
		// buf = {01000001,00001111,11010110,11010000}
		int i = 1;
		for (int b : buf) {
			// b = 00000000 00000000 00000000 01000001
			// 0xff 00000000 00000000 00000000 11111111 mask
			// & ---------------------------------------
			// 00000000 00000000 00000000 01000001
			b &= 0xff;
			// b = b & 0xff;//掩码运算 其中 0xff 叫掩码(mask)

			if (b <= 0xf) {// 单位数补0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " ");
			if (i++ % 16 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	/** 将文件按照16进制输出到控制台上, 每16个byte为一行 */
	public static void print(String file) {
		try {
			InputStream in = new FileInputStream(file);
			int i = 1;
			int b;
			while ((b = in.read()) != -1) {
				if (b <= 0xf) {// 单位数补0
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(b) + " ");
				if (i++ % 16 == 0) {
					System.out.println();
				}
			}
			System.out.println();
			in.close();// 注意
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
