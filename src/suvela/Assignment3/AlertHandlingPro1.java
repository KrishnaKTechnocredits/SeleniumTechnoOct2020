package suvela.Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandlingPro1 {
	static WebDriver driver;

	public void start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
	}

	public void alert(String username, String pwd1, String pwd2) throws Exception {
		Thread.sleep(1000);
		System.out.println("Click on registration tab");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();
		Thread.sleep(1000);
		
		System.out.println("Enter Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys();
		
		System.out.println("Enter password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys();
		
		System.out.println("Click on login");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		
		String actualmsg = "Failed! please enter strong password";
		String expectedmsg = driver.switchTo().alert().getText();
		if (expectedmsg.equals(actualmsg))
			System.out.println("Alert generated with:" + expectedmsg);
		driver.switchTo().alert().accept();
		
		
		Thread.sleep(100);
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
		Thread.sleep(100);
		System.out.println("ReEnter strong password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys();
		
		System.out.println(" Again Click on login");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();
		String amsg = "Success!";
		String emsg = driver.switchTo().alert().getText();
		if (emsg.equals(amsg))
			System.out.println("Alert generated with:" + emsg);
		driver.switchTo().alert().accept();
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		new AlertHandlingPro1().start();
		String uname="Suvela K";
		String pwd1="123";
		String pwd2="12312345asd";
		new AlertHandlingPro1().alert(uname,pwd1,pwd2);

	}

}