package container_sumarize_shiyong;

import java.util.TreeMap;

public class TestTreeMap {

	public static void main(String[] args) {
		TreeMap tm = new TreeMap();
		tm.put(new R(3), "java");
		tm.put(new R(-5), "C++");
		tm.put(new R(9), "VB");
		System.out.println(tm);//已经按照key的大小升序排列
		//返回该TreeMap的第一个Entry对象
		System.out.println(tm.firstEntry());//R属性为：-5=C++
		//返回TreeMap的最后一个key值
		System.out.println(tm.lastKey());//R属性为：9
		//返回该TreeMap比new R(3)大的最小key值
		System.out.println(tm.higherKey(new R(3)));//R属性为：9
		//返回天花板
		System.out.println(tm.ceilingKey(new R(3)));//R属性为：3.注意与上一句的区别
	}
}
class R implements Comparable{
	int count;
	public R(int count){
		this.count=count;
	}
	public String toString(){
		return "R属性为："+count;
	}
	public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if(this!=null && o.getClass()==R.class){
			R r = (R)o;
			if(this.count==r.count){
				return true;
			}
		}
		return false;
	}
	public int compareTo(Object o){
		R r =(R)o;
		if(this.count>r.count){
			return 1;
		}
		else if(this.count<r.count){
			return -1;
		}
		else{
			return 0;
		}
	}
}
