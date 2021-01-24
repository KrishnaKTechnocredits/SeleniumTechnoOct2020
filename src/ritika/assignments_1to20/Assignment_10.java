package ritika.assignments_1to20;

/*Assignment - 8 : Missing_Link & Multiwindow_Handle
Program 2 - Verify Multi-Window Handling on naukri.com page*/

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import ritika.base.PredefinedActions;

public class Assignment_10 {
	
	static void multiWindowHandle(WebDriver driver) {
		System.out.println("Step - Verify Multi-Window Handling on naukri.com page");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String mainWin = driver.getWindowHandle();
		Set<String> multiWin = driver.getWindowHandles();
		System.out.println("Total windows opened -> " +multiWin.size());
		Iterator<String> itr= multiWin.iterator();
		while(itr.hasNext()) {
			String currentWin = itr.next();
			driver.switchTo().window(currentWin);
			System.out.println(driver.getTitle());
			if(!mainWin.equals(currentWin)) 
				driver.close();
		}
		driver.switchTo().window(mainWin);
		System.out.println(driver.getTitle());
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://www.naukri.com/");
		multiWindowHandle(driver);
		driver.quit();
	}
}
