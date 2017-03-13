package basic.day09;
/**重点。模板*/
public class EqualsDemo {
public static void main(String[] args) {
	Ipad p1 = new Ipad(8);
	Ipad p2 = new Ipad(8);
	//变量相等，使用＝＝比较变量的值
	//对象相等，是需要比较对象的关键属性是否一样！如：ID
	System.out.println(p1==p2);//flase 变量的值，是引用的地址值？
	//建议使用Object类提供的equals方法比较对象是否相等
	System.out.println(p1.equals(p2));
	//Object类提供的equals默认实现，是比较引用变量的值！
	//java建议覆盖equals方法，提供合理的对象比较规则
	
	p2 = null;
	System.out.println(p1.equals(p2));
	p1 = p2;
//	System.out.println(p1.equals(p2));//空指针异常
	
	String s1 = new String("ABC");
	String s2 = new String("ABC");
	String s3 = new String("ABD");
	System.out.println(s1==s2);//false
	System.out.println(s1.equals(s2));//true
	System.out.println(s1.hashCode());//true
	System.out.println(s2.hashCode());//true
	System.out.println(s3.hashCode());//false
}
}
class Ipad{
	int id;//产品序号
	public Ipad(int id){
		this.id=id;
	}
	public boolean equals(Object obj){
		
//		return this.id == obj.id;////java访问属性时，先检查类型,所以不能这么写
		
		/*Ipad pad =(Ipad)obj;
		return this.id == pad.id;//也可以这么写，可能运行异常
*/		
		
//		return this.id == ((Ipad)obj).id;//可以这么写,对象不确定，可能 运行异常
		
		//模板式写法如下：
		if(obj==null){//不等
			return false;
		}
		if(obj==null){//如果地址值相等
			return true;
		}
		if(this ==obj){
			return true;
		}
		if(obj instanceof Ipad){//先检测是不是Ipad类型的,再进行比较
			Ipad other = (Ipad)obj;
			return this.id==other.id;
		}
		return false;
		
	}
	//覆盖equals()同时必须覆盖hashCode()方法
	public int hashCode(){
		return id;
	}
}