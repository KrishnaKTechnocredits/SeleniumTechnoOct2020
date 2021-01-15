/*Assignment - 8 : Missing_Link & Multiwindow_Handle 
1. Print missing link button text
Note: use missing link form from resources folder

2. Verify that by click on any button on form new window is opening
Note: use Window_Handling Form from resources
 */

package deepak.assignment8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import deepak.methods.UtilityMethods;

public class Missing_Links {
	
	public static void brokenLinks(WebDriver driver) {
		
		java.util.List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		System.out.println("Total Links are : "+ allLinks.size());
		
		for(WebElement links :allLinks) {
			
			if(links.getAttribute("href") == null || links.getAttribute("href").isEmpty()) {
				
				System.out.println(links.getText());
			}
		}	
	}

	public static void main(String[] args) {
		
		WebDriver driver = UtilityMethods.start("//G:/Technocredits/Selenium_Technocredits/SeleniumTechnoOct2020/resources/forms/MissingLink.html");
		brokenLinks(driver);
	}

}
