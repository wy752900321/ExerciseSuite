package basic.day02;

public class trouble02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i3 = 0177;//Octal(leading zero)
		System.out.println("i3:"+Integer.toBinaryString(i3));//i3:1111111
		byte b = 0x7f;//max byte hex value
		System.out.println("b:"+Integer.toBinaryString(b));//b:1111111
		short s = 0x7fff;//max short hex value
		System.out.println("s:"+Integer.toBinaryString(s));//s:111111111111111

	}

}
