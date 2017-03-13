package tarena.interview;
/**
 * 总之，在需要精确答案的地方，要避免使用float和double;对于货币计算要使用int
 * long或BigDecimal。
 */
import java.math.BigDecimal;

public class Chage {

	public static void main(String[] args) {
//		System.out.println(2.00-1.10);//0.8999999999999999
		/*
		 * 使用BigDecimal并不是十分完美，因为java并没有为它提供任何语言上的支持。
		 * 要比原始类型的计算要慢一些。BigDecimal(String)构造器
		 */

		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));

	}

}
