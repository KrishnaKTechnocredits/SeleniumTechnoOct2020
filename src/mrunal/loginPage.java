package mrunal;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class loginPage {
	
	

	public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
	WebDriver driver = new ChromeDriver();
	
	          driver.manage().window().maximize();
	          
	          System.out.println("Taking to the Facebook Login Page");
	          driver.get("https://www.facebook.com");
	          
	          System.out.println("enter your email id ");
	          driver.findElement(By.id("email")).sendKeys("email@gmail.com");
	          
	          System.out.println("enter your password ");
	          driver.findElement(By.id("pass")).sendKeys("password");
	     
	          
	          driver.findElement(By.id("u_0_b")).click(); 
	          
	          System.out.println("closing FB login page");
	          driver.quit();
	          driver.close();
	        
	     }
	}
	

