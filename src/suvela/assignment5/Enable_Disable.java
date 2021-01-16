package suvela.assignment5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;

import technoCredits.base.PredefinedActions;

public class Enable_Disable {
	public void isVisible(WebDriver driver) {
		System.out.println("======Method 1========");
		System.out.println("Check if Element is visible or not");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed())
			System.out.println("Displayed Text is :" + driver.findElement(By.xpath("//div[@id='myDIV']")).getText());
		else
			System.out.println("Element is not displayed");
		System.out.println("Click on Visible and Hidden button");
		driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
		System.out.println("Making sure element is no more visible");
		if (!driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed())
			System.out.println("Now Element is not visible");
		
		System.out.println("Script run successfully");
	}
	public void isEnable(WebDriver driver) {
		System.out.println("======Method 2========");
		System.out.println("Check if Enabled & Disabled button is disabled or not");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(!driver.findElement(By.xpath("//input[@id='myText']")).isEnabled())
			System.out.println("Button is disabled as expected");
		else
			System.out.println("Button is not disabled");
		
		System.out.println("Click on Enable & Disable button");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		System.out.println("once name textbox is disabled, try to call sendkeys method and verify behavior");
		try {
			driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("Suvela");
		}catch(ElementNotInteractableException e) {
			System.out.println("Can not send text to disabled textbox");
			System.out.println("Functionality verified!");
		}
		String name="Suvela";
		System.out.println("Again Click on Enable & Disable button");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys(name);
		System.out.println("Now disable the button and  make sure even after button is disabled we can get value of the text we entered");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		String aname=driver.findElement(By.xpath("//input[@id='myText']")).getAttribute("value");
		if(aname.equals(name))
			System.out.println("Hence verified getAttribute will work even though, element is disabled");
		driver.close();
	}

	public static void main(String[] args) {
		WebDriver driver=PredefinedActions.start(
				"file:///F:/Java-Selenium%20course/Suvela-workspace/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		new Enable_Disable().isVisible(driver);
		new Enable_Disable().isEnable(driver);
	}

}
