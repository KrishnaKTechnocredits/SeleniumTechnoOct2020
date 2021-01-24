package suvela.Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandlingPro2 {
	static WebDriver driver;

	public void start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
	}

	public void alertButton(String alertmsg) throws Exception {
		System.out.println("Alert type 1");
		Thread.sleep(1000);
		System.out.println("click on basic elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[@id='javascriptAlert']")));;
		Thread.sleep(1000);

		String expectedmsg = driver.switchTo().alert().getText();
		if (alertmsg.equals(expectedmsg))
			System.out.println("Alert generated with:" + expectedmsg);
		driver.switchTo().alert().accept();
		// driver.close();
	}

	public void confirmationBox(String msg) throws Exception {
		System.out.println("Alert type 2");
		Thread.sleep(1000);
		System.out.println("click on basic elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);

		System.out.println("Go to confirmation box button");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[@id='javascriptConfirmBox']")));
		Thread.sleep(1000);

		driver.switchTo().alert().accept();
		;

		
		String labelmsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (labelmsg.equals(msg))
			System.out.println("Alert has been accepted");
		else
			System.out.println("Alert has been canceled");
		// driver.close();

	}

	public void promt(String name,String actualmsg) throws Exception {
		System.out.println("Alert type 3");
		Thread.sleep(1000);
		System.out.println("click on basic elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);

		System.out.println("Go to promt box button");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", driver.findElement(By.xpath("//button[@id='javascriptPromp']")));
		Thread.sleep(1000);

		
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		
		String labelmsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (actualmsg.equals(labelmsg))
			System.out.println("Alert has been accepted");
		else
			System.out.println("Alert has been canceled");
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		new AlertHandlingPro2().start();
		String alertmsg = "You must be TechnoCredits student!!";
		new AlertHandlingPro2().alertButton(alertmsg);
		
		String msg = "You pressed OK!";
		new AlertHandlingPro2().confirmationBox(msg);
		
		String name = "Suvela";
		String actualmsg = "Hello " + name + "!" + " How are you today?";
		new AlertHandlingPro2().promt(name,actualmsg);
	}

}