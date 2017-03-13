package basic.day18.mldn.generics;
/**使用Point类将var的类型设置成整数
 * Point5.java中的setter和getter方法就变成 了：
 * 此程序将Point类中的var属性设置成Integer类型，所以在声明及实例化对象时使用Point<Integer>。这样实际上
 * 	private T var;//此变量的类型由外部决定
 * 
	public Integer getVar(){//返回值的类型由外部指定
		return var;
	}
	public void setVar(Integer var){//设置的类型由外部指定
		this.var=var;
	}
 */
public class GenericsDemo05 {
	public static void main(String[] args) {
		// 泛型对象定义：类名称<具体类> 对象名称 － new 类名称<具体类>();
		Point5<Integer> p = new Point5<Integer>();//里面的var类型为Integer类型
		
		p.setVar(30);//设置数字，自动 装箱
		System.out.println(p.getVar()*2);//计算结果，按数字取出
	}
}
