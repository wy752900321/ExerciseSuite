package annotation;
//@Deprecated在方法上声明，也可以在类中进行声明。
public class  DeprecatedAnnotationDemo1{
	public static void main(String[] args) {
		Demo d = new Demo();//实例化Demo对象
		System.out.println(d.getInfo());//编译时，将出现警告信息
	}
}
class Demo{
	@Deprecated				//声明不建议使用的操作
	public String getInfo(){//此方法不建议用户使用
		return "这是一个Person类";//返回信息
	}
}