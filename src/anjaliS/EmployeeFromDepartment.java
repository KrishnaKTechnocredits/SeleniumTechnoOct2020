package anjaliS;

import java.util.HashMap;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ankita.base.PredefinedActions;

public class EmployeeFromDepartment {
	static WebDriver driver;

	void employeeName() {
		System.out.println("Automation by krishna website opened successfully");
		driver.get("http://automationbykrishna.com");

		System.out.println("Step 1 : Switch to Demo tables");
		driver.findElement(By.cssSelector("a#demotable")).click();

		System.out.println("Step 2 : Return total number of rows ");
		int rowCount = driver.findElements(By.cssSelector("div#empmanager table tbody>tr>td:nth-child(5)")).size();

		HashMap<String, HashSet<String>> employeeDepartment = new HashMap<String, HashSet<String>>();
		for (int index = 1; index <= rowCount; index++) {
			String departmentID = driver
					.findElement(
							By.cssSelector("div#empmanager table tbody>tr:nth-of-type(" + index + ")>td:nth-child(5)"))
					.getText();
			String employeeName = driver
					.findElement(
							By.cssSelector("div#empmanager table tbody>tr:nth-of-type(" + index + ")>td:nth-child(3)"))
					.getText();

			if (employeeDepartment.containsKey(departmentID)) {
				if (employeeName.contains(employeeName)) {
					HashSet<String> employeeNames = employeeDepartment.get(departmentID);
					employeeNames.add(employeeName);
					employeeDepartment.put(departmentID, employeeNames);
				}
			} else {
				HashSet<String> emplyeeNames = new HashSet<String>();
				emplyeeNames.add(employeeName);
				employeeDepartment.put(departmentID, emplyeeNames);
			}
		}
		System.out.println(employeeDepartment);
	}

	public static void main(String[] args) {
		driver = Driver.start();
		EmployeeFromDepartment ed = new EmployeeFromDepartment();
		ed.employeeName();
		driver.close();

	}

}
