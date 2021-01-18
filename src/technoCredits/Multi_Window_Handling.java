package technoCredits;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import technoCredits.base.PredefinedActions;

public class Multi_Window_Handling {

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://www.naukri.com/");
		String mainWin = driver.getWindowHandle();

		Set<String> multiWin = driver.getWindowHandles();
		System.out.println(multiWin.size());
		Iterator<String> itr = multiWin.iterator();

		while (itr.hasNext()) {
			
			itr.remove();
			
			String cWin = itr.next();
			driver.switchTo().window(cWin);
			//driver.manage().window().maximize();
			if (!mainWin.equals(cWin)) {
				// System.out.println(driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainWin);
		System.out.println(driver.getTitle());
	}

}
