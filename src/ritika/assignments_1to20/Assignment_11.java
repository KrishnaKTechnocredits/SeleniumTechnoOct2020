package ritika.assignments_1to20;
/*Q1) how many rows are there in the table ?
ans : 9
Q2) how many employees are there in the table ?
ans : 8
Q3 : how many managers we have and print them?
ans : 3 [Set]
Q4 : how many depts we have and print them ?
ans : 4 [Set]
Q5: print dept name and number of employees in each dept.
ans : [Map]
7001-Admin -> 2
7002-Finance -> 2
7003-HR -> 2
7004-IT -> 3
hint : word freq -> String str = "Hi Hello Hi Hi Techno Hi Hello Hi" [print freq of each word]
Q6: print the manager id having maximum employee reporting to him.
ans : 20205 -> 4 [Map , find max key]
hint : String str = "Hi Hello Hi Hi Techno Hi Hello Hi"*/

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ritika.base.PredefinedActions;

public class Assignment_11 {

	static WebDriver driver;

	static List<WebElement> totalRowsInTable() {
		System.out.println("Q1) How many rows are there in the table ?");
		List<WebElement> totalRows = driver
				.findElements(By.xpath("//table[@class ='table table-striped']//tbody/tr/td[2]"));
		System.out.println("Ans -> " + totalRows.size());
		return totalRows;
	}

	static void totalEmployeesInTable() {
		List<WebElement> totalRows = totalRowsInTable();
		System.out.println("Q2) How many employees are there in the table ?");
		LinkedHashSet<String> listOfEmployeeNames = new LinkedHashSet<>();
		for (WebElement name : totalRows) {
			listOfEmployeeNames.add(name.getText());
		}
		System.out.println("Ans -> " + listOfEmployeeNames.size());
	}

	static List<WebElement> findNumOfManagers() {
		System.out.println("Q3 : how many managers we have and print them?");
		LinkedHashSet<String> listOfManagerIDs = new LinkedHashSet<String>();
		List<WebElement> totalManagerRows = driver
				.findElements(By.xpath("//table[@class ='table table-striped']//td[4]"));
		for (WebElement element : totalManagerRows) {
			listOfManagerIDs.add(element.getText());
		}
		System.out.println("Ans -> " + listOfManagerIDs.size());
		System.out.println(listOfManagerIDs);
		return totalManagerRows;
	}
	
	static List<WebElement> findNumOfDepts() {
		System.out.println("Q4 : how many depts we have and print them ?");
		List<WebElement> totalDeptRows = driver.findElements(By.xpath("//table[@class ='table table-striped']//td[5]"));
		LinkedHashSet<String> listOfDepts = new LinkedHashSet<String>();
		for (WebElement element : totalDeptRows) {
			listOfDepts.add(element.getText());
		}
		System.out.println("Ans -> " + listOfDepts.size());
		System.out.println(listOfDepts);
		return totalDeptRows;
	}

	static LinkedHashMap<String, Integer> findDeptsAndItsTotalEmployees() {
		LinkedHashMap<String, Integer> deptAndEmp = new LinkedHashMap<String, Integer>();
		List<WebElement> totalDeptRows = findNumOfDepts();
		System.out.println("Q5: print dept name and number of employees in each dept.");
		for (int index = 0; index < totalDeptRows.size(); index++) {
			Integer value = 0;
			String deptName = totalDeptRows.get(index).getText();
			if (deptAndEmp.containsKey(deptName)) {
				value = deptAndEmp.get(deptName) + 1;
				deptAndEmp.put(deptName, value);
			} else
				deptAndEmp.put(deptName, 1);
		}
		System.out.println(deptAndEmp);
		return deptAndEmp;
	}
	
	static void findManagerWithMaxExmployees() {
		List<WebElement> totalManagerRows = findNumOfManagers();
		System.out.println("Q6: print the manager id having maximum employee reporting to him.");
		LinkedHashMap<String, Integer> mngAndEmp = new LinkedHashMap<String, Integer>();
		for (int index = 0; index < totalManagerRows.size(); index++) {
			Integer value = 0;
			String deptName = totalManagerRows.get(index).getText();
			if (mngAndEmp.containsKey(deptName)) {
				value = mngAndEmp.get(deptName) + 1;
				mngAndEmp.put(deptName, value);
			} else
				mngAndEmp.put(deptName, 1);
		}
		String mng = "";
		Integer empNo = 0;
		Set<String> numOfMngs = mngAndEmp.keySet();
		for(String str : numOfMngs) {
			if(mngAndEmp.get(str)>empNo) {
				mng=str;
				empNo = mngAndEmp.get(str);
			}	
		}
		System.out.println("Ans -> "+mng+ " : "+empNo);
	}
	

	public static void main(String[] args) {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		totalEmployeesInTable();
		findDeptsAndItsTotalEmployees();
		findManagerWithMaxExmployees();
		driver.close();
	}

}
