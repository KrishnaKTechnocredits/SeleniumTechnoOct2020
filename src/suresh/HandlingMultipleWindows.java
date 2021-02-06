package suresh;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import base.PredefinedActions;

public class HandlingMultipleWindows {
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		driver.navigate().to("https://www.naukri.com/");
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		System.out.println(s.size());
		Iterator<String> itr = s.iterator();
		while (itr.hasNext()) {
			String childwinodw = itr.next();
			if (!parent.equals(childwinodw)) {
				driver.switchTo().window(childwinodw);
				System.out.println(driver.getTitle());
				driver.close();

			}
		}
	}
}
