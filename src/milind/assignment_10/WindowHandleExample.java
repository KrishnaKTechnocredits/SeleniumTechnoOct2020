package milind.assignment_10;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandleExample {
	
	WebDriver driver;
	
	void closeOtherWindowThanMainWindow() {
		
		String mainWindowID = null;
		driver = PredefinedActions.start();
		System.out.println("STEP : Get opened window count");
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		System.out.println("STEP : Check next window ID is present");
		while(itr.hasNext()) {
			String windowID = itr.next();
			driver.switchTo().window(windowID);
			if(driver.getTitle().contains("Jobs - Recruitment")) {
				System.out.println("STEP : Get main Windows ID");
				mainWindowID = windowID; 
			}else {
				driver.close();
			}
		}
		System.out.println("STEP : Switch to main window");
		driver.switchTo().window(mainWindowID);
		System.out.println("STEP : Get title of main window");
		System.out.println(driver.getTitle());
	}
	
	public static void main(String[] args) {
		WindowHandleExample windowHandleExample = new WindowHandleExample();
		windowHandleExample.closeOtherWindowThanMainWindow();
		System.out.println("STEP : Close browser");
		windowHandleExample.driver.close();
	}

}
