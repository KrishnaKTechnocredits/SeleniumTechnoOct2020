package prasad;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class Naukri {
	String pageTitle;

	void findWindows(WebDriver driver) {
		String mainWin = driver.getWindowHandle();
		Set<String> win = driver.getWindowHandles();
		for (String str : win) {
			if (!str.equals(mainWin)) {
				driver.switchTo().window(str);
				pageTitle = driver.getTitle();
				System.out.println("Closing " + pageTitle + " window");
				driver.close();
			}
		}

		driver.switchTo().window(mainWin);
		pageTitle = driver.getTitle();
		System.out.println("Closing " + pageTitle + " window");
		driver.close();
	}

	public static void main(String[] arg) {
		Naukri naukri = new Naukri();
		WebDriver driver = StaticResources.start("https://naukri.com");
		naukri.findWindows(driver);
	}
}
