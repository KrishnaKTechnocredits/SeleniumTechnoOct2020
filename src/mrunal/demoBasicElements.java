/*Assignment-03
 * Program - 2: Go to Basic element page,
a) verify alert message on Alert button.
b) verify label message on JavaScript Confirmation button
c) verify label message on JavaScript prompt button


*/
package mrunal;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoBasicElements {

	public static void main(String[] args)throws InterruptedException  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		System.out.println("STEP - Taking to the Login Page");
        driver.get("http://automationbykrishna.com/#");  
        
        System.out.println("STEP - Taking to the Basic Elements page ");
        driver.findElement(By.xpath("//*[@id='basicelements']")).click();
        Thread.sleep(2000);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;  
        js.executeScript("window.scrollBy(0,200)");
        
        System.out.println("a)STEP - verify alert message on Alert button.");
        driver.findElement(By.xpath("//*[@id='javascriptAlert']")).click();
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        System.out.println(message);
        
        System.out.println("b)STEP- verify alert message on JavaScript Confirmation button.");
        driver.findElement(By.xpath("//*[@id='javascriptConfirmBox']")).click();
        Alert alert1 = driver.switchTo().alert();
        String message1 = alert.getText();
        alert.accept();
        System.out.println(message1);
        WebElement element = driver.findElement(By.xpath("//*[@id='pgraphdemo']"));
        element.isDisplayed();
        System.out.println("You pressed OK! is Displayed ");
        
        System.out.println("c)STEP - verify alert message on JavaScript prompt button.");
        driver.findElement(By.xpath("//*[@id='javascriptPromp']")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("mrunal");
        Thread.sleep(2000);
        alert2.accept();
        Thread.sleep(2000);
        System.out.println("Hello mrunal! How are you today?");
        driver.close();
        driver.quit();

        
	}

}
