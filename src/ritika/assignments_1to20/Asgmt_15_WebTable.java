package ritika.assignments_1to20;

/*Assignment - 15 : 23rd Jan'2021
Print list of employee in each department.
Hint : HashMap<String,LinkedHashSet<String>> hm = new HashMap<String,LinkedHashSet<String>>();
Expected output :
{7003-HR=[Sumit Kulkarni, Pawan Belamkar], 7013-IT=[Nikhil Patne, Chetan Shewale, Priyanka Bhale], 7002-Finance=[Sumit Mate], 7001-Admin=[Abhijit Mane, Prayag Mokate]}*/

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ritika.base.PredefinedActions;

public class Asgmt_15_WebTable {
	
	static WebDriver driver;
	
	static void printListOfEmployeesInEachDept() {
		WebDriverWait wait =  new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("empmanager")));
		int totalRows = driver.findElements(By.cssSelector(".table.table-striped>tbody>tr")).size();
		LinkedHashMap<String,LinkedHashSet<String>> empInEachDeptMap = new LinkedHashMap<String,LinkedHashSet<String>>();
		for(int index=1; index<=totalRows; index++) {
			String deptName = driver.findElement(By.cssSelector(".table.table-striped>tbody>tr:nth-child("+index+")>td:nth-of-type(5)")).getText();
			String name = driver.findElement(By.cssSelector(".table.table-striped>tbody>tr:nth-child("+index+")>td:nth-of-type(3)")).getText();
			if(empInEachDeptMap.containsKey(deptName)) {
				LinkedHashSet<String> setOfEmployees = empInEachDeptMap.get(deptName);
				setOfEmployees.add(name);
				empInEachDeptMap.put(deptName, setOfEmployees);
			}
			else {
				LinkedHashSet<String> setOfEmployees = new LinkedHashSet<String>();
				setOfEmployees.add(name);
				empInEachDeptMap.put(deptName, setOfEmployees);
			}
		}
		System.out.println(empInEachDeptMap);
	}
	
	public static void main(String[] args) {
		
		driver = PredefinedActions.start();
		driver.findElement(By.id("demotable")).click();
		printListOfEmployeesInEachDept();
		driver.close();
	}
}

