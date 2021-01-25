package vaibhav.assignment15;

import java.util.HashMap;
import java.util.HashSet;

/*Assignment - 15 : 23rd Jan'2021

Print list of employee in each department.

Hint : HashMap<String,LinkedHashSet<String>> hm = new HashMap<String,LinkedHashSet<String>>();

Expected output :
{7003-HR=[Sumit Kulkarni, Pawan Belamkar], 7013-IT=[Nikhil Patne, Chetan Shewale, Priyanka Bhale], 7002-Finance=[Sumit Mate], 7001-Admin=[Abhijit Mane, Prayag Mokate]}
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import vaibhav.base.Driver;

public class EmployeeManagerDetails {
	
	static WebDriver driver;
	
	private static void findUniqueDetails() {
		HashMap <String,HashSet<String>> empDept = new HashMap <String,HashSet<String>>();
		
		int totalRowCount = driver.findElements(By.cssSelector("div#empmanager tbody>tr")).size();		
		for (int index = 1 ; index <= totalRowCount ; index++) {
			String deptName = driver.findElement(By.cssSelector("div#empmanager tbody>tr:nth-of-type("+index+")>td:nth-child(5)")).getText();
			String sigleEmpName = driver.findElement(By.cssSelector("div#empmanager tbody>tr:nth-of-type("+index+")>td:nth-child(3)")).getText();
			if(empDept.containsKey(deptName)) {
				HashSet <String> empNames= empDept.get(deptName);
				empNames.add(sigleEmpName);
				empDept.put(deptName, empNames);
								
			}else {
				HashSet <String> empNames = new HashSet <String> ();
				empNames.add(sigleEmpName);
				empDept.put(deptName, empNames);								
			}			
		}
		System.out.println(empDept);
		
	}

	public static void main(String[] args) {
		driver = Driver.start();
		driver.findElement(By.linkText("Demo Tables")).click();		
		EmployeeManagerDetails.findUniqueDetails();
	}

}
