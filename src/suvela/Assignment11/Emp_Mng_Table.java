/*Assignment : 11 [Complete it before Monday EOD] 

AutomationByKrishna -> Demo Tables -> Employee Manager Table:

Q1) how many rows are there in the table ?
ans : 9

Q2) how many employees are there in the table ?
ans : 8

<table>
	<tr>
		<th> first name> </th>
	</tr>
	
	<tr>
		<td> Vaibhav </td>
	</tr>
	
</table> 

solution : 1

	int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
     
	for(int index=1;index<=totalRows;index++){
		sop(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+index+"]/td[2]")).getText());
	}

solution2 : 
	HashSet<String> setOfEmployeeId = new HashSet<String>();
	List<WebElement> listOfElements= driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[2]")); 

	for(WebElement element : listOfElements){
		if(!setOfEmployeeId.add(element.getText()))
			sop("Duplicate Employee Id is :- " + element.getText());
	}
	sop("Total Employees " + setOfEmployeeId.size()); // 8
	-----------------------------------------------

Q3 : how many managers we have  and print them?
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
hint : String str = "Hi Hello Hi Hi Techno Hi Hello Hi"	
*/

package suvela.Assignment11;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import suvela.basic.RequiredActions;

public class Emp_Mng_Table {
	public void findAnswersQ1(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Q1) how many rows are there in the table ?");
		int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
		System.out.println("Total rows in the Employee Manager Table: " + totalRows);
		System.out.println("=======");
	}

	public void findAnswersQ2(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Q2) how many employees are there in the table ?");
		HashSet<String> setOfId = new HashSet<String>();
		List<WebElement> listOfId = driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr//td[2]"));
		System.out.println("Is there any duplicate employee id? If yes which Id is duplicate? >");
		for (WebElement el : listOfId) {
			
			if (!setOfId.add(el.getText()))
				System.out.println("Duplicate Emp Id is:" + el.getText());
		}
		System.out.println("Total employees in the table are:" + setOfId.size());
		System.out.println("=======");
	}

	public void findAnswersQ3(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Q3 : how many managers we have and print them?");
		LinkedHashSet<String> setOfMng = new LinkedHashSet<String>();
		List<WebElement> listOfMng = driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr//td[4]"));
		for (WebElement el : listOfMng) {
			setOfMng.add(el.getText());
		}
		System.out.println("Total Managers in the table are:" + setOfMng.size());
		System.out.println("Manager Id's are:" + setOfMng);
		System.out.println("=======");
	}

	public void findAnswersQ4(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Q4 : how many depts we have and print them ?");
		LinkedHashSet<String> setOfDept = new LinkedHashSet<String>();
		List<WebElement> listOfDept = driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr//td[5]"));
		for (WebElement el : listOfDept) {
			setOfDept.add(el.getText());
		}
		System.out.println("Total Departments in the table are:" + setOfDept.size());
		System.out.println("Different Departments are:" + setOfDept);
		System.out.println("=======");
	}

	public void findAnswersQ5(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Q5: print dept name and number of employees in each dept.");
		LinkedHashMap<String, Integer> deptMap = new LinkedHashMap<String, Integer>();
		List<WebElement> listOfDept = driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr//td[5]"));
		for (WebElement el : listOfDept) {
			String deptName = el.getText();
			if (deptMap.containsKey(deptName)) {
				int count = deptMap.get(deptName) + 1;
				deptMap.put(deptName, count);
			} else {
				deptMap.put(deptName, 1);
			}
		}
		System.out.println("Dept name and number of employees in each dept:" + deptMap);
		System.out.println("=======");
	}

	public void findAnswersQ6(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Q6: print the manager id having maximum employee reporting to him.");
		LinkedHashMap<String, Integer> mngMap = new LinkedHashMap<String, Integer>();
		List<WebElement> listOfMng = driver
				.findElements(By.xpath("//table[@class='table table-striped']//tbody//tr//td[4]"));
		int max = 0;
		String temp = null;
		for (WebElement el : listOfMng) {
			String mngId = el.getText();
			if (mngMap.containsKey(mngId)) {
				int count = mngMap.get(mngId) + 1;
				mngMap.put(mngId, count);
			} else {
				mngMap.put(mngId, 1);
			}
		}
		Set<String> setMng = mngMap.keySet();
		for (String mng : setMng) {
			int tempVar = mngMap.get(mng);
			//System.out.println(mng + " " +tempVar);
			if (tempVar > max) {
				max = tempVar;
				temp = mng;
			}
		}
		System.out.println("Manager Id having maximum employee reporting to him:" + temp + " > " + max);
		driver.close();
	}

	public static void main(String[] args) {
		WebDriver driver = RequiredActions.start();
		 new Emp_Mng_Table().findAnswersQ1(driver);
		 new Emp_Mng_Table().findAnswersQ2(driver);
		 new Emp_Mng_Table().findAnswersQ3(driver);
		 new Emp_Mng_Table().findAnswersQ4(driver);
		 new Emp_Mng_Table().findAnswersQ5(driver);
		 new Emp_Mng_Table().findAnswersQ6(driver);
	}

}
