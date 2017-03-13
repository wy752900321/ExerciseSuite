package basic.day17.IOUtils;

import java.io.IOException;
import java.util.Arrays;

public class TestIOUtils {
	//≤‚ ‘¿‡
	public static void main(String[] args) throws IOException {
		byte[] b = IOUtils.read("test/T.java");
		System.out.println(Arrays.toString(b));
	}
}
