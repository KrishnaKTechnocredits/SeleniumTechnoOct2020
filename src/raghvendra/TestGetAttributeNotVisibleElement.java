package raghvendra;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import raghvendra.base.ConstantAction;
/*Assignment - 5 [form : /resources/forms/Enable_And_Disable_&_Display_&_Hide_Form] 

a) if element visible -> gettext and print it and hide the element and make sure element is no more visible.

if element is not visible -> click on visible and hide button -> gettext and print it -> make sure element is now visible on the page. 

b) click on Enbled & Disabled button and verify whether that name inputbox is disabled or not.

c) once name textbox is disabled, try to call sendkeys method and verify behavior.

d) enabled name textbox -> sendKeys("Maulik") -> turn it to disabled -> getAttribute("value") -> compare text with "Maulik". 

Note : This will prove, getAttribute will work even though, element is disabled.*/
public class TestGetAttributeNotVisibleElement {
	WebDriver driver=ConstantAction.start("file:///C:/Java%20Selenium/Oct22/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
	void elemntVisible() {
		System.out.println("First Step: Check TechnoCredit Element is visible or not");
		boolean technoElement=driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(technoElement) {
			System.out.println("TechnoCredit Element is visible");
			String elementName=driver.findElement(By.xpath("//div[@id='myDIV']")).getText();
			System.out.println("TechnoCredit Element name is: "+elementName);
			System.out.println("Click on Visible and Hide button");
			driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
		}
	}
	void elemntNotVisible() {
		System.out.println("First Step: Chceck TechnoCredit Element is visible or not");
		boolean technoElement=driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed();
		if(!technoElement) {
			System.out.println("TechnoCredit Element is not visible");
			System.out.println("Click on Visible and Hide button");
			driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
			String elementNameVisible=driver.findElement(By.xpath("//div[@id='myDIV']")).getText();
			System.out.println("TechnoCredit Element name after it is visible: "+elementNameVisible);
		}
	}
	
	void enabledDisable() {
		System.out.println("Click on Enbled & Disabled button");
		driver.findElement(By.xpath("//button[@onclick='disable()']")).click();
		boolean enabledName=driver.findElement(By.xpath("//input[@id='myText']")).isEnabled();
		if(!enabledName) {
			System.out.println("Name Text box is disabled");
			try {
			      driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("Raghv");
			}catch(ElementNotInteractableException e) {
				System.out.println("We tried to enter value on disabled element");
			}
			String textDisable=driver.findElement(By.xpath("//input[@id='myText']")).getAttribute("value");
				if(textDisable==null|| textDisable.length()==0 )
					System.out.println("Not able to enter value in disable field");
		}
		else
			System.out.println("Name Text box is enabled");
		
		System.out.println("Click on Enbled & Disabled button");
		System.out.println("Text box is enabled");
		driver.findElement(By.xpath("//button[@onclick='disable()']")).click();
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("Raghv");
		String textName=driver.findElement(By.xpath("//input[@id='myText']")).getAttribute("value");
		System.out.println("Value entered in Textbox: "+textName);
		driver.findElement(By.xpath("//button[@onclick='disable()']")).click();
		String textDisableName=driver.findElement(By.xpath("//input[@id='myText']")).getAttribute("value");
		if(textName.equals(textDisableName))
			System.out.println("Values in text box after disable is same as whe it was enabled");
		}
	public static void main(String[] args) {
		TestGetAttributeNotVisibleElement test=new TestGetAttributeNotVisibleElement();
		test.elemntVisible();
		test.elemntNotVisible();
		test.enabledDisable();
	}
}
