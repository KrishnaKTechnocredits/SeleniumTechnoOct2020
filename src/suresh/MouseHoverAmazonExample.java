package suresh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAmazonExample {
	static WebDriver driver;
	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		//WebDriver driver = PredefinedActions.start("https://www.amazon.in/");
		
		WebElement ele = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='nav-flyout-accountList']//div[@id='nav-al-container']"));
		System.out.println(list.size());
		
	}
}
