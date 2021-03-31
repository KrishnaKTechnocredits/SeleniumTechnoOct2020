package nagendra.Assignment8;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technoCredits.base.PredefinedActions;

/*
1. Print missing link button text
Note: use missing link form from resources folder
*/

public class MissingLink {

	public static void printMissingLinkButtonText(WebDriver driver) {

		System.out.println("STEP - Provided Implicit Wait to Driver Object");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println("STEP - Find All The Links on a WebPage");
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		for (WebElement element : links) {
			try {
				if (element.getAttribute("href").equals("")) {
					System.out.println("Missing link is - " + element.getText());
				}
			} catch (NullPointerException npe) {
				System.out.println("Missing link is without href tag - " + element.getText());
			}
		}
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start(
				"file:///C:/Users/Nagendra/Documents/Training/Training/SeleniumTechnoOct2020/resources/forms/MissingLink.html");
		printMissingLinkButtonText(driver);
		System.out.println("STEP - Close the driver");
		driver.close();
		System.out.println("STEP - Test Completed");
		if(driver==null){
			driver.quit();
		}

	}
}
