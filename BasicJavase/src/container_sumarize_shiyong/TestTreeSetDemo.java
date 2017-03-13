package container_sumarize_shiyong;

import java.util.TreeSet;

/*
 	Set接口两种普遍的实现类，HashSet和TreeSet.
 	当从集合中以有序的方式插入和抽取元素时，TreeSet实现类会有用处。
 	为了能够顺顺利进行操作，添加到TreeSet的元素必须是可排序的
 */
public class TestTreeSetDemo {
	public static void main(String[] args) {
		TreeSet ts = new TreeSet();
		ts.add(5);
		ts.add(9);
		ts.add(-1);
		ts.add(3);
		System.out.println(ts);//[-1, 3, 5, 9]，可以看到已经自动按照自然顺序升序排列了
		System.out.println("第一个元素："+ts.first());
		System.out.println("最后一个元素："+ts.last());
		//返回小于4的子集，注意4并非集合元素
		System.out.println(ts.headSet(4));//[-1, 3]
		//返回大于5的子集，如果集合中包含5，则子集里也包含5
		System.out.println(ts.tailSet(5));//[5, 9]
		//返回大于等于3，小于5的子集
		System.out.println(ts.subSet(3, 5));//[3]
	}
}
