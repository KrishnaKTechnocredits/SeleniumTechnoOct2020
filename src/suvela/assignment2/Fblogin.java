package suvela.assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fblogin {
	public void login() throws InterruptedException {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		System.out.println("Opening Facebook");

		driver.get("http://www.facebook.com");

		String actualpageurl = "www.facebook.com";
		String expectedpageurl = driver.getCurrentUrl();
		if (expectedpageurl.contains(actualpageurl))
			System.out.println("Page URL is correct");
		Thread.sleep(100);

		System.out.println("Enetring username");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("suvela.vela16@gmail.com");

		System.out.println("Entering password");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("****");

		driver.findElement(By.xpath("//button[@name='login']")).click();
		Thread.sleep(100);
		String epagetitle = "Log in to Facebook";
		String apagetitle = driver.getTitle();
		if (epagetitle.equals(apagetitle))
			System.out.println("Login suucessfull");

		driver.close();
	}

	public static void main(String[] args) throws Exception {
		new Fblogin().login();
	}

}
