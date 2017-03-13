package container_summarize_tarena;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**注：
 	如果要对使用工具类：Collections.sort(List)来对List进行排序，则必须要让容器
 	中所存放的类型实现java.lang.Comparable接口
 */
public class TestArrayListDemo {
	public static void main(String[] args) {
		List list =new ArrayList();
		list.add("abc");
		list.add("hik");
		list.add(new Integer(4));
		list.add(new Double(3.45));
		//----
		print(list);
	}
	public static void print(List list){
		Iterator it = list.iterator();
		while(it.hasNext()){
			Object o = it.next();
			System.out.println(o);//它将会按照存放的在、顺序输出
		}
	}
}
