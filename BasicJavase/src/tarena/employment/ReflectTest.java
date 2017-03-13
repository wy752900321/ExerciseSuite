package tarena.employment;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Properties;

/**
  如果比较两个对象equals相等的话，就让他们的hascode相等。（储存在同一个地方）
当一个对象被储存进hashSet集合中以后，就不能修改这个对象中的那些参与计算哈希码的字段了，否则，对象修改后的哈希值与
最初存储进hashSet集合是的哈希值就不同了，在这种情况下，即使在contains方法使用该对象的当前引用作为的参数去HashSet中检索对象，
也将返回找不到对象的结果，这也会导致无法从HashSet集合中单独删除当前对象，从而造成内存泄露。
 */
public class ReflectTest {
	//如果是arraylist，因为arrarylist保存的是引用，是有顺序的集合（数组顺序），一个变量可能有几个引用地址在集合中
	//arraylist先后次序，以次放入，不是说比较顺序，如大小，高低什么的，而是指位置顺序，有顺序的放。
	public static void main(String[] args) throws Exception{
		
		/**
		 	pt1与pt3的equals是相等的，==是不等的，hashCode也是不等的，只有重写了hashCode()方法
			(如果不重写，结果就不一定了，hascode是根据类计算的，
			同样地东西，放在不一个类中的话，哪可能相同，可能不同)，size()才是2个，
			不重写输出size()为3.
		*/
//		Collection collections = new ArrayList();
		Collection collections = new HashSet();
		ReflectPoint pt1 = new ReflectPoint(3,3);
		ReflectPoint pt2 = new ReflectPoint(5,5);
		ReflectPoint pt3 = new ReflectPoint(3,3);	

		collections.add(pt1);
		collections.add(pt2);
		collections.add(pt3);
		collections.add(pt1);	
		
//		pt1.y = 7;		
		collections.remove(pt1);
		
		System.out.println(collections.size());
	}

}
/**输出分析：
 	1.ReflectPoint没有重写hashCode():
 		a.在：
 		Collection collections = new HashSet();
 		//pt1.y = 7;		
		//collections.remove(pt1);
		情况时输出collections.size()为：3
		b.在
		Collection collections = new HashSet();
		pt1.y = 7;		
		collections.remove(pt1);
		情况时输出collections.size()为：2
	1.ReflectPoint重写hashCode():
		a.在:
		Collection collections = new HashSet();
 		//pt1.y = 7;		
		//collections.remove(pt1);
		情况时输出collections.size()为：2
		b.在:
		Collection collections = new HashSet();
 		pt1.y = 7;		
		collections.remove(pt1);
	 	情况时输出collections.size()为：2
	 	c.在:
		Collection collections = new HashSet();
 		//pt1.y = 7;		
		collections.remove(pt1);
	 	情况时输出collections.size()为：1
	 综合以上：在b中如果改变pty1.y=7的话，remove(pt1)之后的size值为2
	 		而不改变pty1.y=7的话，remove(pt1)之后的size的值为1.这就
	 		说明改变pt1.y值后，根本就没有真正删除掉pt1，他改变了hashCode
	 		值，存储在不同的地方了。
 */

/**hashSet
	1.先比较有没有这个对象，如果没有就放，如果有就不放（不是替换）。
	2.如果hashCode里有，但你又想放，那就要先删除hashCode里的，再放新的。
*/

/**
	默认hashCode比较的是哈希值。hashCode值通常根据默认由内存地址换算出来的。
	看的是内存地址是否相等，如果同一个类的对象想让他们相等的话，就需要重写hashCode()了。
*/

/**
  
	import java.util.Date;

public class ReflectPoint {
	private int x;
	public int y;
	public ReflectPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ReflectPoint other = (ReflectPoint) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
		public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}	
}

 */
