package suresh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import base.PredefinedActions;

public class propFileReadingForm {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File("./src/config/confFormData.properties");
		FileInputStream inputstream = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(inputstream);
		String firstname = prop.getProperty("firstname");
		// System.out.println(firstname);
		String url = prop.getProperty("url");
		driver = PredefinedActions.start(url);

		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='last name']")).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.xpath("//input[@id='E-mail']")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath("//input[@id='Company Name']")).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath("//input[@id='maleG']")).click();
		Select drpCountry = new Select(driver.findElement(By.xpath("//select[@id='continents']")));
		drpCountry.selectByVisibleText(prop.getProperty("Living"));

		driver.findElement(By.xpath("//input[@id='expert']")).click();

		driver.findElement(By.xpath("//input[@id='java']")).click();
		driver.findElement(By.xpath("//input[@id='google']")).click();
		driver.findElement(By.xpath("//input[@id='confirmDetails']")).click();
		
		driver.findElement(By.linkText("Go And Practice For it")).click();
		Thread.sleep(4000);
		
		driver.navigate().back();
		
		WebElement data = driver.findElement(By.xpath("//input[@id='first name']"));
		if(data.getAttribute("value").equals(firstname)) {
			System.out.println("Data is valid");
		}
		//driver.quit();

	}
}
