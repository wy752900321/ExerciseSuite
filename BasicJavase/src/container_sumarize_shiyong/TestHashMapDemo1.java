package container_sumarize_shiyong;

import java.util.Hashtable;

/*
 	验证map判断key相等和value相等的标准
 */
public class TestHashMapDemo1 {
	public static void main(String[] args) {
		Hashtable ht = new Hashtable();
		ht.put(new Count(200), "Java");
		ht.put(new Count(300), "C++");
		ht.put(new Count(100), new L());
		ht.put(new Count(200), "Delphi");
		//显示顺序与hashCode值有关，降序显示，但是由于两次加入new Count(200),将
		//导致只能保存一个，因为不允许key重复
		//测试ht中是否包含字符串“VB”
		System.out.print(ht);
	//下面输出true是因为L对象与任何对象比较都返回true,但是new L()和“VB”的hashCode却是不一样的
		System.out.println(ht.containsValue("VB"));//输出true
		//删除一个key-value对
		ht.remove(new Count(300));
		System.out.println(ht);
		//使用key遍历ht
		for(Object key:ht.keySet()){
			System.out.println(ht.get(key));
		}
	}
}
class Count {
	int count;
	public Count(int count){
		this.count = count;
	}
	public boolean equals(Object o){
		if(o==this){
			return true;
		}
		if(o != this&&o.getClass()==Count.class){
			Count c =(Count)o;
			if(this.count==c.count){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		return this.count;
	}
}
class L{
	public boolean equals(Object o){
		return true;
	}
}