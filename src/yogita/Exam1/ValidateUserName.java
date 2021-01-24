/*
 * Exam 1-Validate All UserName
 */

package yogita.Exam1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateUserName {
	static WebDriver driver;
    static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Website open successfully.");
		driver.manage().window().maximize();
	}

	static void validateUserNameOfEmployee() {
		System.out.println("STEP-Finding DemoTable");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(("STEP-Finding no.Of Rows"));
		List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
		for (WebElement allElement : totalRows) {
			String fName = allElement.findElement(By.xpath("./td[2]")).getText();
			String lName = allElement.findElement(By.xpath("./td[3]")).getText();
			String uName = allElement.findElement(By.xpath("./td[4]")).getText();
			System.out.println("STEP-Verifying User Name");
			if ((fName.toLowerCase().charAt(0) + lName.toLowerCase()).equals(uName)) {
				System.out.println("Verification of  UserName --> Pass:" + uName);
			} else {
				System.out.println("Verification of  UserName -->Failed:" + uName);
			}
		}
	}

	public static void main(String[] args) {
		ValidateUserName.launchBrowser();
		ValidateUserName.validateUserNameOfEmployee();
	}

}
