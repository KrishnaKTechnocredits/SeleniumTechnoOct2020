package deepak.assignment13;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import deepak.methods.UtilityMethods;

public class MouseOver {
	
	static WebDriver driver;
	
	public static void mouseOverDemo() {
		//Step1: Identifying the web element on which you have to perform mouse over operation
		System.out.println("Step1: Identifying the web element on which you have to perform mouse over operation");
		WebElement link = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
				
		//Step2: Use actions class to perform mouse over operation
		System.out.println("Step2: Use action class to perform mouse over operation");
				
		Actions action = new Actions(driver);
				
		//Step3: By using action class reference varaible mouse over on web-element 
		System.out.println("Step3: By using action class reference varaible mouse over on web-element ");
		action.moveToElement(link).build().perform();
				
		//Step4: Find number of links
		System.out.println("Step4: Find number of links");
		List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@id='nav-al-container']//a"));
				
		System.out.println("Number of links under  Account & Lists are: "+ listOfLinks.size());
		System.out.println("--------Test Pass------------");	
	}

	public static void main(String[] args) throws InterruptedException {
		
		driver = UtilityMethods.start("https://www.amazon.com/");
		mouseOverDemo();
		driver.close();
	}
}
