package mrunal;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*Assignment - 8 : Missing_Link & Multiwindow_Handle 
1. Print missing link button text
Note: use missing link form from resources folder*/
public class Missinglink {

	public static void missingLink(WebDriver driver){
		System.out.println("STEP - Provided Implicit Wait to Driver Object");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println("STEP - Find All The Links on a WebPage");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (WebElement element : links) {
			try {
				if (element.getAttribute("href").equals("")) {
					System.out.println("Missing link is - " + element.getText());
				}
			} catch (NullPointerException npe) {
				System.out.println("Missing link is without href tag - " + element.getText());
			}
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("file:///E:/project/SeleniumTechnoOct2020/resources/forms/MissingLink.html");

		missingLink(driver);
		System.out.println("STEP - Close the driver");
		driver.close();
		System.out.println("STEP - Test Completed");

	}
}