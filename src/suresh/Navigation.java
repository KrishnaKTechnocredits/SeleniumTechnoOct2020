package suresh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Desktop\\Suresh\\Learning\\Oct_selenium\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		String url = driver.getCurrentUrl();
		System.out.println("website URL is:\t" + url);

		String title = driver.getTitle();
		System.out.println("Title of the website is :\t" + title);

		String getPageSource = driver.getPageSource();
		// System.out.println("Page source: "+getPageSource);

		driver.navigate().to("https://www.facebook.com/");
		String url1 = driver.getCurrentUrl();
		System.out.println("website URL is:\t" + url1);
		String ftitle = driver.getTitle();
		System.out.println("Title of the website is :\t" + ftitle);
		driver.navigate().back();
		driver.navigate().forward();

		driver.navigate().refresh();
		//Thread.sleep("5000");*/		
		driver.navigate().to("https://www.facebook.com/");
		//String url11 = driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.id("email")).sendKeys("sureshchukka1@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("test123");
		driver.findElement(By.name("login")).click(); 
		
		//driver.close();
		// driver.quit();

	}

}