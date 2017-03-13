package cn.itcast;

import javax.persistence.Temporal;

import org.junit.Test;

public class Test1 {
	@Test
	public void test(){
		Util util = Util.getInstance();
		System.out.println(util==Util.getInstance());
	}
}
