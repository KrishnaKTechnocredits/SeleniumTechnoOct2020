package mrunal;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignment : 10
1. Open Naukri.com website
2. Close all other windows apart from main window.
3. Switch to main window in the end.
Hint : find main window by title.*/
public class NaukriMainWindow {

	void NaukriMainWindow() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		System.out.println("Open Naukri.com");
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Get Current window Hanle and Title of main page");
		String getMainWindow=driver.getWindowHandle();
		
		String beforeTitle=driver.getTitle();
		
		Set<String> listOfWindow=driver.getWindowHandles();
		
		System.out.println("Close Other windows apart from main window");
		
		for(String window:listOfWindow) {
			if(!(getMainWindow.equals(window))) {
				driver.switchTo().window(window);
				System.out.println("Title of closing window: "+driver.getTitle());
				driver.close();
			}
		}
		System.out.println("Switch to main window");
		driver.switchTo().window(getMainWindow);
		System.out.println("Get title of main window after switch");
		String afterSwitchTitle=driver.getTitle();
		if(beforeTitle.equals(afterSwitchTitle))
			System.out.println("Pass");
		else
			System.out.println("Fail");
	}
	public static void main(String[] args) {
		
		NaukriMainWindow naukriMainWindow=new NaukriMainWindow();
		naukriMainWindow.NaukriMainWindow();
	}
}

