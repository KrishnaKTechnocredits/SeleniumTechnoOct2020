/*
 * Program 2-Mouse hover on Amazon(Verify how many links available under Account & Lists)
 */

package yogita.Assignment_13;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoverAction {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://amazon.com/");
		System.out.println("Website open successfully.");
		driver.manage().window().maximize();
	}

	static void performHover() {
		System.out.println("STEP-Finding Accounts and list Elements");
		WebElement element = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		List<WebElement> listOfElement = driver.findElements(By.id("nav-flyout-accountList"));
		System.out.println(listOfElement.size());

	}

	public static void main(String[] args) {
		HoverAction.launchBrowser();
		HoverAction.performHover();
		System.out.println("STEP-Closing Browser");
		driver.close();
	}

}
