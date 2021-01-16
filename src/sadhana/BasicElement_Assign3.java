package sadhana;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElement_Assign3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String path = "C:\\TechnoCredids\\Selenium_Practice\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP-Navigate to AutomationByKrishna.com");
		driver.get("http://automationbykrishna.com/#");
		driver.manage().window().maximize();	
		System.out.println("STEP-Click on Basic Elements tab");
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(2000);       
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");		
		System.out.println("STEP-Click on Alert button ");	
		driver.findElement(By.id("javascriptAlert")).click();	
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		alert.accept();
		System.out.println(actualMessage);
		Thread.sleep(3000);
		System.out.println("\n"+".............................................................");
		System.out.println("\n"+"STEP-verify label message on JavaScript Confirmation button");
		System.out.println("STEP-Click on Javascript Confirmation button");
		driver.findElement(By.xpath("//*[@id='javascriptConfirmBox']")).click();
		System.out.println("Message on Alert window is");
		Alert alert1 = driver.switchTo().alert();
		String actualText = alert1.getText();
		alert1.accept();
		System.out.println(".................."+actualText+"..................");
		System.out.println("STEP-Lable message after click on Alert OK");
		String alertText=driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		System.out.println(".................."+alertText+"..................");
		Thread.sleep(3000);	
		System.out.println("\n"+".............................................................");
		System.out.println("\n"+"STEP-verify label message on JavaScript prompt button");
		driver.findElement(By.xpath("//*[@id='javascriptPromp']")).click();
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println("STEP-Enter text in alert textbox");
		alert2.sendKeys("TechnoCredit");
		alert2.accept();
		System.out.println("STEP-Get label message of javascript primpt button");
		String alertPromtText=driver.findElement(By.xpath("//*[@id='pgraphdemo']")).getText();
		System.out.println(alertPromtText);
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}

	
	}

