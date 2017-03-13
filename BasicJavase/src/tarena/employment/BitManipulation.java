package tarena.employment;

//下面这个例子向大家阐示了如何应用涉及“按位”操作的所有操作符：
//Using the bitwise operators.
import java.util.Random;

public class BitManipulation {
	// static Test monitor = new Test();
	public static void main(String[] args) {
		
		/**
		 * 字符串参与优化，变量不参与优化
		 */
		String s1 = "ab";
		String s2 = "cd";
		String s3 = s1+"cd";
		String s4 = "abcd";
		String tt1 = "ab"+"cd";
		String tt = s1+s2;
		System.out.println(tt==s4);//false
		System.out.println(tt1==s4);//true
		System.out.println(s3==s4);//false
		s3 = "ab"+"cd";
		System.out.println(s3 ==s4);//true
		
		//new出来的东西在堆里开辟一个空间，同时字符串是静态的，所以要在池里开辟一个空间。
		String s5 = new String("java");
		String s6 = "java";
		System.out.println(s5==s6);//false
		
		String s7 = new String("java");
		String s8 = new String("java");
		System.out.println(s7==s8);//false
		
		Random rand = new Random();
		int i = rand.nextInt();
		int j = rand.nextInt();
		printBinaryInt("-1", -1);
		printBinaryInt("+1", +1);
		int maxpos = 2147483647;
		printBinaryInt("maxpos", maxpos);
		int maxneg = -2147483648;
		printBinaryInt("maxneg", maxneg);
		printBinaryInt("i", i);
		printBinaryInt("~i", ~i);
		printBinaryInt("-i", -i);
		printBinaryInt("j", j);
		printBinaryInt("i & j", i & j);
		printBinaryInt("i | j", i | j);
		printBinaryInt("i ^ j", i ^ j);
		printBinaryInt("i << 5", i << 5);
		printBinaryInt("i >> 5", i >> 5);
		printBinaryInt("(~i) >> 5", (~i) >> 5);
		printBinaryInt("i >>> 5", i >>> 5);
		printBinaryInt("(~i) >>> 5", (~i) >>> 5);
		long l = rand.nextLong();
		long m = rand.nextLong();
		printBinaryLong("-1L", -1L);
		printBinaryLong("+1L", +1L);
		long ll = 9223372036854775807L;
		printBinaryLong("maxpos", ll);
		long lln = -9223372036854775808L;
		printBinaryLong("maxneg", lln);
		printBinaryLong("l", l);
		printBinaryLong("~l", ~l);
		printBinaryLong("-l", -l);
		printBinaryLong("m", m);
		printBinaryLong("l & m", l & m);
		printBinaryLong("l | m", l | m);
		printBinaryLong("l ^ m", l ^ m);
		printBinaryLong("l << 5", l << 5);
		printBinaryLong("l >> 5", l >> 5);
		printBinaryLong("(~l) >> 5", (~l) >> 5);
		printBinaryLong("l >>> 5", l >>> 5);
		printBinaryLong("(~l) >>> 5", (~l) >>> 5);
		// monitor.expect("BitManipulation.out");
		System.out.println("BitManipulation.out");
	}

	static void printBinaryInt(String s, int i) {
		System.out.println(s + ", int: " + i + ", binary: ");
		System.out.print(" ");
		for (int j = 31; j >= 0; j--)
			if (((1 << j) & i) != 0)
				System.out.print("1");
			else
				System.out.print("0");
		System.out.println();
	}

	static void printBinaryLong(String s, long l) {
		System.out.println(s + ", long: " + l + ", binary: ");
		System.out.print(" ");
		for (int i = 63; i >= 0; i--)
			if (((1L << i) & l) != 0)
				System.out.print("1");
			else
				System.out.print("0");
		System.out.println();
	}
}

/**
 * 
 * 程序末尾调用了两个方法：它们分别接受printBinaryInt()和 printBinaryLong()。 一个 int 或 long
 * 值的参数，并用二进制格式输出，同时附有简要的说明文字。你可以暂时忽略它们具体是如何实现的。
 * 
 * 请注意这里是用 System.out.print()，而不是 System.out.println()。print()方法不自动换行，所
 * 以我们能在同一行里输出多个信息。 上面的例子中，expect() 以一个文件名作参数，它会从这个文件中读取预期的行（其中 可以有，也可以没有正则表达式）
 * 。对于那些太长，不适宜列在书里的输出，这种做法很有
 * 用。这个文件的扩展名是“.out”，是所发布的代码的一部分，可以从www.BruceEckel.com下
 * 载。如果有兴趣的话，可以打开这个文件，看看正确的输出应该是什么（或者你自己直接运 行一下前面这个程序） 。 上面的例子展示了对 int 和 long
 * 的所有按位运算的效果，还展示了 int 和 long 的最小值、最 大值、+1 和-1
 * 值，以及它们的二进制形式，以使大家了解它们在机器中的具体形式。注意， 最高位表示符号：0 为正，1 为负。下面列出例子中关于 int 部分的输出： -1,
 * int: -1, binary: 11111111111111111111111111111111 +1, int: 1, binary:
 * 00000000000000000000000000000001 maxpos, int: 2147483647, binary:
 * 01111111111111111111111111111111 maxneg, int: -2147483648, binary:
 * 10000000000000000000000000000000 i, int: 59081716, binary:
 * 00000011100001011000001111110100 ~i, int: -59081717, binary:
 * 11111100011110100111110000001011 -i, int: -59081716, binary:
 * 11111100011110100111110000001100 j, int: 198850956, binary:
 * 00001011110110100011100110001100 i & j, int: 58720644, binary:
 * 00000011100000000000000110000100 i | j, int: 199212028, binary:
 * 00001011110111111011101111111100 i ^ j, int: 140491384, binary:
 * 00001000010111111011101001111000 i << 5, int: 1890614912, binary:
 * 01110000101100000111111010000000 i >> 5, int: 1846303, binary:
 * 00000000000111000010110000011111 (~i) >> 5, int: -1846304, binary:
 * 11111111111000111101001111100000 i >>> 5, int: 1846303, binary:
 * 00000000000111000010110000011111 (~i) >>> 5, int: 132371424, binary:
 * 00000111111000111101001111100000 数字的二进制表示形式被称为“有符号的 2 的补码”。
 * 
 * 
 */

/*
 * 
 * 移位操作符（shift operator） 移位操作符操作的运算对象也是二进制的“位”，但是它们只可以被用来处理整数类型（基本 类型的一种）
 * 。左移位操作符（<<）能将操作符左边的运算对象向左移动操作符右侧指定的 位数（在低位补
 * 0）。“有符号”右移位操作符（>>）则将操作符左边的运算对象向右移动操
 * 作符右侧指定的位数。“有符号”右移位操作符使用了“符号扩展”：若符号为正，则在高位插 入 0；若符号为负，则在高位插入 1。Java
 * 中增加了一种“无符号”右移位操作符（>>>） ，它 使用了“零扩展”：无论正负，都在高位插入 0。这一操作符是 C 或 C++没有的。
 * 
 * 如果对 char、byte 或者 short 类型的数值进行移位处理，那么在移位进行之前，它们会自动 转换为 int，并且得到的结果也是一个 int
 * 类型的值。而右侧操作数，作为真正移位的位数， 只有其二进制表示中的低 5 位才有用。这样可防止我们移位超过 int 型值所具有的位数。 （译 注：因为 2
 * 的 5 次方为 32，而 int 型值只有 32 位）。若对一个 long 类型的数值进行处理， 最后得到的结果也是 long。此时只会用到右侧操作数的低
 * 6 位，以防止移位超过 long 型数 值具有的位数。
 * 
 * 移位可与等号（<<=或>>=或>>>=）组合使用。此时，操作符左边的值会移动由右边的值指
 * 定的位数，再将得到的结果赋回左边的变量。但在进行“无符号”右移结合赋值操作时，可能 会遇到一个问题： 如果对 byte 或 short
 * 值进行这样的移位运算，得到的可能不是正确的结果。 它们会先被转换成 int 类型，再进行右移操作。然后被截断，赋值给原来的类型，在这种情 况下可能得到-1
 * 的结果。下面这个例子演示了这种情况：
 * 
 */

