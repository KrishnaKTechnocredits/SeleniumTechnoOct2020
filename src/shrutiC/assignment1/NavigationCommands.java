package shrutiC.assignment1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands{

	public static void main(String[] args) {
		
		String driverPath = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");
		String googlePageTitle=driver.getTitle();
		
		driver.navigate().to("https://www.amazon.in/");
		String amazonPageTitle=driver.getTitle();
		
		driver.navigate().back();
		driver.navigate().refresh();
		String currentPageTitle=driver.getTitle();
		if(currentPageTitle.equals(googlePageTitle))
			System.out.println("Successful navigation back to google page");
		
		driver.navigate().forward();
		driver.navigate().refresh();
		currentPageTitle=driver.getTitle();
		if(currentPageTitle.equals(amazonPageTitle))
			System.out.println("Successful navigation forward to amazon page");
		
		
		driver.quit();
	}

}
