package suvela.Assignment13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import suvela.basic.RequiredActions;

public class DragAndDrop {
	static WebDriver driver;
	public void performDragAndDrop(){
		System.out.println("Practice drag and drop using actions class of selenium");
		WebElement dragObject= driver.findElement(By.id("draggable"));
		WebElement targetObject= driver.findElement(By.id("droptarget"));
		
		System.out.println("Scroll window");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		System.out.println("Perform drag and drop");
		Actions ac= new Actions(driver);
		ac.dragAndDrop(dragObject, targetObject).build().perform();
		
		System.out.println("Script ran successfully!");
		
		driver.close();
	}
	public static void main(String[] args) {
		
		 driver= RequiredActions.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		 new DragAndDrop().performDragAndDrop();
	}

}
