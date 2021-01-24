package ritika.assignments_1to20;
/*Assignment - 5 [form : /resources/forms/Enable_And_Disable_&_Display_&_Hide_Form]
 * 
a) if element visible -> gettext and print it and hide the element and make sure element is no more visible.
if element is not visible -> click on visible and hide button -> gettext and print it -> make sure element is now visible on the page.

b) click on Enabled & Disabled button and verify whether that name inputbox is disabled or not.

c) once name textbox is disabled, try to call sendkeys method and verify behavior.

d) enabled name textbox -> sendKeys("Maulik") -> turn it to disabled -> getAttribute("value") -> compare text with "Maulik".

Note : This will prove, getAttribute will work even though, element is disabled.*/

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import technoCredits.base.PredefinedActions;

public class Asgmt_05_Form2 {
	
	static void  isEnableDisableVisible(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Step A - Check if Element is visible or not");
		//driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();  //--> This is to check else condition working
		if(driver.findElement(By.id("myDIV")).isDisplayed()) {
			System.out.println("Element is visible");
			String text = driver.findElement(By.id("myDIV")).getText();
			System.out.println("Visible element text is: " +text);
			driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
			if(!driver.findElement(By.id("myDIV")).isDisplayed()) {
				System.out.println("Now Element has been made Hidden");
				System.out.println(driver.findElement(By.id("myDIV")).getText().length()); 
				System.out.println("When element is hidden, getText() method is getting blank string in return");
			}
		}
		else if(!driver.findElement(By.id("myDIV")).isDisplayed()) {
			System.out.println("Element is Not Visible");
			driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
			if(driver.findElement(By.id("myDIV")).isDisplayed()) {
				System.out.println("Now Element is Displayed");
				String text = driver.findElement(By.id("myDIV")).getText();
				System.out.println("Visible element text is: " +text);
			}
		}
		
		System.out.println("Step B - Click on Enabled & Disabled button and verify whether that name inputbox is disabled or not");
		driver.findElement(By.xpath("//button[@onclick=\"disable()\"]")).click();
		if (!driver.findElement(By.id("myText")).isEnabled()) 
			System.out.println("Input box is disabled now");
		
		System.out.println("Step C - Once name textbox is disabled, try to call sendkeys method and verify behavior.");
		try {
			driver.findElement(By.id("myText")).sendKeys("TechnoCredits");
			//ElementNotInteractableException
		} catch (ElementNotInteractableException ele) {
			System.out.println("Unable to perform sendKeys operation on textbox when disabled");
			System.out.println(ele.getMessage());
		}
		System.out.println("Step D - Enable name textbox, perform sendKeys then Disable it and then perform getAttribute() operation");
		driver.findElement(By.xpath("//button[@onclick=\"disable()\"]")).click();
		driver.findElement(By.id("myText")).sendKeys("Maulik");
		driver.findElement(By.xpath("//button[@onclick=\"disable()\"]")).click();
		String enteredText = driver.findElement(By.id("myText")).getAttribute("value");
		if(enteredText.equals("Maulik"))
			System.out.println("getAttribute() operation worked successfully");
	}
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("file:///D:/TechnoCredits%20Class%20Oct%202020/Project/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		isEnableDisableVisible(driver);
		driver.close();
	}
}

