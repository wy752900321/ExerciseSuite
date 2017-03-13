package basic.day07;

/**对象实例化过程
 * 	1.在创建类之前，检查是否加载（是将硬盘上的.class文件加载到内存中)，
 * 		如果没有加载就加载这个类，在这个类加载之前要加载所有父类。java运行时采用的策略：
 * 		懒惰加载（按需加载）：如果第一次用到就加载，只加载一次。通过CLASSPATH指定的路径
 * 		寻找类文件(.class),加载以后是一个对象，类型是Class
 *  2.在内存堆中分配对象空间。递归分配所有父类和子类属性空间。属性默认自动初始化。自动初始化为“0”值
 *  3.进行属性的赋值
 *  4.递归调用父类构造器。（默认调用父类无参数构造器！）
 *  5.调用本类构造器.
 */
public class ClassInit {
	/**内存分析:
	 	1.检查并加载类.首先检查内存中Koo3有没有加载,如果Koo没有加载会加载Koo3并加载父类Foo3
	 	2.在内存堆中分配对象空间.
	 		先递归的分配父类型空间(Foo):int a=0(int类型空间,默认值为0)
	 		再分配子类型空间(Koo):int b=0
	 	3.进行属性的赋值.在堆时int a=1 ; int b =2
	 	4.递归调用父类构造器.Koo k=new Koo()->public Foo(){a=3;},int a =3;
	 	5.递归调用本类构造器.Koo k=new Koo()->public Koo(){a=4;b=5;},int a=4,int b=5
	 */
	public static void main(String[] args) {
		Koo3 k = new Koo3();
		System.out.println(k.a+""+k.b);
	}
}
class Foo3{
	int a = 1;
	public Foo3(){
		a=3;
		}
}
class Koo3 extends Foo3{
	int b=2;
	public Koo3(){
		a = 4;
		b = 5;
	}
}
