package technoCredits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // 1 tab
		//driver.get("http://google.co.in"); // wait till Page Load  
		driver.navigate().to("http://google.co.in");
		
		//1 navigate().to() 
		driver.navigate().to("http://facebook.com"); // wont wait till page load
		
		//2. 
		driver.navigate().back();
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle))
			System.out.println("Pass");
		else
			System.out.println("fail");
		
	   // 3. forward
		driver.navigate().forward();
		expectedTitle = "Facebook";
		actualTitle = driver.getTitle();
		
		if(actualTitle.startsWith(expectedTitle))
			System.out.println("Pass");
		else 
			System.out.println("Fail");
		
		//4. refresh
		driver.navigate().refresh();
		actualTitle = driver.getTitle();
		
		if(actualTitle.startsWith(expectedTitle))
			System.out.println("Pass");
		else 
			System.out.println("Fail");
		
		driver.close();
	}
}
