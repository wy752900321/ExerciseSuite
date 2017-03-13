package test;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//数组与集合相互转换
public class ArrayCollectionDemo {
	public static void main(String[] args) {
		//数组到集合
		String[] names = {"Tom","Jerry","Tom"};
		List<String> list = Arrays.asList(names);
		System.out.println(list.get(1));
		//转list
		list = new ArrayList<String>(list);
		System.out.println(list);
		//转set
		Set<String> set = new HashSet<String>(list);
		System.out.println(set);
		//集合转换为数组
		Object[] ary = set.toArray();
		System.out.println(Arrays.toString(ary));
		String[] ary1 = new String[4];
		
		ary1 = set.toArray(ary1);
		String[] ary2 = new String[1];
		ary2 = set.toArray(ary2);
		System.out.println(Arrays.toString(ary1));
		System.out.println(Arrays.toString(ary2));
	}
}
