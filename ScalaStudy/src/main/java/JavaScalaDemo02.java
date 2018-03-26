/**
 * 在Scala中调用java的方法,很简单,直接导入传递参数就可以进行调用了.
 * 在Java中调用Scala的方法,静态方法直接传递参数,非静态的方法,使用对象调用方法
 * 1.首先是非静态方法
 */
public class JavaScalaDemo02 {
    public static void main(String[] args) {
        int zhaojun = new ScalaJavaDemo02().hi("zhaojun");
        System.out.println(zhaojun);
    }
}