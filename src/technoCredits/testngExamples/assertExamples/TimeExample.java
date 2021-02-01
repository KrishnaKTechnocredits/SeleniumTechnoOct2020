package technoCredits.testngExamples.assertExamples;

import org.testng.annotations.Test;

public class TimeExample {

	@Test(timeOut=2000)
	public void m1() {
		System.out.println("start");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		System.out.println("end");
	}
}
