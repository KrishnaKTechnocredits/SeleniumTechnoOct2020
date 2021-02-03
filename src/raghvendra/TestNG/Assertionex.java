package raghvendra.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Assertionex {
	
	/*@Test
	public void m1(){
		int act = 4;
		int exp = 8;
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(act,exp);
		
		act=9;
		exp=10;
		
		soft.assertEquals(act,exp);
		soft.assertAll();
		
	}*/
	
	@Test
	void HardAssertm2() {
		int act = 14;
		int exp = 14;
		Assertionex a=null;
		Assert.assertEquals(act,exp);
		Assert.assertNotEquals(5, 6,"Mismatch");
		Assert.assertNull(a);
		Assert.assertNotNull(exp);
		Assert.assertTrue(6>5,"Number 5 is not great than 6");
		Assert.assertFalse(5>6,"Number 5 is not great than 6");

	}
}
