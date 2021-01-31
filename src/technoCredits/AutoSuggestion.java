package technoCredits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutoSuggestion {

	 WebDriver driver;

	 void start() {
		String path = "./resources/windows/chromedriver.exe";
		System.out.println("STEP - open chrome browser");
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
	}

	@Test
	void selectAutoSuggestionFromGoogle() throws InterruptedException {
		start();
		driver.findElement(By.cssSelector(".gLFyf.gsfi")).sendKeys("technolog");
		Thread.sleep(2000);
		List<WebElement> autoList = driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
		SoftAssert softAssert = new SoftAssert();
		for(WebElement element: autoList) {
			System.out.println(element.getText());
			softAssert.assertTrue(element.getText().equals("technology news"), "Error: Auto suggestion does not have 'Technology news'.");
		}
		for(WebElement element: autoList) {
			if(element.getText().equals("technology news")) {
				element.click();
				System.out.println("clicked on Technology news");
			}
		}
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("technology news"),"Error : Page title not updated.");
	}
}
