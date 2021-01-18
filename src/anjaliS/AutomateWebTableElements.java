package anjaliS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateWebTableElements {
	static WebDriver driver;

	void start() {
		String browsePath = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", browsePath);
		driver = new ChromeDriver();
		System.out.println("Chrome browser opened");
		driver.manage().window().maximize();
		System.out.println("browser maximized");
		driver.get("http://automationbykrishna.com/");
		System.out.println("Automation krishna website opened successfully");

	}

	void findUserNameIsValidOrNot() {
		driver.findElement(By.id("demotable")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		for (int index = 1; index <= elements.size(); index++) {

			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();

			Boolean userNameCondition = (firstName.toLowerCase().charAt(0) + lastName.toLowerCase()).equals(userName);

			if (userNameCondition)
				System.out.println("Username " + userName + " is correct");
			else
				System.out.println(userName + " is not valid Username");
		}
	}

	public static void main(String args[]) {
		AutomateWebTableElements AutomateWebTableElements = new AutomateWebTableElements();
		AutomateWebTableElements.start();
		AutomateWebTableElements.findUserNameIsValidOrNot();

	}
}