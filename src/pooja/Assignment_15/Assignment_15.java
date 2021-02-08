/*Assignment - 15 
Print list of employee in each department.
Hint : HashMap<String,LinkedHashSet<String>> hm = new HashMap<String,LinkedHashSet<String>>();
Expected output : 
{7003-HR=[Sumit Kulkarni, Pawan Belamkar], 7013-IT=[Nikhil Patne, Chetan Shewale, Priyanka Bhale], 7002-Finance=[Sumit Mate], 7001-Admin=[Abhijit Mane, Prayag Mokate]}*/

package pooja.Assignment_15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pooja.RequiredActions;

public class Assignment_15 {

	WebDriver driver = RequiredActions.start();

	void getListOfEmpDept() {
		System.out.println("Step 1-Automation By Krishna ");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Step 2-Click on Demo Table option");
		driver.findElement(By.cssSelector("a#demotable")).click();
		int totalRows = driver.findElements(By.cssSelector("#empmanager tbody>tr")).size();
		HashMap<String, HashSet<String>> empDepartmentCount = new HashMap<String, HashSet<String>>();
		for (int index = 1; index <= totalRows; index++) {
			String deptName = driver
					.findElement(By.cssSelector("#empmanager tbody>tr:nth-of-type(" + index + ")>td:nth-of-type(5)"))
					.getText();
			String empName = driver
					.findElement(By.cssSelector("#empmanager tbody>tr:nth-of-type(" + index + ")>td:nth-of-type(3)"))
					.getText();
			if (empDepartmentCount.containsKey(deptName)) {
				HashSet<String> setEmpName = empDepartmentCount.get(deptName);
				setEmpName.add(empName);
				empDepartmentCount.put(deptName, setEmpName);
			} else {
				HashSet<String> setEmpName = new HashSet<String>();
				setEmpName.add(empName);
				empDepartmentCount.put(deptName, setEmpName);
			}
		}
		System.out.println("Total Employee In each Department are: " + "\n" + empDepartmentCount);
	}

	public static void main(String[] args) {
		Assignment_15 assignment15 = new Assignment_15();
		assignment15.getListOfEmpDept();
	}
}