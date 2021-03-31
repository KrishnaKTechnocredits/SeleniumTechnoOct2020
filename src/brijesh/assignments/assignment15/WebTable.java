package brijesh.assignments.assignment15;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import brijesh.base.Driver;

/*
Print list of employee in each department.

Hint : HashMap<String,LinkedHashSet<String>> hm = new HashMap<String,LinkedHashSet<String>>();

Expected output : 
{7003-HR=[Sumit Kulkarni, Pawan Belamkar], 7013-IT=[Nikhil Patne, Chetan Shewale, Priyanka Bhale], 7002-Finance=[Sumit Mate], 7001-Admin=[Abhijit Mane, Prayag Mokate]}
*/

public class WebTable {

	public static void main(String[] args) {
		WebDriver driver = Driver.start();
		try {
			System.out.println("Step: Navigate to 'Demo Tables'");
			driver.findElement(By.linkText("Demo Tables")).click();
			System.out.println("Step: Print list of employee in each department");
			HashMap<String, LinkedHashSet<String>> hashMap = new HashMap<String, LinkedHashSet<String>>();
			List<WebElement> rows = driver.findElements(By.cssSelector("#empmanager tbody>tr"));
			for (int index = 1; index <= rows.size(); index++) {
				String empDept = driver
						.findElement(By.cssSelector("#empmanager tr:nth-of-type(" + index + ") td:nth-of-type(5)"))
						.getText();
				String empName = driver
						.findElement(By.cssSelector("#empmanager tr:nth-of-type(" + index + ") td:nth-of-type(3)"))
						.getText();
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}

}
