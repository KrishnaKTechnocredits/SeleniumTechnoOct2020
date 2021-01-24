package ritika.assignments_1to20.asgmt_08;

/*Assignment - 8 : Missing_Link & Multiwindow_Handle
Program 2 - Verify that by click on any button on form new window is opening
Note: use Window_Handling Form from resources*/

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technoCredits.base.PredefinedActions;

public class WindowHandle {

	static void multiWindowHandle(WebDriver driver) {
		System.out.println("Step - Verify that by click on any button on form new window is opening");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Main Window Title is: " + driver.getTitle());
		driver.findElement(By.xpath("//button[3]")).click();
		Set<String> multiWin = driver.getWindowHandles();
		if (multiWin.size() == 2) {
			System.out.println("Total opened windows are: " + multiWin.size());
			System.out.println("New window opened successfully");
		}
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start(
				"file:///D:/TechnoCredits%20Class%20Oct%202020/Project/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");
		multiWindowHandle(driver);
		driver.quit();
	}
}
