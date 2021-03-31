package prasad;

/*Assignment - 15 : 23rd Jan'2021

Print list of employee in each department.

Hint : HashMap<String,LinkedHashSet<String>> hm = new HashMap<String,LinkedHashSet<String>>();

Expected output :
{7003-HR=[Sumit Kulkarni, Pawan Belamkar], 7013-IT=[Nikhil Patne, Chetan Shewale, Priyanka Bhale], 7002-Finance=[Sumit Mate], 7001-Admin=[Abhijit Mane, Prayag Mokate]}
*/
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmpNamesPerDept {
	static WebDriver driver;

	public static void main(String[] arg) {
		EmpNamesPerDept emp = new EmpNamesPerDept();
		driver = StaticResources.start();
		emp.getEmpByDept();
	}

	void getEmpByDept() {
		System.out.println("Step 1: Open browser and open URL");
		System.out.println("Step 2: Navigate to Demo Tables tab");
		driver.findElement(By.cssSelector("#demotable")).click();
		
		/*Waiting till Employee Manager table is loaded in HTML Dome*/
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel-body>table.table.table-striped")));
		
		System.out.println("Step 3: Find total number of rows in Employee Manager data table");
		int totalRows = driver.findElements(By.cssSelector(".table.table-striped tbody>tr")).size();
		System.out.println(totalRows);
		System.out.println("Step 4: Printing employees in each department");

		HashMap<String, LinkedHashSet<String>> EmpwithDept = new HashMap<String, LinkedHashSet<String>>();

		for (int index = 1; index <= totalRows; index++) {
			WebElement empNameEle = driver.findElement(
					By.cssSelector(".table.table-striped tbody>tr:nth-of-type(" + index + ")>td:nth-of-type(3)"));
			WebElement departmentEle = driver.findElement(
					By.cssSelector(".table.table-striped tbody>tr:nth-of-type(" + index + ")>td:nth-of-type(5)"));
			String empName = empNameEle.getText();
			String departmentName = departmentEle.getText();
			LinkedHashSet<String> empNameList = new LinkedHashSet<String>();

			if (EmpwithDept.containsKey(departmentName)) {
				LinkedHashSet<String> empNameToBeAdded = EmpwithDept.get(departmentName);
				empNameToBeAdded.add(empName);
				/*Here if department name(Key) is already present in the map then we find its value(LinkedHashSet) 
				and then add the employee name which we have got during this iteration to the same LinkedHashSet.*/
			} else {
				empNameList.add(empName);
				EmpwithDept.put(departmentName, empNameList);
				/*If department name(Key) is not present in the map then we add the name which we have got in this 
				iteration of the loop to the LinkedHashSet and then add this set as value and department
				name as key in the map.*/
			}

		}
		System.out.println(EmpwithDept);

	}

}
