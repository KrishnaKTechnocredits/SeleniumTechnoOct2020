package nagendra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import nagendra.base.PredefinedActions;

/*
Assignment : 11 [Complete it before Monday EOD] 
AutomationByKrishna -> Demo Tables -> Employee Manager Table:
*/

public class DemoTableEmployeeManager {
	public static WebDriver driver;

	static void getTotalDataRows() {
		System.out.println("Q1) how many rows are there in the table ?");
		int totalRows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();
		System.out.println("Total Number Of Rows -" + totalRows);
	}

	static void getTotalNumberOfUniqueEmployees() {
		System.out.println("Q2) how many employees are there in the table ?");
		HashSet<String> setOfEmployeeId = new HashSet<String>();
		List<WebElement> listOfElements = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[3]"));

		for (WebElement element : listOfElements) {
			if (!setOfEmployeeId.add(element.getText()))
				System.out.println("Duplicate Employee Id is :- " + element.getText());
		}
		System.out.println("Total Employees " + setOfEmployeeId.size());
	}

	static void getTotalManagers() {
		System.out.println("Q3 : how many managers we have  and print them?");
		HashSet<String> setOfManagers = new HashSet<String>();
		List<WebElement> listOfElements = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		for (WebElement element : listOfElements) {
			setOfManagers.add(element.getText());
		}
		System.out.println("YMnagers are  :- " + setOfManagers);
		System.out.println("Total Employees " + setOfManagers.size());
	}

	static void getTotalDepartment() {
		System.out.println("Q4 : how many depts we have and print them ?");
		HashSet<String> setOfDepartment = new HashSet<String>();
		List<WebElement> listOfElements = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		for (WebElement element : listOfElements) {
			setOfDepartment.add(element.getText());
		}
		System.out.println(" Department  are :- " + setOfDepartment);
		System.out.println("Total Department " + setOfDepartment.size());
	}

	static void printDeptNameandEmployees() {
		System.out.println("Q5: print dept name and number of employees in each dept.");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		List<WebElement> listOfDepartment = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		for (WebElement dept : listOfDepartment) {
			if (map.containsKey(dept.getText())) {
				map.put(dept.getText(), map.get(dept.getText()) + 1);
			} else {
				map.put(dept.getText(), 1);
			}
		}
		System.out.println(map);
	}

	static void getManagerIdWithMaximumReportee() {
		System.out.println("Q6: print the manager id having maximum employee reporting to him.");
		int num = 0;
		int maxCount = 0;

		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		List<WebElement> listOfManager = driver
				.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		ArrayList<String> managers = new ArrayList<String>();

		for (WebElement manager : listOfManager) {
			if (map.containsKey(manager.getText())) {
				map.put(manager.getText(), map.get(manager.getText()) + 1);
			} else {
				map.put(manager.getText(), 1);
				managers.add(manager.getText());

			}
		}

		for (int index = 0; index < map.size(); index++) {
		
			if (map.get(managers.get(index)) > maxCount) {
				maxCount = map.get(managers.get(index));
				num=index;
			}
		}
		System.out.println(managers.get(num)+"-"+maxCount);
	}

	public static void main(String[] args) {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		getManagerIdWithMaximumReportee();
		driver.close();
	}
}
