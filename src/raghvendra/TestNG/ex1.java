package raghvendra.TestNG;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class ex1 {
	
	@BeforeClass
	void ex14() {
		System.out.println("ex1 before");
	}
	
	@Test
	public void m9() {
		System.out.println("m9 ex1");
	}
}
