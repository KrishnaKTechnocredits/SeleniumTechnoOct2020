package milind.assignment_11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeManagerTable {
	WebDriver driver;
	
	void getRowCountOfEmpManagerTable() {
		driver = PredefinedActions.start();
		System.out.println("STEP : Redirect to Demo tables");
		driver.findElement(By.xpath("//a[@id = 'demotable']")).click();
		System.out.println("STEP : Get count of data from Employee manager table");
		int totalDataRow = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		System.out.println("Total data rows are : " + totalDataRow);
	}
	
	void getTotalCountOfEmployeeFromTable() {
		System.out.println("STEP : Get count of data from Employee manager table");
		int totalDataRow = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		System.out.println(totalDataRow);
		List<WebElement> allEmpID = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]"));
		HashSet<String> totalEmp = new HashSet<String>();
		for(int index = 0; index < totalDataRow; index++) {
			totalEmp.add(allEmpID.get(index).getText());
		}
		System.out.println("Total Employee : ");
		System.out.println(totalEmp.size());
	}
	
	void getManagerCountAndPrint() {
		System.out.println("STEP : Get size of row on Manager ID");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]")).size();
		System.out.println("STEP : Get all manager ID in List");
		List<WebElement> listOfManagerID = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		HashSet<String> employeeID_Set = new HashSet<String>();
		for(int index = 0; index < rowCount; index++) {
			employeeID_Set.add(listOfManagerID.get(index).getText());
		}
		System.out.println("Total Department ID  : " + employeeID_Set.size());
		System.out.println(employeeID_Set);
	}
	
	void getTotalDepartmentCountAndPrint() {
		System.out.println("STEP : Get size of row on Department");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]")).size();
		System.out.println("STEP : Get all Department ID in List");
		List<WebElement> listOfManagerID = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		HashSet<String> departmentID_Set = new HashSet<String>();
		for(int index = 0; index < rowCount; index++) {
			departmentID_Set.add(listOfManagerID.get(index).getText());
		}
		System.out.println("Total Department ID  : " + departmentID_Set.size());
		System.out.println(departmentID_Set);
	}
	
	void printDeptNameAndNumberOfEmployeeOfDept() {
		System.out.println("STEP : Get total number of row count");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String, Integer> deptNameAndNumberOfEmpoyee = new HashMap<String, Integer>();
		for(int index = 1; index <= rowCount; index++) {
			String empDeptName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[5]")).getText();
			if(deptNameAndNumberOfEmpoyee.containsKey(empDeptName)) {
				deptNameAndNumberOfEmpoyee.put(empDeptName, deptNameAndNumberOfEmpoyee.get(empDeptName)+1);
			}else {
				deptNameAndNumberOfEmpoyee.put(empDeptName, 1);
			}
		}
		System.out.println(deptNameAndNumberOfEmpoyee);
	}
	
	void printMaximumEmployeeDept() {
		System.out.println("STEP : Get total number of row count");
		int rowCount = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		HashMap<String, Integer> managerIDAndEmployeeNumberReport = new HashMap<String, Integer>();
		for(int index = 1; index <= rowCount; index++) {
			String managerId = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[4]")).getText();
			if(managerIDAndEmployeeNumberReport.containsKey(managerId)) {
				managerIDAndEmployeeNumberReport.put(managerId, managerIDAndEmployeeNumberReport.get(managerId)+1);
			}else {
				managerIDAndEmployeeNumberReport.put(managerId, 1);
			}
		}
		int max = 0;
		String maxManagerKey = null;
		Set<String> keySetNameOfDept = managerIDAndEmployeeNumberReport.keySet();
		for(String managerID : keySetNameOfDept) {
			if(managerIDAndEmployeeNumberReport.get(managerID) > max) {
				max = managerIDAndEmployeeNumberReport.get(managerID);
				maxManagerKey = managerID;
			}
		}
		System.out.println(max + " : " + maxManagerKey);
	}
	
	public static void main(String[] args) {
		EmployeeManagerTable employeeManagerTable = new EmployeeManagerTable();
		employeeManagerTable.getRowCountOfEmpManagerTable();
		employeeManagerTable.getTotalCountOfEmployeeFromTable();
		employeeManagerTable.getManagerCountAndPrint();
		employeeManagerTable.getTotalDepartmentCountAndPrint();
		employeeManagerTable.printDeptNameAndNumberOfEmployeeOfDept();
		employeeManagerTable.printMaximumEmployeeDept();
		employeeManagerTable.driver.close();
	}

}
