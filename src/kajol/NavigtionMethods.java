/*navigation cmd:
        1) void navigate().to(String url)
        2) void navigate().forward()
        3) void navigate().back()
        4) void navigate().refresh()*/

package kajol;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigtionMethods {
	
	public static void main(String[] arg) {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://google.com/");//void navigate().to(String url);
		String name="Kajol";
		driver.findElement(By.name("q")).sendKeys(name);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		if(driver.getTitle().equals(name+" - Google Search"))
			System.out.println("Search Successfully Completed");
		driver.navigate().back();//void navigate().back()
		if(driver.getTitle().contains("Google"))
			System.out.println("Back Navigation Method worked successfully");
		driver.navigate().forward();//void navigate().forward();
		driver.navigate().refresh();//void navigate().refresh();
		if(driver.getTitle().equals(name+" - Google Search"))
			System.out.println("Forward Navigation and Refresh Method worked successfully");
		driver.quit();
	}

}
