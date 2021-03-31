package raghvendra.TestNG;

import org.testng.annotations.Test;

public class Parellel {
	
	@Test
	void m1() {
		for(int index=0;index<10;index++) {
			System.out.println("M1 of "+index);
		}
	}
	
	@Test
	void m2() {
		for(int index=0;index<10;index++) {
			System.out.println("M2 of "+index);
		}
	}

}
