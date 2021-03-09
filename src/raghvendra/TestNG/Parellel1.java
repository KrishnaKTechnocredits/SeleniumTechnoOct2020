package raghvendra.TestNG;

import org.testng.annotations.Test;

public class Parellel1 {
	
	@Test
	void m1() {
		for(int index=0;index<10;index++) {
			System.out.println("M1 of Parell1"+index);
		}
	}


}
