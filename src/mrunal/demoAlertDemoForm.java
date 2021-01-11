/*Assignment03
 * Program - 3 : Go to Basic element page,
a) verify alert message on "Alert demo" form.*/
package mrunal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoAlertDemoForm {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		System.out.println("STEP - Taking to the Login Page");
        driver.get("http://automationbykrishna.com/#");
        
        System.out.println("STEP - Taking to the Basic Elements page ");
        driver.findElement(By.xpath("//*[@id='basicelements']")).click();
        Thread.sleep(2000);
        
        System.out.println("STEP - verify alert message on \"Alert demo\" form");
        System.out.println("Entering USer's FirstName");
        driver.findElement(By.xpath("//*[@id='UserFirstName']")).sendKeys("Mrunal");
        System.out.println("Entering USer's LastName");
        driver.findElement(By.xpath("//*[@id='UserLastName']")).sendKeys("Yadav");
        System.out.println("Entering USer's CompanyName");
        driver.findElement(By.xpath("//*[@id='UserCompanyName']")).sendKeys("ABC LLP");

      
	}

}
