package pooja.Assignment_11;

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

public class Assignment_11 {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com");
		System.out.println("WEbsite Open Successfully");
		System.out.println("STEP-Finding Demo Tables");
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	static void findHowManyRows() {
		System.out.println("Total No. Of Rows Are: "
				+ driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size());
	}

	static void findHowManyEmployees() {
		List<WebElement> listOfEmpName = driver.findElements(By.xpath("//table[@class='table table-striped']//td[3]"));
		Set<String> empNames = new LinkedHashSet<String>();
		for (WebElement name : listOfEmpName) {
			empNames.add(name.getText());
		}
		System.out.println("No.Of Employees: " + empNames.size());
	}

	static void findHowManyManagers() {
		List<WebElement> listOFMngID = driver.findElements(By.xpath("//table[@class='table table-striped']//td[4]"));
		Set<String> mngId = new LinkedHashSet<String>();
		for (WebElement eleemnt : listOFMngID) {
			mngId.add(eleemnt.getText());
		}
		System.out.println("No.Of Managers Are: " + mngId.size());
		System.out.println(mngId);
	}

	static void findingMaximumReportingEmp() {
		List<WebElement> listOFMngID1 = driver.findElements(By.xpath("//table[@class='table table-striped']//td[4]"));
		Set<String> mngId1 = new LinkedHashSet<String>();
		Map<String, Integer> mngEmpMp = new LinkedHashMap<String, Integer>();
		for (WebElement element : listOFMngID1) {
			if (mngEmpMp.containsKey(element.getText())) {
				mngEmpMp.put(element.getText(), mngEmpMp.get(element.getText()) + 1);
			} else
				mngEmpMp.put(element.getText(), 1);
		}

		System.out.println(mngEmpMp);
		int max = 0;
		String keyMax = "";
		for (String key : mngEmpMp.keySet()) {
			if (mngEmpMp.get(key) > max) {
				max = mngEmpMp.get(key);
				keyMax = key;
			}
		}
		System.out.println(keyMax + " " + max + " reporting employee");
	}

	static void findHowManyDepartments() {
		List<WebElement> listOfDept = driver.findElements(By.xpath("//table[@class='table table-striped']//td[5]"));
		Set<String> deptName = new LinkedHashSet<String>();
		for (WebElement element : listOfDept) {
			deptName.add(element.getText());
		}
		System.out.println("No.Of Departments Are: " + deptName.size());
		System.out.println(deptName);
		System.out.println("********************");
		System.out.println("Q-Print dept name and number of employees in each dept.");
		Map<String, Integer> deptEmpMp = new LinkedHashMap<String, Integer>();
		for (WebElement element : listOfDept) {
			String text = element.getText();
			if (deptEmpMp.containsKey(text)) {
				deptEmpMp.put(text, deptEmpMp.get(text) + 1);
			} else
				deptEmpMp.put(text, 1);
		}
		System.out.println(deptEmpMp);
	}

	public static void main(String[] args) {
		Assignment_11.launchBrowser();
		System.out.println("Q.How Many Rows");
		Assignment_11.findHowManyRows();
		System.out.println("***************************");
		System.out.println("Q.How Many Employees");
		Assignment_11.findHowManyEmployees();
		System.out.println("***************************");
		System.out.println("Q.How Many Managers");
		Assignment_11.findHowManyManagers();
		System.out.println("***************************");
		System.out.println("Q.How Many Departments");
		Assignment_11.findHowManyDepartments();
		System.out.println("***************************");
		System.out.println("Q.Findning Maximum Reporting Employes");
		Assignment_11.findingMaximumReportingEmp();
		System.out.println("***************************");
		driver.close();
	}
}
