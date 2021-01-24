package suresh;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicElementsCheck {

	static WebDriver start() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Desktop\\Suresh\\Learning\\Oct_selenium\\selenium jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.navigate().to("http://automationbykrishna.com/#");
		String url1 = driver.getCurrentUrl();
		System.out.println("website URL is:\t" + url1);
		return driver;

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = start();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("basicelements")).click();
		Thread.sleep(5000);
		WebElement elementToClick = driver.findElement(By.xpath("//button[@class='btn btn-success']"));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", elementToClick);
		elementToClick.click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);

		System.out.println("Printing Java scipt Confirmation Acceptance");
		WebElement JSConfirmation = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		JavascriptExecutor JSConfirmation1 = (JavascriptExecutor) driver;
		JSConfirmation.click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

		String Jdata = driver.findElement(By.id("javascriptConfirmBox")).getText();
		System.out.println(Jdata);

		System.out.println("Printing Java scipt Confirmation Cancellation");
		JSConfirmation.click();
		driver.switchTo().alert();
		driver.switchTo().alert().dismiss();
		String Jcanceldata = driver.findElement(By.id("pgraphdemo")).getText();
		System.out.println(Jcanceldata);
		// Third set

		System.out.println("Printing Java scipt Confirmation Third Tab");
		Thread.sleep(1000);

		WebElement element = driver
				.findElement(By.xpath("//div[@class ='panel-body']/button[@class = 'btn btn-primary']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		Thread.sleep(1000);
		Alert promptAlert = driver.switchTo().alert();
		String alertText = promptAlert.getText();
		promptAlert.sendKeys("Suresh");
		promptAlert.accept();
		String Prompdata = driver.findElement(By.xpath("//p[@id=\"pgraphdemo\"]")).getText();
		System.out.println("Alert text is :" + Prompdata);
		driver.close();
	}

}
