package raghvendra;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import raghvendra.base.ConstantAction;

/*Assignment : 10  -> Naukri.com [@Brijesh  or @Harsh please share requirement] 


Assignment : 11 [Complete it before Monday EOD] 

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


Selenium Exam - 1 : [complete it by Monday EOD] *
requirement - https://drive.google.com/file/d/1tjKG61d9RniItQL5NHjkYdesxhev0AKE/view?usp=sharing

 Note :  Branch name should be GitUserName_Coding_Exam_1
for example - BrijeshG_Coding_Exam_1 */
public class Assignment11_EmployeeManager {
	WebDriver driver=ConstantAction.url();
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
		Assignment11_EmployeeManager assignment11=new Assignment11_EmployeeManager();
		assignment11.EmployeeManager();
		assignment11.findTotlaManager();
		assignment11.printDept();
		assignment11.printDeptEmployee();
		assignment11.printMaxEmp();
	}
}
