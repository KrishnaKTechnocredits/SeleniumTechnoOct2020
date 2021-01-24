package milind.assignment_15;

import java.util.HashMap;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeNameFromCommonDepartment {
	
	WebDriver driver;
	
	void employeeName() {
		driver = PredefinedActions.start("http://automationbykrishna.com/#");
		System.out.println("STEP : Redirect to Demo tables");
		driver.findElement(By.cssSelector("a#demotable")).click();
		System.out.println("STEP : Get row count");
		int rowCount = driver.findElements(By.cssSelector("div#empmanager table tbody>tr>td:nth-child(5)")).size();
		HashMap<String, HashSet<String>> employeeDepartment = new HashMap<String, HashSet<String>>();
		for(int index = 1; index <= rowCount; index++) {
			String departmentID = driver.findElement(By.cssSelector("div#empmanager table tbody>tr:nth-of-type("+index+")>td:nth-child(5)")).getText();
			String employeeName = driver.findElement(By.cssSelector("div#empmanager table tbody>tr:nth-of-type("+index+")>td:nth-child(3)")).getText();
			
			if(employeeDepartment.containsKey(departmentID)) {
				if(employeeName.contains(employeeName)) {
					HashSet<String> employeeNames = employeeDepartment.get(departmentID);
					employeeNames.add(employeeName);
					employeeDepartment.put(departmentID, employeeNames);
				}
			}else {
				HashSet<String> emplyeeNames = new HashSet<String>();
				emplyeeNames.add(employeeName);
				employeeDepartment.put(departmentID, emplyeeNames);
			}
		}
		System.out.println(employeeDepartment);
	}
	
	public static void main(String[] args) {
		EmployeeNameFromCommonDepartment employeeNameFromCommonDepartment = new EmployeeNameFromCommonDepartment();
		employeeNameFromCommonDepartment.employeeName();
		employeeNameFromCommonDepartment.driver.close();
	}

}
