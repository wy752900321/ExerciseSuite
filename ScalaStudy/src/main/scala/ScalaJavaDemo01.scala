//静态方法
object ScalaJavaDemo01 extends App {

  println("hello zhaojun i miss you very much");

  def say(name: String) {
    println(name)
  }

  /**
    * 先去调用java方法
    *
    * @return
    */
  def say3(): Int = {
    println("这里是scala的方法了")
    var tmp = JavaScalaDemo01.say2("4");
    println(tmp);
    tmp
  }
}