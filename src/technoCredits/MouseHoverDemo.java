package technoCredits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import technoCredits.base.PredefinedActions;

public class MouseHoverDemo {

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("https://www.snapdeal.com/");

		WebElement ele = driver.findElement(By.xpath("//span[text()='All Offers']"));

		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();

		List<WebElement> list = driver.findElements(By.xpath("//div[@id='category1Data']//span[@class='linkTest']"));
		System.out.println(list.size());
	}
}
