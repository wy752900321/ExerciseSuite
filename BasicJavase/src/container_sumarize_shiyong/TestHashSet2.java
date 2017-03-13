package container_sumarize_shiyong;

import java.util.HashSet;
import java.util.Iterator;

/**	疑问！！
 	问题：我们无法精确的访问到count为5的元素。这是因为刚开始放
 		入HashSet的时候是以hashCode的值为放入位置的，而当count
 		值修改了之后位置仍然是原来的count
 */
public class TestHashSet2 {

	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(new D(3));
		hs.add(new D(5));
		hs.add(new D(9));
		hs.add(new D(-1));
		System.out.println(hs);//无重复
		
		Iterator it = hs.iterator();//[D:3, D:5, D:9, D:-1]
		D first = (D)it.next();
		//为第一个元素的count属性赋值
		first.count = 5;
		System.out.println(hs);//有重复,[D:5, D:5, D:9, D:-1]
		
		hs.remove(new D(5));//删除一个count为5的D对象元素
		System.out.println(hs);//确实删除了一个,[D:5, D:9, D:-1]
		//下一句返回false
		System.out.println("hs是否包含一个count为3的元素："+hs.contains(new D(3)));//false
		//下一句也返回false,这就出现问题，无法访问到第一个元素了
		System.out.println("hs是否包含一个count为5的元素："+hs.contains(new D(5)));//false
	}

}
class D{
	int count;
	public D(int count){
		this.count = count;
	}
	public String toString(){
		return "D:"+count;
	}
	public boolean equals(Object o){
		if(o instanceof D){
			D d = (D)o;
			if(d.count == this.count){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		return this.count;
	}
}