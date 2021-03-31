/*Assignment - 15 : 23rd Jan'2021 

 Print list of employee in each department.

Hint : HashMap<String,LinkedHashSet<String>> hm = new HashMap<String,LinkedHashSet<String>>();

Expected output : 
{7003-HR=[Sumit Kulkarni, Pawan Belamkar], 7013-IT=[Nikhil Patne, Chetan Shewale, Priyanka Bhale], 7002-Finance=[Sumit Mate], 7001-Admin=[Abhijit Mane, Prayag Mokate]}*/
package suvela.Assignment15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import suvela.basic.RequiredActions;

public class ListOfEmpInDepts {
	static WebDriver driver;
	public void getEmpList() {
		System.out.println("Print list of employee in each department.");
		driver.findElement(By.linkText("Demo Tables")).click();
		int totalRows= driver.findElements(By.xpath("//div[@id='empmanager']//tbody//tr")).size();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#empmanager")));
		
		HashMap<String,LinkedHashSet<String>> emp_deptMap = new HashMap<String,LinkedHashSet<String>>();
		for(int index=1;index<=totalRows;index++) {
			String empName= driver.findElement(By.cssSelector("div#empmanager tbody tr:nth-of-type("+index+")>td:nth-of-type(3)")).getText();
			String deptName= driver.findElement(By.xpath("//div[@id='empmanager']//tbody/tr["+index+"]/td[5]")).getText();
			
			if(emp_deptMap.containsKey(deptName)) {
				LinkedHashSet<String> set= emp_deptMap.get(deptName); // returns value of the key(deptName) provided, which is LinkedHashSet.
				set.add(empName);
				emp_deptMap.put(deptName, set);
			}else {
				LinkedHashSet<String> set= new LinkedHashSet<String>();
				set.add(empName);
				emp_deptMap.put(deptName, set);
			}
		}
		System.out.println(emp_deptMap);
		driver.close();
	}
	public static void main(String[] args) {
		driver= RequiredActions.start();
		new ListOfEmpInDepts().getEmpList();
	}

}
