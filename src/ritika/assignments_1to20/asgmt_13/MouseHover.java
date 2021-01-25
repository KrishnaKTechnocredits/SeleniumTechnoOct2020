package ritika.assignments_1to20.asgmt_13;
/*Assignment - 13 : 20th Jan 2021
Actions class methods to perform
3. Mouse hover on Amazon(Verify how many links available under Account & Lists)
*/
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ritika.base.PredefinedActions;

public class MouseHover {

	static WebDriver driver;
	
	static void verifyMouseHover() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement accountLink = driver.findElement(By.id("nav-link-accountList"));
		Actions action = new Actions(driver);
		action.moveToElement(accountLink).build().perform();
		if(driver.findElement(By.id("nav-al-container")).isDisplayed())
			System.out.println("Container with Links is being displayed properly on Mouse Hover");
		List<WebElement> linksUnderAccTab = driver.findElements(By.xpath("//div[@id ='nav-al-container']//a"));
		if(linksUnderAccTab.size()==19)
			System.out.println("Correct number of links displayed");
		System.out.println("Operation successfull");
	}

	public static void main(String[] args) {
		driver = PredefinedActions.start("https://www.amazon.in/");
		verifyMouseHover();
		driver.close();
	}
}
