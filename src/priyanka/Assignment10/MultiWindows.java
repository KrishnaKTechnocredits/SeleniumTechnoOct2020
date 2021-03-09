package priyanka.Assignment10;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Assignment : 10
//1. Open Naukri.com website
//2. Close all other windows apart from main window.
//3. Switch to main window in the end.
//Hint : find main window by title.

public class MultiWindows {
	
	public void closeOtherWindows(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String mainwindow = driver.getWindowHandle();
		Set<String> multiwindows = driver.getWindowHandles();
		Iterator<String> itr = multiwindows.iterator();
		while (itr.hasNext()) {
			String currentWindow = itr.next();
			if (!mainwindow.equals(currentWindow)) {
				driver.switchTo().window(currentWindow);
				System.out.println("Closing window with title:" + driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		System.out.println("Switched to main window with title:" + driver.getTitle());
		driver.close();
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		new MultiWindows().closeOtherWindows(driver);

	}


}
