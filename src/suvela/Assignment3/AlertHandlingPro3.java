package suvela.Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandlingPro3 {
	static WebDriver driver;

	public void start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
	}
	public void verifyForm(String fname, String lname,String company) throws Exception {
		System.out.println("click on basic elements tab");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		Thread.sleep(1000);
		
		System.out.println("Enter first name");
		
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(fname);
		System.out.println("Enter last name");
		
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lname);
		System.out.println("Enter company name");
		
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(company);
		
		System.out.println("Hit submit");
		driver.findElement(By.xpath("//div[@id='firstRow']/div[1]//button[@type='submit']")).click();
		
		String actualmsg=fname +" and " +lname+ " and "+company;
		String alertmsg=driver.switchTo().alert().getText();
		if(alertmsg.equals(actualmsg))
			System.out.println("Alert has been handled");
		else
			System.out.println("Alert has been cancled");
		driver.switchTo().alert().dismiss();
		driver.close();
	}
	public static void main(String[] args) throws Exception {
		new AlertHandlingPro3().start();
		String fname="Suvela";
		String lname="Khaladkar";
		String company="ABC";
		new AlertHandlingPro3().verifyForm(fname,lname,company);

	}

}