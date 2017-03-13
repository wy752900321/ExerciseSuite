package basic.day16;

public class PrintFileDemo {
	public static void main(String[] args) {
		String file ="out.demo";
		IOUtils_1.print(file);
//		IOUtils.print("d:\\erm.doc");
		IOUtils_1.print("/etc/passwd");
	}
}
