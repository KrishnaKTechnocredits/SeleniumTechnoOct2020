package technoCredits.testngExamples.parametersExamples;

import org.testng.annotations.Test;

public class Parallel2 {

	@Test
	public void m1() {
		for (int i = 1; i < 50; i++) {
			System.out.println("Parallel2 m1 : " + i);
		}
	}

	@Test
	public void m2() {
		for (int i = 101; i < 200; i++) {
			System.out.println("Parallel2 m2 : " + i);
		}
	}

}
