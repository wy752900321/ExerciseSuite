package commen_class;
/**
 *得到JVM的内存空间信息，
 *包括最大内存空间，空闲内存空间。
 *gc()方法后，可用空间就变大了
 */
public class RuntimeDemo01 {
	public static void main(String[] args) {
		Runtime run=Runtime.getRuntime();//通过Runtime类的静态方法为其进行实例化操作
		System.out.println("JVM最大内存量："+run.maxMemory());//观察最大内存量，根据机器环境会有所不同
		System.out.println("JVM空闲内存量："+run.freeMemory());//取得程序运行之前的内存空闲量
		
		String str = "Hello"+"World"+"!!!"+
				"\t"+"Welocome"+"To"+"MLDN"+"!~";
		System.out.println(str);
		for(int x=0;x<1000;x++){//循环修改String，产生多个垃圾，会占用内存
			str += x;
		}
		System.out.println("操作String之后的，JVM空闲内存量："+run.freeMemory());//观察有多个垃圾空间产生之后的内存空闲量
		run.gc();//进行垃圾收集，释放空间
		System.out.println("垃圾回收之后的，JVM空闲内存量："+run.freeMemory());//垃圾收集之后的内存空闲量。
	}
}
