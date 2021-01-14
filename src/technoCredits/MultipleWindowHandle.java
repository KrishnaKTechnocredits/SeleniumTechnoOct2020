package technoCredits;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import technoCredits.base.PredefinedActions;

public class MultipleWindowHandle {

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start(
				"file:///D:/TechnoCredits/Batches/Oct2020/Projects/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");

		String mainWin = driver.getWindowHandle();
		//System.out.println(mainWin);
		driver.findElement(By.xpath("//button[4]")).click();
		Set<String> multiWin =driver.getWindowHandles();
		System.out.println(multiWin.size());
	}
}
