package suvela.Assignment17;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import suvela.basic.RequiredActions;

public class PracticeiFrame {
	static WebDriver driver;
	
	
	@Test
	public void switchToiFrame() throws InterruptedException {
		driver= RequiredActions.start();
		System.out.println("Click on iFrame demo");
		driver.findElement(By.xpath("//a[@id='iframes']")).click();
		Thread.sleep(5000);
		System.out.println("Now switch to iFrame 1");
		driver.switchTo().frame(0);
		
		driver.findElement(By.id("dropdownButton")).click();
		String about=driver.findElement(By.xpath("//nav[@id='navbar']//span[1]")).getText();
		System.out.println("iFrame 1 Text: " +about);
		
		System.out.println("Switch back to main Frame");
		driver.switchTo().parentFrame();
		
		System.out.println("Now switch to iFrame 2");
		driver.switchTo().frame("site2");
		System.out.println("Swiched to site 2");
		
		System.out.println("Switch back to main Frame");
		driver.switchTo().parentFrame();
		
		System.out.println("Now switch to iFrame 3");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='site3']")));
		String text=driver.findElement(By.xpath("//div[@class='menu']/ul/li[1]/ul/li[1]")).getText();
		System.out.println("iFrame 3 Text: " +text);
		
	}
	
		
		
	}

