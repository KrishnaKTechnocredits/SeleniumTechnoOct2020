package technoCredits.testngExamples;

import org.testng.annotations.Test;

public class Example1 {
	int x = 10;
	void start() {
		System.out.println("Open Browser");
	}
	
	@Test
	public void firstTest() {
		start();
		x = 20;	
		System.out.println("This is First Test");
	}

	@Test
	public void secondTest() {
		System.out.println("This is Second Test " + x);
	}
}
