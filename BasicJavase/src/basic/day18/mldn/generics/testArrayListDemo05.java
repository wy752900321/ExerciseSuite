package basic.day18.mldn.generics;

import java.util.ArrayList;
//删除list中所有的“java“的代码
public class testArrayListDemo05 {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("java");
		list.add("aaa");
		list.add("java");
		list.add("java");
		list.add("bbb");
		
		//A－可以
//		for(int i=list.size()-1;i>=0;i--){
//			if("java".equals(list.get(i))){
//				list.remove(i);
//			}
//			System.out.println(list);
//		}
		
		//B－这个迭代少删除一个"java"
//		for (int i = 0; i < list.size(); i++) {
//			if("java".equals(list.get(i))){
//				list.remove(i);
//			}
//			System.out.println(list);
//		}
		
		//C->错误 
//		list.removeAll(Collection c);这里边只能放集合，不能放元素
//		list.removeAll("java");//编译错误	
		
		//D－＞只能删除一个
//		list.remove("java");
//		System.out.println(list);//只能删除一个
	}
}	
