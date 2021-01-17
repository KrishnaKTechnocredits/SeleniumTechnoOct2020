package brijesh.assignments.assignment10;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import brijesh.base.Driver;

/*
Close all other open windows apart from main window in naukri.com 
*/

public class NaukriMultiWindows {

	public static void main(String[] args) {
		WebDriver driver = Driver.start("https://www.naukri.com/");
		try {
			System.out.println("Step: Get all windows");
			String baseWindow = driver.getWindowHandle();
			Set<String> windows = driver.getWindowHandles();
			for(String window : windows) {
				driver.switchTo().window(window);
				if(!driver.getTitle().contains("Naukri.com")) {
					System.out.println("Closing window which has title: "+driver.getTitle());
					driver.close();
				}
			}
			System.out.println("Step: Switching back to main window");
			driver.switchTo().window(baseWindow);
			System.out.println("Title of main window '"+driver.getTitle()+"'");
			if(driver.getTitle().contains("Naukri.com") && driver.getWindowHandles().size() == 1)
				System.out.println("Test Passed");
			else
				System.out.println("Test Failed");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Driver.quit(driver);
		}
	}
}
