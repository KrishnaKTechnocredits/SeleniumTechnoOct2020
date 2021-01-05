package rohan.Assignment01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Navigate commands HandsOn
 * 
 */

public class NavigateCommands {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.co.in");
		
		driver.navigate().to("http://automationbykrishna.com/");
		String expTitle = "Login Signup Demo";
		String actTitle = driver.getTitle();
		if(actTitle.equals(expTitle))
			System.out.println("Test case pass");
		else
			System.out.println("Test case failed with incorrect title");
		
		driver.navigate().to("https://mail.google.com/");
		System.out.println("Navigated successfully to gmail");
		
		driver.navigate().back();
		if(actTitle.equals(expTitle))
			System.out.println("Test case pass (post back navigation)");
		else
			System.out.println("Test case failed with incorrect title");
		
		driver.navigate().forward();
		
		String actUrl = driver.getCurrentUrl();
		String expUrl = "https://mail.google.com/";
		
		if(actUrl.contains("mail"))
			System.out.println("Test case pass");
		else
			System.out.println("Test case fail with url incorrect");
		
		driver.quit();
	
	}
}