/*Assignment - 8 : Missing_Link 
1. Print missing link button text
Note: use missing link form from resources folder*/

package shrutiS.assignment8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shrutiS.base.LauchBrowser;

public class MissingLink {
	static WebDriver driver;
	
	public void findMissingLink(WebDriver driver) {
		List<WebElement> list= driver.findElements(By.xpath("//a"));
		for(WebElement element: list) {
			try{
				if(element.getAttribute("href").equals(""))
					System.out.println("Mising link text is:" +element.getText());
			}catch(NullPointerException ex) {
				System.out.println("Link which does not have href element is:" +element.getText());
			 }
		 }
		driver.close();
	 }
	
	public static void main(String[] args) {
		driver = LauchBrowser.start("E:\\SeleniumOCT20\\SeleniumTechnoOct2020\\resources\\forms\\MissingLink.html");
		new MissingLink().findMissingLink(driver);
	}
}
