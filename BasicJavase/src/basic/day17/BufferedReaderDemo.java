package basic.day17;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/** 文本文件 的读取 */
public class BufferedReaderDemo {
	/**
	 * BufferedReader是最常用的文件文件读取API 这个类型提供了非常方便的方法readLine()
	 * readLine()方法每次可以从文件中读取一行文本到字符串 这个文件是经过解码，到行结束符位置，不包括行结束符号
	 * readLine()返回null的时候表示读取到文件末尾 了 行结束符号：回车(\r)或者换行(\n)
	 * bufferedReader是过滤器，是流的功能扩展，依赖于byte流
	 */
	public static void main(String[] args) throws IOException {
		String file = "test/liyi.txt";
		//第一种写法
		// InputStream is = new FileInputStream(file);
		// InputStreamReader reader = new InputStreamReader(is,"gbk");
		// BufferedReader in = new BufferedReader(reader);
		//第二种写法，公司的写法
		BufferedReader in = new BufferedReader(
		//从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。  String 	readLine() 
				new InputStreamReader(// 是字节流通向字符流的桥梁：它使用指定的 charset
						/**读取字节并将其解码为字符
						 * 每次调用 InputStreamReader 中的一个 read()
						 * 方法都会导致从底层输入流读取一个或多个字节。
						 * 要启用从字节到字符的有效转换，可以提前从底层流读取更多的字节，使其超过满足当前读取操作所需的字节。
						 * 为了达到最高效率，可要考虑在 BufferedReader 内包装
						 * InputStreamReader。例如： BufferedReader in = new
						 * BufferedReader(new InputStreamReader(System.in));
						 */
						new BufferedInputStream(
						/*
						 * public class BufferedInputStream extends FilterInputStream
						 * 
						 * BufferedInputStream 为另一个输入流添加一些功能，即缓冲输入以及支持 mark 和
						 * reset 方法的能力。 在创建 BufferedInputStream
						 * 时，会创建一个内部缓冲区数组。在读取或跳过流中的字节时，可根据需要从包含的输入流再次填充该内部缓冲区，
						 * 一次填充多个字节。mark 操作记录输入流中的某个点，reset
						 * 操作使得在从包含的输入流中获取新字节之前，再次读取自最后一次 mark 操作后读取的所有字节。
						 * BufferedInputStream(InputStream in) 创建一个
						 * BufferedInputStream 并保存其参数，即输入流 in，以便将来使用
						 */
						new FileInputStream(file)), "gbk"));
		/*
		 * FileInputStream 从文件系统中的某个文件中获得输入字节。哪些文件可用取决于主机环境。
		 * 
		 * FileInputStream 用于读取诸如图像数据之类的原始字节流。要读取字符流，请考虑使用 FileReader。
		 */
		String str;
		while ((str = in.readLine()) != null) {
			if (str.trim().equals("")) {
				continue;
			}
			System.out.println(str);
			// if(str.matches(".*o.*")){
			// System.out.println(str);
			// }
		}
		in.close();
	}
}
/**
 * BufferedReader extends Reader: Read text from a character-input stream,
 * buffering characters so as to provide for the efficient reading of
 * characters, arrays, and lines. 通常，Reader 所作的每个读取请求都会导致对底层字符或字节流进行相应的读取请求。
 * 因此，建议用 BufferedReader 包装所有其 read() 操作可能开销很高的 Reader（如 FileReader 和
 * InputStreamReader）。 例如， BufferedReader in = new BufferedReader(new
 * FileReader("foo.in"));
 * 
 * public String readLine() throws IOException Read a line of text. A line is
 * considered to be terminated by any one of a line feed ('\n'), a carriage
 * return ('\r'), or a carriage return followed immediately by a linefeed.
 * 读取一个文本行。通过下列字符之一即可认为某行已终止：换行 ('\n')、回车 ('\r') 或回车后直接跟着换行。
 */
