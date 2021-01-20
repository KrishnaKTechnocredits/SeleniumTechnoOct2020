package deepak.assignment13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import deepak.methods.UtilityMethods;

public class DragAndDrop {

	static WebDriver driver;
	
	public static void DragAndDropDemo() throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step1: Accepting the cookies
		System.out.println("Step1: Accepting the cookies");
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		Thread.sleep(1000);
		
		//Step2: Finding the source and destination web-element to perform drag and drop operation
		System.out.println("Step2: Finding the source and destination web-element to perform drag and drop operation");
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement destinationElement = driver.findElement(By.xpath("//div[@id='droptarget']"));
		
		//Step3: Performing Drag And Drop Operation
		System.out.println("Step3: Performing Drag And Drop Operation");
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceElement, destinationElement).build().perform();
		
		//Step4: Verifying the text after Drag and Drop operation performed
		System.out.println("Step4: Verifying the text after Drag and Drop operation performed");
		String expectedTxt = "You did great!";
		String text = driver.findElement(By.xpath("//div[text()='You did great!']")).getText();
		if(text.equals(expectedTxt)) {
			
			System.out.println("--------Test Pass--------");
		}
		else
			System.out.println("--------Test Fail--------");
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		driver = UtilityMethods.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		DragAndDropDemo();
		driver.close();
	}

}
