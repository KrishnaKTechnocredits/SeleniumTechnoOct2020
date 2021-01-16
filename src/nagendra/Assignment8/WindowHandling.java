package nagendra.Assignment8;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technoCredits.base.PredefinedActions;

/*
 2. Verify that by click on any button on form new window is opening.
Note: use Window_Handling Form from resources.
*/

public class WindowHandling {

	public static void verifyNewWindowOpening(WebDriver driver){
		
		System.out.println("STEP - Provided Implicit Wait to Driver Object");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println("STEP - Click on First Window");
		String mainWindow=driver.getWindowHandle();
		System.out.println(" Main window Name is->"+mainWindow);
		driver.findElement(By.xpath("//button[text()='First Window']")).click();
		Set<String> windows=driver.getWindowHandles();
		System.out.println("Total Windows After Opening new Window -->"+windows.size());
		for(String win :windows){
			System.out.println("Child Window is--"+win);
		}
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start(
				"file:///C:/Users/Nagendra/Documents/Training/Training/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");
		verifyNewWindowOpening(driver);
		
		System.out.println("STEP - Close the driver");
		driver.close();
		System.out.println("STEP - Test Completed");

	}
}
