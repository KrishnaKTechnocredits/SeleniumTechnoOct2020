package suresh;
/*Assignment - 5 [form : /resources/forms/Enable_And_Disable_&_Display_&_Hide_Form] 

a) if element visible -> gettext and print it and hide the element and make sure element is no more visible.

if element is not visible -> click on visible and hide button -> gettext and print it -> make sure element is now visible on the page. 

b) click on Enbled & Disabled button and verify whether that name inputbox is disabled or not.

c) once name textbox is disabled, try to call sendkeys method and verify behavior.

d) enabled name textbox -> sendKeys("Maulik") -> turn it to disabled -> getAttribute("value") -> compare text with "Maulik". 

Note : This will prove, getAttribute will work even though, element is disabled.*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class EnableAndDisableExample {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = PredefinedActions
				.start("file:///C:/Users/User/Desktop/Suresh/Learning/Oct_selenium/Resources/Enable_And_Disable_&_Display_&_Hide_Form.html");
		driver.findElement(By.id("myText")).sendKeys("Test123");
		
		 WebElement data = driver.findElement(By.id("myText"));
			System.out.println("Printing  Name value:" + data.getAttribute("value"));
			
			if(data.getAttribute("value").equals("Test123")) {
				System.out.println("Data is valid");
			}

		driver.findElement(By.xpath("//button[@onclick='disable()']")).click();

		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@onclick='disable()']")).click();
		driver.findElement(By.id("myText")).sendKeys("Suresh");
		Thread.sleep(4000);
		//driver.findElement(By.xpath("//button[@onclick='disable()']")).click(); we will get error if we try to send data when element is disable
		driver.findElement(By.id("myText")).sendKeys("Hello");
		System.out.println("Printing  Name value:" + data.getAttribute("value"));
		driver.quit();
		
	}
}
