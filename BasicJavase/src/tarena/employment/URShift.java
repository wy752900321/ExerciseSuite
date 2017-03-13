package tarena.employment;
/**
 * 移位可与等号（<<=或>>=或>>>=）组合使用。此时，操作符左边的值会移动由右边的值指
 * 定的位数，再将得到的结果赋回左边的变量。但在进行“无符号”右移结合赋值操作时，可能 会遇到一个问题： 如果对 byte 或 short
 * 值进行这样的移位运算，得到的可能不是正确的结果。 它们会先被转换成 int 类型，再进行右移操作。然后被截断，赋值给原来的类型，在这种情 况下可能得到-1
 * 的结果。下面这个例子演示了这种情况：
 */
public class URShift {
	public static void main(String[] args) {
		int i = -1;
		System.out.println(i >>>=10	);//4194303
		int  z1 = 4194303;
		int  z = 4194303;
		System.out.println(Integer.toBinaryString(z));
		
		long l =-1;
		System.out.println(i >>>=10);	//4095
		short s =-1;
		System.out.println(s >>>=10);//-1
		byte b = -1;
		System.out.println(b >>>10 );//4194303
		b = -1;
		System.out.println(b>>>10);//4194303
	}
}
