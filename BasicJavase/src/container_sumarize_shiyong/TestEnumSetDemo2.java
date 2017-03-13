package container_sumarize_shiyong;
import java.util.Collection;
import java.util.HashSet;
import java.util.EnumSet;

/*
 	枚举。问题。字符串与枚举。
 */
public class TestEnumSetDemo2 {
	public static void main(String[] args) {
	Collection c = new HashSet();
	c.clear();
	c.add(Season.SPRING);
	c.add(Season.SUMMER);
	//赋值c中的元素到新的EnumSet中
	EnumSet es = EnumSet.copyOf(c);//没有问题
	System.out.println(es);//[SPRING, SUMMER]
	
	c.add("abce");
	EnumSet es1 = EnumSet.copyOf(c);//抛出异常，因为c中不全为枚举值。
	}
}
