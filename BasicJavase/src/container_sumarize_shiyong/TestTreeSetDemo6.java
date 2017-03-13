package container_sumarize_shiyong;

import java.util.TreeSet;
import java.util.Comparator;

//4,5中的方法，也可以构建TreeSet时临时传入一个匿名内部比较器来做：
public class TestTreeSetDemo6 {
public static void main(String[] args) {
	//使用匿名内部类的方式来传入一个参数比较器
	TreeSet ts = new TreeSet(new Comparator()
	{
		public int compare(Object o1,Object o2){
			Teacher t1 = (Teacher)o1;
			Teacher t2 = (Teacher)o2;
			if(t1.getHeight()>t2.getHeight()){
				return 1;
			}
			else if(t1.getHeight()<t2.getHeight()){
				return -1;
			}
			else{
				return 0;
			}
		}
	});
	Teacher s1 = new Teacher("孙悟空",500,175);
	Teacher s2 = new Teacher("猪八戒",200,180);
	Teacher s3 = new Teacher("沙和尚",150,185);
	Teacher s4 = new Teacher("唐僧",40,176);
	ts.add(s1);
	ts.add(s2);
	ts.add(s3);
	ts.add(s4);
	System.out.println(ts);//自动按身高来排序
}
}
