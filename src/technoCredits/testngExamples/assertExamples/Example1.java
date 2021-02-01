package technoCredits.testngExamples.assertExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Example1 {

	@Test(enabled = true)
	public void assertEquals() {
		Assert.assertEquals(4, 8, "Mis-match value");
		Assert.assertEquals(4, 8);
	}

	@Test(enabled = true)
	public void assertNotEquals() {
		Assert.assertNotEquals(4, 4);
		Assert.assertNotEquals(4, 4, "Both have same values");
		System.out.println("----------------End------------------");
	}

	@Test(enabled = true)
	public void assertNull() {
		Example1 e = new Example1();
		e = null;
		Assert.assertNull(e);
		Assert.assertNotNull(e, "");
		System.out.println("End");
	}

	@Test(enabled = false)
	public void assertTrue() {
		Assert.assertTrue(4 > 8, "");
		Assert.assertTrue(4 > 8);
		System.out.println("End");
	}

	@Test
	public void assertFalse() {
		Assert.assertFalse(4 > 8, "");
		Assert.assertFalse(4 > 8);
		System.out.println("End");
	}

}
