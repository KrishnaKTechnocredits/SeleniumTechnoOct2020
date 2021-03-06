package mrunal;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToAutomateWebTableElements {

	static WebDriver driver;

	void start() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	
		System.out.println("STEP - Taking to the Login Page");
        driver.get("http://automationbykrishna.com/#"); 
		System.out.println("Automation krishna website opened successfully");

		}

	void findUserNameIsValidOrNot() {
		driver.findElement(By.id("demotable")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	List<WebElement> Elements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		for (WebElement element : Elements) {

		String userName = element.findElement(By.xpath("./td[4]")).getText();
		String firstName = element.findElement(By.xpath("./td[2]")).getText();
		String lastName = element.findElement(By.xpath("./td[3]")).getText();
		Boolean userNameCondition = (firstName.toLowerCase().charAt(0) + lastName.toLowerCase()).equals(userName);

		if (userNameCondition)
				System.out.println("Username " + userName + " is correct");
		else
				System.out.println(userName + " is not valid Username");
			}
		}

	public static void main(String args[]) throws 	InterruptedException{
		ToAutomateWebTableElements toAutomateWebTableElements = new ToAutomateWebTableElements();
		toAutomateWebTableElements.start();
		toAutomateWebTableElements.findUserNameIsValidOrNot();

		}
	} 
