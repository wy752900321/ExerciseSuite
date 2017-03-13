package container_sumarize_shiyong;

import java.util.TreeSet;

/**
 	TreeSet的自然排序
 	注意：如果向TreeSet中添加的是用户自定义对象，那么就可以将不同类型的对象加入TreeSet集合，
 	前提是该对象的compareTo(Object o)方法中没有经过强制类型转换。问题是，虽然可以添加进去，但是
 	在试图操作集合数据时，不同类型的元素依然会发生类型转换异常。所以我们的程序中除非极端情况下，否则
 	产允许将两个不同类型的对象放入TreeSet集合中
 */
public class TestTreeSetDemo2 {
	public static void main(String[] args) {
		//陷阱一：元素对象所属类没有实现Comparable接口
		TreeSet ts = new TreeSet();
		ts.add(new A());//A类没有实现Comparable接口，但是第一个元素可以正常添加
		System.out.println(ts);
//		ts.add(new A());//抛出异常ClassCastException当试图将对象强制转换为不是实例的子类时，抛出该异常
		
		//陷阱二：没有添加同类对象：
		TreeSet ts1 = new TreeSet();
		ts1.add("abcde");
		//虽然String和Date类都实现了Comparable接口，但是由于它们并非同类对象，
		//所以无法加入共同的TreeSet集合
//		ts1.add(new Date());
	}
}
