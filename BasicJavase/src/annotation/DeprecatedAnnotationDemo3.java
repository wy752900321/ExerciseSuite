package annotation;
/**
 *	@SuppressWarnings注释的主要功能是用来压制警告。
 *	如：之前讲解泛型时，如果一声明时没有指明泛型，则肯定在编译时产生，那么就可以压制。
 *	@SuppressWarnings中的unchecked，表示的是不检查，如果需要压制更多的警告信息，
 *	则可以在后面继续增加字符串，只是在增加时，要按照数组的格式增加。
 *	关键字：deprecation使用了不成使用的类或方法时的警告
 *		  unchecked执行了未检查的转换时警告，例如，泛型操作中没有指定泛型类型
 *		fallthrough当使用switch操作时case后未加入break操作，而导致的。
 *		path当设置了一个错误的类路径／源文件路径时出现
 *		serial当在可序列化的类上缺少serialVersionUID定义时的警告
 *		all关于以上所有的情况的警告
 */
public class DeprecatedAnnotationDemo3 {
	@SuppressWarnings("unchecked")		//压制主方法的警告信息
	public static void main(String[] args) {
		Demo3 d = new Demo3();	//编译时，将出现警告信息，但此时警告被压制
		d.setVar("贾东坡");
		System.out.println("内容："+d.getVar());//输出
	}
}
class Demo3<T>{		//定义Demo类，使用泛型 
	private T var;	//定义泛型变量
	public T getVar(){//取得泛型变量的内容
		return var;
	}
	public void setVar(T var){
		this.var = var;
	}
}