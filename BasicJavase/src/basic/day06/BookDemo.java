package basic.day06;

public class BookDemo {

	public static void main(String[] args) {
		Book book1 = new Book();
		Book book2 = book1;
		book1.name = "致加西亚的信";
		System.out.println(book1.name);
		book1 = new Book();
		//book1的值是一个地址值（是Book对象的首地址）
		//book1通过地址值引用了Book实例（对象）
		//不确切的说法：book1的值是Book对象（通俗如此）
		//引用值（地址）的管理是透明的（不可见的），没有办法输出的
		//可以间接的感受到到！如＝＝比较的就是变量的值
		System.out.println(book1==book2);//比较的就是变量的值（地址值）
		book1.name="那些年，我们一起追过的女孩";
		System.out.println(book1.name);
		book1 = null;
		System.out.println(book1==null);//true
		System.out.println(book1.name);

	}

}
