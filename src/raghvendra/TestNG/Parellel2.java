package raghvendra.TestNG;

import org.testng.annotations.Test;

public class Parellel2 {
	@Test
	void m1() {
		for(int index=0;index<10;index++) {
			System.out.println("M1 of Parell2"+index);
		}
	}

}
