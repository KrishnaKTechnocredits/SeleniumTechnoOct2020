package sadhana;
/* b) navigation cmd:
        1) void navigate().to(String url)
        2) void navigate().forward()
        3) void navigate().back()
        4) void navigate().refresh() */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Navigation_Cmd { 
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.epfindia.gov.in/site_en/");
		
		driver.navigate().forward();
		String expectedTitle="Employees' Provident Fund Organisation";
		String actualResult=driver.getTitle();
		if(expectedTitle.equals(actualResult))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		driver.navigate().back();
		String expectedtitle="EPFO Home";
		String actualresult=driver.getTitle();
		if(expectedtitle.equals(actualresult))
			System.out.println("Pass");
		else
			System.out.println("Fail");
	
		driver.navigate().refresh();
		System.out.println("Refresh ");
		
		driver.close();
	}

}
