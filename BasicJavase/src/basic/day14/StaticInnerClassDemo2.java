package basic.day14;

import java.util.Comparator;
import java.util.Arrays;

public class StaticInnerClassDemo2 {
	public static void main(String[] args) {
		String[] names = { "Tom", "Jerry", "Andy" };
		Arrays.sort(names, new ByLength());
		System.out.println(Arrays.toString(names));
	}

	private static class ByLength implements Comparator<String> {
		public int compare(String o1, String o2) {
			return o1.length() - o2.length();
		}
	}
}
