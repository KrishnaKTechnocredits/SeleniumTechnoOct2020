package anjaliS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Hover {
	static WebDriver driver;

	void hover() {

		System.out.println("Amazon webpage opened successfully");
		driver.get("http://amazon.com/");

		System.out.println("Hover on Accounts and list tab");
		WebElement ele = driver.findElement(By.xpath("//span[@class = 'nav-line-2 nav-long-width']"));

		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();

		List<WebElement> list = driver.findElements(By.id("nav-flyout-accountList"));
		System.out.println(list.size());
	}

	public static void main(String[] args) throws InterruptedException {
		//driver = Driver.start();
		Hover hoverHandler = new Hover();
		hoverHandler.hover();

	}
}
