package suvela.assign8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import technoCredits.base.PredefinedActions;

public class MissingLink {
	
public void findMissingLink(WebDriver driver) {
	List<WebElement> list= driver.findElements(By.xpath("//a"));
	for(WebElement e: list) {
		try{
			if(e.getAttribute("href").equals(""))
				System.out.println("Mising link text is:" +e.getText());
		}catch(NullPointerException ex) {
			System.out.println("Link which does not have href element is:" +e.getText());
		}
			
	}
	driver.close();
}
	public static void main(String[] args) {
		WebDriver driver= PredefinedActions.start("file:///F:/Java-Selenium%20course/Suvela-workspace/SeleniumTechnoOct2020/resources/forms/MissingLink.html");
		new MissingLink().findMissingLink(driver);
	}

}
