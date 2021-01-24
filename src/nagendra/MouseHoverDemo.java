package nagendra;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import nagendra.base.PredefinedActions;

/*
3. Mouse hover on Amazon(Verify how many links available under Account & Lists)
*/

public class MouseHoverDemo {

	static WebDriver driver;

	static void verifyMouseHoverOperation() {
		WebElement element = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		System.out.println("STEP - Initialize Actions Class");
		Actions action = new Actions(driver);
		action.moveToElement(element);
		System.out.println("STEP - Find The Links on Web Page");
		List<WebElement> list = driver.findElements(By.xpath("//span[text()='Account & Lists']//following::div[@class='nav-title']//following-sibling::a"));
		System.out.println("Total Links -> "+list.size());
	}

	public static void main(String[] args) {
		System.out.println("STEP - Initialize WebDriver ");
		driver = PredefinedActions.start("https://www.amazon.in/");
		verifyMouseHoverOperation();
		System.out.println("STEP - Close The Driver");
		driver.close();
		System.out.println("STEP - Test Case Passed!!");

	}
}
