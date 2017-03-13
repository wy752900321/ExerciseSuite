package basic.day16;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DataInputStreamDemo {
	public static void main(String[] args) throws IOException{
		String file = "data2.dat";
		InputStream in = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(in);
		int n = dis.readInt();
		dis.close();
		System.out.println(n);//-3
	}
	
	public static void print(byte[] ary){
		
	}
	
}
