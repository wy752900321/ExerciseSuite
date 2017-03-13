package basic.day16;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
	public static void main(String[] args) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(
					"/home/soft01/work/test/JSD1202_2/basic/day16/CPDemo.java");
			for (int c = 0; c <= 50000; c++) {
				fw.write(c);
			}
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("ÎÄ¼þÐ´Èë´íÎó");
			System.exit(-1);
		}
	}
}
