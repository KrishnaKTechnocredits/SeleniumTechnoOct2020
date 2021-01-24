package ruby;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesExam1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Step 1 - Open Browser");
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);

		System.out.println("Step 2- Click on Demo Tables");
		driver.findElement(By.linkText("Demo Tables")).click();

		//Get no. of rows in EMPLOYEE BASIC INFORMATION tabe
		List<WebElement> listOfEmployee = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));

		System.out.println("Validate UserName in EMPLOYEE BASIC INFORMATION");
		for (int index = 1; index <= listOfEmployee.size(); index++) {
			char firstNamefirstCh = driver
					.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[2]")).getText()
					.toLowerCase().charAt(0);
			String lastName = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[3]"))
					.getText().toLowerCase();
			String actualUserName = firstNamefirstCh + lastName;
			String expectedUsername = driver
					.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]//td[4]")).getText();

			if (actualUserName.equals(expectedUsername))
				System.out.println(actualUserName + " and " + expectedUsername + " both are same : Testcase Pass");
			else
				System.out.println(actualUserName + " and " + expectedUsername + " both are not same : Testcase Fail");
		}
		
		driver.quit();
	}
}
