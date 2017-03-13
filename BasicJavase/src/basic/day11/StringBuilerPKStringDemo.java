package basic.day11;

public class StringBuilerPKStringDemo {
public static void main(String[] args) {
	System.out.println(testStringBuilder(100000));
	System.out.println(testString(100000));
}
public static long testString(int n){
	long start = System.currentTimeMillis();
	String s = "";
	for(int i=0;i<n;i++){
		s+="A";
	}
	long end = System.currentTimeMillis();
	return end - start;
}
public static long testStringBuilder(int n){
	long start = System.currentTimeMillis();
	StringBuilder buf = new StringBuilder();
	for(int i= 0;i<n;i++){
		buf.append("a");
	}
	String s = buf.toString();
	long end = System.currentTimeMillis();
	return end-start;
}
}
