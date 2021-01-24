/*
 * Assignment - 5 [form : /resources/forms/Enable_And_Disable_&_Display_&_Hide_Form] 

a) if element visible -> gettext and print it and hide the element and make sure element is no more visible.

if element is not visible -> click on visible and hide button -> gettext and print it -> make sure element is now visible on the page. 

b) click on Enbled & Disabled button and verify whether that name inputbox is disabled or not.

c) once name textbox is disabled, try to call sendkeys method and verify behavior.

d) enabled name textbox -> sendKeys("Maulik") -> turn it to disabled -> getAttribute("value") -> compare text with "Maulik". 

Note : This will prove, getAttribute will work even though, element is disabled.

 */

package deepak.assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import deepak.methods.UtilityMethods;

public class Assignment5 {

	
	public static void elementVisibility(WebDriver driver) {
		
		WebElement element = driver.findElement(By.xpath("//div[@id='myDIV']"));
		
		if(element.isDisplayed()) {
			
			System.out.println("Element is visible case");
			System.out.println("Value inside the textbox: "+ element.getText());
			driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
			
			if(element.isDisplayed()) {
				
				System.out.println("-------------Test Fail----------------");
				System.out.println("Element not hide");
			}
			
			else {
				System.out.println("-------------Test Pass----------------");
				System.out.println("Element hide");
		}
	}
		
		else {
			
			System.out.println("Element not visisble case: ");
			driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
			if(element.isDisplayed()) {
				
				System.out.println(element.getText());
			}
			else
				System.out.println("Element still not visible");
		}
	}
	
	public static void textInputBoxDisable(WebDriver driver) {
		
		//Step1: Verify textBox is displayed and enables
		System.out.println("Step1: Verify textBox is displayed and enables");
		WebElement textBox = driver.findElement(By.xpath("//input[@id='myText']"));
		
		//Step2: Verify textBox is enabled
		System.out.println("Step2: Verify textBox is enabled");
		if(textBox.isEnabled()) {
			
			//Step3: Click on button Enable & Disable Button
			System.out.println("Step3: Click on button Enable & Disable Button");
			driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
			
			//Step4 : Checking textBox is disabled or not
			System.out.println("Step4 : Checking textBox is disabled or not");
			if(!(textBox.isEnabled())) {
				
				System.out.println("-----Test Pass----: TextInputBox is Disabled");
			}
			else
				System.out.println("-----Test Fail----: TextInputBox is NOT Disabled");
		}
		else
			System.out.println("Text box is already disabled");
	}
	
	public static void useOfSendKeysAfterDisablingElement(WebDriver driver){
		
		//Step1: Verify textBox is displayed and enables
		System.out.println("Step1: Verify textBox is displayed and enables");
		WebElement textBox = driver.findElement(By.xpath("//input[@id='myText']"));
		
		//Step2: Verify textBox is enabled
		System.out.println("Step2: Verify textBox is enabled");
		if(textBox.isEnabled()) {
			
			//Step3: Click on button Enable & Disable Button and make the inputTextBox as disabled
			System.out.println("Step3: Click on button Enable & Disable Button");
			driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
			try {
				textBox.sendKeys("Deepak");
			}catch(Exception e){
				
				System.out.println("ElementNotInteractableException");
				System.out.println("------Test Pass-------");
			}
			
		}
		
	}
	
	public static void verifyTextAfterDisable(WebDriver driver) {
		
		String inputTxt = "Maulik";
		//Step1: Find the textBox
		System.out.println("Step1: Find the textBox");
		WebElement txtBox = driver.findElement(By.xpath("//input[@id='myText']"));
		
		//Step2: Verify if it enabled
		System.out.println("Step2: Verify if it enabled");
		if(txtBox.isEnabled()) {
			txtBox.sendKeys(inputTxt);
			driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
			String valueAfterDisable = txtBox.getAttribute("value");
			
			System.out.println(valueAfterDisable);
			
			if(valueAfterDisable.equals(inputTxt)) {
				
				System.out.println("----Test Pass----");
			}
			else
				System.out.println("----Test Fail----");
			
		}
		else {
			
			//Step1: Click 'Enable & Disable Button 
			driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
			
			//Step2: Verify inputTextBox is enabled 
			System.out.println("Step2: Verify if it enabled");
			if(txtBox.isEnabled()) {
				txtBox.sendKeys(inputTxt);
				driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
				String valueAfterDisable = txtBox.getAttribute("value");
			
				if(valueAfterDisable.equals(inputTxt)) {
					
					System.out.println("----Test Pass----");
				}
				else
					System.out.println("----Test Fail----");	
			}
		}
		
	}
		
	public static void main(String[] args) {
		
		WebDriver driver = UtilityMethods.start("file:///G:/Technocredits/Selenium_Technocredits/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		elementVisibility(driver);
		textInputBoxDisable(driver);
		useOfSendKeysAfterDisablingElement(driver);
		verifyTextAfterDisable(driver);
		driver.close();
	}
}
	
