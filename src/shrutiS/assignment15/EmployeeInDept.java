package shrutiS.assignment15;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shrutiS.util.LaunchBrowser;


public class EmployeeInDept {
	static WebDriver driver;
	
	static void findDeptEmployee() {
		{
			driver.findElement(By.linkText("Demo Tables")).click();
			HashMap<String, LinkedHashSet<String>> hashMap = new HashMap<String, LinkedHashSet<String>>();
			List<WebElement> rows = driver.findElements(By.cssSelector("#empmanager tbody>tr"));
			for (int index = 1; index <= rows.size(); index++) {
				String empDept = driver.findElement(By.cssSelector("#empmanager tr:nth-of-type(" + index + ") td:nth-of-type(5)")).getText();
				String empName = driver.findElement(By.cssSelector("#empmanager tr:nth-of-type(" + index + ") td:nth-of-type(3)")).getText();
				if (hashMap.containsKey(empDept)) {
					LinkedHashSet<String> hashSet = hashMap.get(empDept);
					hashSet.add(empName);
				} else {
					LinkedHashSet<String> hashSet = new LinkedHashSet<>();
					hashSet.add(empName);
					hashMap.put(empDept, hashSet);
				}
			}
			System.out.println(hashMap);
		}
	}
		public static void main(String[] arg) {
			driver = LaunchBrowser.start();
			findDeptEmployee();
			//driver.close();
		}
 }
