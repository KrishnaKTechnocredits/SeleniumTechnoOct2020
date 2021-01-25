package mrunal;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import p1.base.PredefinedActions;

public class EmployeeManager {

	WebDriver driver = PredefinedActions.start();

	void EmployeeManager() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		List<WebElement> listOfRows=driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[2]"));
		System.out.println("Total rows in Employee manager: "+listOfRows.size());
		HashSet<String> setOfEmployeeID=new HashSet<String>();
		for(WebElement element:listOfRows) {
			boolean flag=setOfEmployeeID.add(element.getText());
			if(!flag)
				System.out.println("Duplicate Employee Id is :- " + element.getText());
		}
			System.out.println("Total Employees " + setOfEmployeeID.size());
		}
	
	void findTotlaManager() {
		List<WebElement> listOfRows=driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]"));
		System.out.println("Total rows in Employee manager: "+listOfRows.size());
		HashSet<String> setOfManagerID=new HashSet<String>();
		for(WebElement element:listOfRows) {
			boolean flag=setOfManagerID.add(element.getText());
			if(!flag)
				System.out.println("Duplicate Manager Id is :- " + element.getText());
		}
			System.out.println("Total Manager: " + setOfManagerID.size());
		}
	
	void printDept() {
		List<WebElement> listOfRows=driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[5]"));
		System.out.println("Total rows in Employee manager: "+listOfRows.size());
		HashSet<String> setOfDeptID=new HashSet<String>();
		for(WebElement element:listOfRows) {
			boolean flag=setOfDeptID.add(element.getText());
			if(!flag)
				System.out.println("Duplicate department Id is :- " + element.getText());
		}
			System.out.println("Total Departments are: " + setOfDeptID.size());
		}
	void printDeptEmployee() {
		List<WebElement> listOfRows=driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[5]"));
		HashMap<String,Integer>deptMap=new HashMap<String,Integer>();
		for(WebElement element:listOfRows) {
			if(deptMap.containsKey(element.getText())) {
				int index=deptMap.get(element.getText());
				deptMap.put(element.getText(), index+1);
			}else
				deptMap.put(element.getText(), 1);
		}
		System.out.println("Department name and number of employee:"+"\n"+deptMap);
	}
	void printMaxEmp() {
		int maxEmpReporting=0;
		String managerID="";
		List<WebElement> listOfRows=driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]"));
		HashMap<String,Integer>managerMap=new HashMap<String,Integer>();
		for(WebElement element:listOfRows) {
			if(managerMap.containsKey(element.getText())) {
				int index=managerMap.get(element.getText());
				managerMap.put(element.getText(), index+1);
			}else
				managerMap.put(element.getText(), 1);
		}
		Set<String> itr1=managerMap.keySet();
		for(String manager:itr1) {
			int value=managerMap.get(manager);
			if(maxEmpReporting<value) {
				maxEmpReporting=value;
				managerID=manager;
			}
		}
		System.out.println(managerID+"->"+maxEmpReporting+" is the manager having maximum employee reporting to him");
		}

	public static void main(String[] args) {
		EmployeeManager EmployeeManager1 = new EmployeeManager();
		EmployeeManager1.EmployeeManager();
		EmployeeManager1.findTotlaManager();
		EmployeeManager1.printDept();
		EmployeeManager1.printDeptEmployee();
		EmployeeManager1.printMaxEmp();

	}

}
