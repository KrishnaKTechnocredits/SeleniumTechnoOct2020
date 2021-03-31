package technoCredits.frameHandle;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import technoCredits.base.PredefinedActions;

public class Example1 {

	@Test(invocationCount = 5)
	public void m1() throws InterruptedException {
		WebDriver driver = PredefinedActions.start();

		List<String> set = new ArrayList<>();
		
		Set<String> set1 = new TreeSet<>(set);
		
		
	}
}
