/**
 * 在Scala中调用java的方法,很简单,直接导入传递参数就可以进行调用了.
 * 在Java中调用Scala的方法,静态方法直接传递参数,非静态的方法,使用对象调用方法
 * 1.首先是静态方法
 */
public class JavaScalaDemo01 {
    public static void main(String[] args) {
        ScalaJavaDemo01.main(new String[]{});

        ScalaJavaDemo01.say("zhaojun ");

        //测试反复的方法调用
        int say3 = ScalaJavaDemo01.say3();
        System.out.println(say3);

    }


    public static int say2(String age) {
        System.out.println("这里是java的static 方法了" + age);
        return Integer.parseInt(age);
    }
}