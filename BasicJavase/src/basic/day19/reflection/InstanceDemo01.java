package basic.day19.reflection;
/**通过无参构造实例化对象
 * 必须存在一个无参构造！！！
 *如果要通过Class本身实例化其他类的对象，则可以使用newInstance()方法，但必须要保证
 *被实例化的类中存在一个无参构造方法。
 *
 *通过Class.forName()方法实例化Class对象之后，直接调用newInstance()方法就可以
 *根据传入的完整“包.类"名称的方式进行对象的实例化操作，完全取代了之前使用关键字new的操作方式
 */
class Person{//定义Person类
	private String name;
	private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "姓名："+this.name+"，年龄："+this.age;
	}
}
public class InstanceDemo01 {
	public static void main(String[] args) {
		Class<?> c = null;//指定泛型
		try{
			c=Class.forName("basic.day19.reflection.Person");//传入要实例化类的完整包.类名称
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Person per =null;//声明Person对象
		try{
			per = (Person)c.newInstance();//实例化Person对象
		}catch(Exception e){
			e.printStackTrace();
		}
		per.setName("贾东坡");//设置姓名
		per.setAge(20);
		System.out.println(per);//内容输出，调用toString()
	}
}
