package mrunal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPagePractice {

	public static void main(String[] args)  throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP -  Navigating to HRM Portal ");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println("STEP - Enter Credentials ");
		System.out.println("enter email id ");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(2000);
		
		System.out.println("enter password ");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(2000);
		
		System.out.println("STEP - LOGIN");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(2000);
		
		driver.close();  
		driver.quit();


	}

}
