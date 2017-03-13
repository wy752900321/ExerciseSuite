package container_summarize_tarena;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**注
 *	"abc"对象之所以不能存放两个，是因为String类已经重写了hashCode()
 *	方法和equals()方法
 */
public class TestHashSet {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("abc");
		set.add("bdef");
		set.add("abc");//注意这个对象会覆盖之前的"abc"
		//.....
		print(set);
	}
	public static void print(Set set){
		Iterator it=set.iterator();
		while(it.hasNext()){
			Object o=it.next();
			System.out.println(o);
		}
	}
}
