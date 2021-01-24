package sadhana;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElementAlertDemo_Assign3 {

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
		System.out.println("STEP-Verify form title");
		/*String actualTitle=driver.getTitle();
		String expectedTitle="Alert Demo";
		
		if(actualTitle.equals(expectedTitle))
			System.out.println("We are on Alert Demo form");
			
		else
			driver.navigate().refresh();*/
		Thread.sleep(2000);
		
		System.out.println("STEP-Enter user First Name");
		driver.findElement(By.xpath("//*[@id='UserFirstName']")).sendKeys("Sadhana");
		System.out.println("STEP-Enter user Last Name");
		driver.findElement(By.xpath("//*[@id='UserLastName']")).sendKeys("Pawar");
		System.out.println("STEP-Enter user Company Name");
		driver.findElement(By.xpath("//*[@id='UserCompanyName']")).sendKeys("HCL");
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		System.out.println("STEP-Check Alert Message");
		Alert alert1 = driver.switchTo().alert();
		String actualText = alert1.getText();
		alert1.accept();
		System.out.println(".................."+actualText+"..................");
		Thread.sleep(2000); 
		driver.close();
		driver.quit();
		

	}

}
