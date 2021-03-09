package suvela.Assignment13;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import suvela.basic.RequiredActions;

public class DoubleClick {
	static WebDriver driver;
	public void doubleClick() throws InterruptedException {
		System.out.println("Navigate to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		Thread.sleep(2000);
		System.out.println("Scroll down to the page end");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		System.out.println("Now double click!");
		
		WebElement target=	driver.findElement(By.xpath("//a[text()='Double-click on me']"));
		Actions ac= new Actions(driver);
		ac.doubleClick(target).build().perform();
		System.out.println("Script ran successfully!");
		driver.switchTo().alert().accept();
		driver.close();
	}
	public static void main(String[] args) throws InterruptedException {
		driver= RequiredActions.start();
		new DoubleClick().doubleClick();
	}

}
