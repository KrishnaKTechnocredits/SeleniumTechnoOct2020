package anjaliS;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementsOfWebTable {
	static WebDriver driver;

	void start() {
		String path = "./resources/windows/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com/");
		System.out.println("AutomationByKrishna website open successfully.");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Demo Tables")).click();
	}

	void findElementsFromTable() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("No.of rows: "
				+ driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size());
		List<WebElement> listOfEmpName = driver.findElements(By.xpath("//table[@class='table table-striped']//td[3]"));
		Set<String> empNames = new LinkedHashSet<String>();
		for (WebElement name : listOfEmpName) {
			empNames.add(name.getText());
		}
		System.out.println("Size of employees:. " + empNames.size());

		List<WebElement> listOFManagerID = driver
				.findElements(By.xpath("//table[@class='table table-striped']//td[4]"));
		Set<String> mangersId = new LinkedHashSet<String>();
		for (WebElement element : listOFManagerID) {
			mangersId.add(element.getText());
		}
		System.out.println("Total managers:" + mangersId.size());
		System.out.println(mangersId);

		List<WebElement> listOfDept = driver.findElements(By.xpath("//table[@class='table table-striped']//td[5]"));
		Set<String> deptName = new LinkedHashSet<String>();
		for (WebElement element : listOfDept) {
			deptName.add(element.getText());
		}
		System.out.println("Total departments : " + deptName.size());
		System.out.println(deptName);
	}

	public static void main(String[] args) {
		ElementsOfWebTable ele = new ElementsOfWebTable();
		ele.start();
		ele.findElementsFromTable();
	}

}