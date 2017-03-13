package basic.day17;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * »º³åÁ÷
 */
public class TestBufferStream2 {
	public static void main(String[] args) {
		try {
			BufferedWriter bw =new BufferedWriter(new FileWriter("xiya.txt"));
			BufferedReader br = new BufferedReader(new FileReader("test/xiya.txt"));
			String s = null;
			for(int i=1;i<=100;i++){
				s=String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while((s=br.readLine())!=null){
				System.out.println(s);
			}
			bw.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
