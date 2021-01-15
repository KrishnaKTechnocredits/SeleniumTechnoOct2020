package ritika.assignments_1to20.asgmt_08;

/*Assignment - 8 : Missing_Link & Multiwindow_Handle
Program 1: Print missing link button text
Note: use missing link form from resources folder
*/
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technoCredits.base.PredefinedActions;

public class MissingLinks {

	static void printMissingLinkText(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Step -  Print missing link button text");
		List<WebElement> list = driver.findElements(By.xpath("//a"));
		System.out.println("Missing links are: ");
		for (WebElement ele : list) {
			if (ele.getAttribute("href") == null || ele.getAttribute("href").equals(""))
				System.out.println(ele.getText());
		}
	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start(
				"file:///D:/TechnoCredits%20Class%20Oct%202020/Project/SeleniumTechnoOct2020/resources/forms/MissingLink.html");
		printMissingLinkText(driver);
		driver.close();
	}
}
