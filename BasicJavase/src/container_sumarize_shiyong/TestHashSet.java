package container_sumarize_shiyong;

import java.util.HashSet;

/**
 	注意：如果将同一个对象两次放入一个HashSet中，无论该对象所属类中如何定义equals方法和
 		hashCode方法，在HashSet中都将只有一个对象，而不会出现两个
 */
public class TestHashSet {

	/**
	 	HashSet，运行代码，可以发现，两个A对象已经加进HashSet,两个B对象也可以加进HashSet
	 	而C对象则一个都没有，这是因为C对象的hashCode值和A对象相等，并且C对象和任何对象比较都返回true,
	 	所以根本加不进去。如果将C类中的hashCode返回值改为2，则会发现可以加入一个C对象
	 */
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(new A());
		hs.add(new A());
		hs.add(new B());
		hs.add(new B());
		hs.add(new C());
		hs.add(new C());
		System.out.println(hs);
	}

}
class A{			//只重写hashCode方法
	public int hashCode(){
		return 1;
	}
}
class B{			//只重写equals方法
	public boolean equals(Object o){
		return true;
	}
}
class C{			//重写equals方法和hashCode方法
	public boolean equals(Object o){
		return true;
	}
	public int hashCode(){
		return 1;
	}
}
