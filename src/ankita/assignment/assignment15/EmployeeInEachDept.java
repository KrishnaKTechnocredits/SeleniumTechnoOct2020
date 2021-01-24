/*Assignment - 15 : 23rd Jan'2021

Print list of employee in each department.

Hint : HashMap<String,LinkedHashSet<String>> hm = new HashMap<String,LinkedHashSet<String>>();

Expected output :
{7003-HR=[Sumit Kulkarni, Pawan Belamkar], 7013-IT=[Nikhil Patne, Chetan Shewale, Priyanka Bhale], 7002-Finance=[Sumit Mate], 7001-Admin=[Abhijit Mane, Prayag Mokate]}
*/
package ankita.assignment.assignment15;

import ankita.base.PredefinedActions;

import java.util.HashMap;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeInEachDept {
	static WebDriver driver = PredefinedActions.start();

	static void printDeptEmp() {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		int rowsCnt = driver.findElements(By.xpath(("//div[@id='empmanager']//tbody//tr"))).size();
		HashMap<String, LinkedHashSet<String>> empDeptMap = new HashMap<String, LinkedHashSet<String>>();

		for (int i = 1; i <= rowsCnt; i++) {
			String deptID = driver
					.findElement(By.cssSelector("div#empmanager tbody>tr:nth-of-type(" + i + ")>td:nth-of-type(5)"))
					.getText();
			String empName = driver
					.findElement(By.cssSelector("div#empmanager tbody>tr:nth-of-type(" + i + ")>td:nth-of-type(3)"))
					.getText();

			if (empDeptMap.containsKey(deptID)) {
				LinkedHashSet<String> empNamSet = empDeptMap.get(deptID);
				empNamSet.add(empName);
				empDeptMap.put(deptID, empNamSet);

			} else {
				LinkedHashSet<String> empNamSet = new LinkedHashSet<String>();
				empNamSet.add(empName);
				empDeptMap.put(deptID, empNamSet);
			}
		}
		System.out.println(empDeptMap);
	}

	public static void main(String[] arg) {
		printDeptEmp();
		driver.close();
	}
}