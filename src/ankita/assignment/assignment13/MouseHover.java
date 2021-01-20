//3. Mouse hover on Amazon(Verify how many links available under Account & Lists)

package ankita.assignment.assignment13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import ankita.base.PredefinedActions;

public class MouseHover {

	static WebDriver driver = PredefinedActions.start("https://www.amazon.in/");

	public static void mouseHover() {
		WebElement element = driver.findElement(By.xpath("//span[@class='nav-line-2 nav-long-width']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

		List<WebElement> list = driver.findElements(By.xpath("//div[@id='nav-al-container']//span[@class='nav-text']"));
		System.out.println(list.size());
	}

	public static void main(String[] args) {
		mouseHover();
		System.out.println("Step : closing Browser");
		driver.close();
	}
}