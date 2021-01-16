/*
 2. Verify that by click on any button on form new window is opening
 * Note: use Window_Handling Form from resources
 */

package deepak.assignment8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import deepak.methods.UtilityMethods;

public class WindowHandling {
	
	
	public static void multipleWindowHandling(WebDriver driver) {
		
		String parentWindowId = driver.getWindowHandle();
		
		System.out.println("Step1 : CLick on first window");
		driver.findElement(By.xpath("//button[text()='First Window']")).click();
		
		java.util.Set<String> allWindow = driver.getWindowHandles();
		
		System.out.println("Step2 : Print all windowIds :"+ allWindow);
		
		for(String window : allWindow) {
			
			if(!(window.equals(parentWindowId))) {
				
				driver.switchTo().window(window);
				
				String childWindow = driver.getWindowHandle();
				
				System.out.println("Step3 : Switch to new window :"+ childWindow);		
			}
		}
		System.out.println("Test Pass");
	}

	public static void main(String[] args) {
		
			WebDriver driver = UtilityMethods.start("file:///G:/Technocredits/Selenium_Technocredits/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");
			multipleWindowHandling(driver);
			driver.quit();
	}
	}
