package tarena.test;

import org.junit.Assert;
import org.junit.Test;

import tarena.util.TaxUtil;

public class TestTaxUtil {
	@Test
	public void test1(){
		//实际结果
		double actual = TaxUtil.tax(1000);
		//期望结果
		double expected = 0;
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test2(){
		//实际结果
		double actual = TaxUtil.tax(3000);
		//期望结果
		double expected = 0;
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test3(){
		//实际结果
		double actual = TaxUtil.tax(6000);
		//期望结果
		double expected = 90;
		Assert.assertEquals(expected, actual);
	}
	
	
}
