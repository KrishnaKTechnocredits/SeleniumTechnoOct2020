/*Assignment - 3 : [Monday EOD]

Program - 1 : Verify alert message on Registration Page -> login.
*/
package mrunal;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoLogin {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		System.out.println("STEP - Taking to the Login Page");
        driver.get("http://automationbykrishna.com/#");  
        
        System.out.println("STEP - Taking to the Registration page ");
        driver.findElement(By.xpath("//*[@id='registration2']")).click();
        Thread.sleep(2000);
        
        System.out.println("STEP - Verifying with Invalid login credentials ");
        System.out.println("STEP - Entering invalid userid");
        driver.findElement(By.xpath("//*[@id='unameSignin']")).sendKeys("mkanani");
        System.out.println("STEP - enter password ");
        driver.findElement(By.xpath("//*[@id='pwdSignin']")).sendKeys("mk123");
        System.out.println("STEP - clicking on login button");
        driver.findElement(By.xpath("//*[@id='btnsubmitdetails']")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        String actualMessage = alert.getText();
        alert.accept();
        System.out.println(actualMessage);
        
        System.out.println("\n" + "STEP - Verifying with Valid login credentials ");
        System.out.println("STEP - Entering invalid userid");        
        driver.findElement(By.xpath("//*[@id='unameSignin']")).sendKeys("mkanani");
        System.out.println("STEP - enter password ");
        driver.findElement(By.xpath("//*[@id='pwdSignin']")).sendKeys("mkanani");
        System.out.println("STEP - clicking on login button");
        driver.findElement(By.xpath("//*[@id='btnsubmitdetails']")).click();
        Thread.sleep(2000);
        Alert alert1 = driver.switchTo().alert();
        String actualMessage1 = alert.getText();
        alert.accept();
        System.out.println(actualMessage1);
        
        driver.close();
        driver.quit();
       
         
	}

}
