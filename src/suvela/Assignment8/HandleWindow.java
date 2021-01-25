package suvela.Assignment8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import technoCredits.base.PredefinedActions;

public class HandleWindow {
	public void windowHandling(WebDriver driver) {
		System.out.println("Click on any button");
		driver.findElement(By.xpath("//button[text()='Third Window']")).click();
		System.out.println("Now check whether new window is popped up or not");
		String id= driver.getWindowHandle();
		if(!id.equals(null))
			System.out.println("Window is popped up with session id:"+ id);
		else
			System.out.println("No window popped out");
		driver.close();
	}
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start(
				"file:///F:/Java-Selenium%20course/Suvela-workspace/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");
		new HandleWindow().windowHandling(driver);
	}

}
