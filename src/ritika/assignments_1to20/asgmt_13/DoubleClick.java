package ritika.assignments_1to20.asgmt_13;
/*Assignment - 13 : 20th Jan 2021
Actions class methods to perform
2. Double Click on (AutomationByKrishna)
*/
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ritika.base.PredefinedActions;

public class DoubleClick {

	static WebDriver driver;
	
	static void verifyDoubleClick() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("basicelements")).click();
		WebElement dblClick = driver.findElement(By.xpath("//a[text()='Double-click on me'] "));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", dblClick);
		Actions action = new Actions(driver);
		action.doubleClick(dblClick).build().perform();
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert is opened and its Text is: "+alert.getText());	
			alert.accept();
		} catch(Exception e){
			System.out.println("Alert is not present.");
		}
		System.out.println("Operation successfull");
	}

	public static void main(String[] args) {
		driver = PredefinedActions.start();
		verifyDoubleClick();
		driver.close();
	}
}
