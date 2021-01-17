package raghvendra.Table;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import raghvendra.base.ConstantAction;

/*Assignment - 9 : 16th Jan'2021  

Q1 : How many rows are there in Employee Basic Information Table.
Q2 : print last name of the employee whoes first name is 'Dhara'.
Q3 - A: print count of columns in the employee Basic Information table.
Q3 - B: print all column name of the employee Basic Information table.
Q4: generic function to get column index of any column.
Q5 -a : print first row of Employee basic table
Q5 - b : print all rows of Employee basic table
Q6: print username of all employees.
Q7: print first name and last name of all employees.
Q8: find unique last name from table Employee Basic.
Q9: how many employees (rows) are there after "Dhara".*/
public class FindTableValues {
		WebDriver driver=ConstantAction.url();
		void allQuestionsAnswer() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Launch http://automationbykrishna.com/#");	
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		System.out.println("Open Demo Tables screen");
		List<WebElement> listOfElemnt=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Number of rows in Employee Basic Information Table:"+listOfElemnt.size());
		String LastDhara=driver.findElement(By.xpath("//table[@id='table1']//td[text()='Dhara']/following-sibling::td[1]")).getText();
		System.out.println(LastDhara+" is last name of the employee whoes first name is 'Dhara'");
		listOfElemnt=driver.findElements(By.xpath("//table[@id='table1']//th"));
		System.out.println("Number of Columns in the employee Basic Information table: "+listOfElemnt.size());
		System.out.println("Column names of the employee Basic Information table:");
		for(WebElement element : listOfElemnt){
			System.out.print(element.getText()+" ");
		}
		System.out.println("\n"+"Column Index of column Last Name is: "+findColumnIndexTable("Last Name"));
		listOfElemnt=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
		System.out.println("First row of Employee basic table");
		for(WebElement element : listOfElemnt){
			System.out.print(element.getText()+" ");
		}
	}
	void displayAllRows() {
		int totalRows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int totalColumn=driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		for(int rows=1;rows<=totalRows;rows++) {
			System.out.println();
			for(int column=1;column<=totalColumn;column++) {
				String data=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rows+"]/td["+column+"]")).getText();
				System.out.print(data+" ");
			}
		}

	}
	void displayUserName(String ColummnName) {
		int totalRows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columIndex=findColumnIndexTable(ColummnName);
		for(int rows=1;rows<=totalRows;rows++) {
			String data=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rows+"]/td["+columIndex+"]")).getText();
			System.out.print(data+" ");
		}
	}
	void displayFirstLastName(String first,String last) {
		int totalRows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columIndexFirst=findColumnIndexTable(first);
		int columIndexLast=findColumnIndexTable(last);
		for(int rows=1;rows<=totalRows;rows++) {
			String firstName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rows+"]/td["+columIndexFirst+"]")).getText();
			String lastName=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rows+"]/td["+columIndexLast+"]")).getText();
			System.out.println(firstName+" "+lastName);
		}
	}
	void displayUniqueName(String ColummnName) {
		int totalRows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columIndex=findColumnIndexTable(ColummnName);
		LinkedHashSet<String>set=new LinkedHashSet<String>();
		for(int rows=1;rows<=totalRows;rows++) {
			String data=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rows+"]/td["+columIndex+"]")).getText();
			set.add(data);
		}
		System.out.println(set);
	}
	int numberOfRowsAfterFirstName(String firstName) {
		int totalRows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		int columnIndex=findColumnIndexTable("First Name");
		int index=0;
		for(index=1;index<=totalRows;index++) {
			String name=driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td["+columnIndex+"]")).getText();
			if(name.equals(firstName)) {
				break;
			}
		}
		return totalRows-index;
	}
	int findColumnIndexTable(String colName) {
		int totalColumn=driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		for(int index=1;index<=totalColumn;index++) {
			String currentColumn=driver.findElement(By.xpath("//table[@id='table1']//th["+index+"]")).getText();
			if(colName.equals(currentColumn))
				return index;
		}
		return -1;
	}
	public static void main(String[] args) {
		FindTableValues findTableValues=new FindTableValues();
		findTableValues.allQuestionsAnswer();
		System.out.println("\n"+"Display All rows data of Employee basic table");
		findTableValues.displayAllRows();
		System.out.println("\n"+"User Name of All employee");
		findTableValues.displayUserName("Username");
		System.out.println("\n"+"First name and last name of all employees");
		findTableValues.displayFirstLastName("First Name","Last Name");
		System.out.println("Unique Last name of employees from Employee basic table");
		findTableValues.displayUniqueName("Last Name");
		System.out.println("Employees (rows)after Dhara are: "+findTableValues.numberOfRowsAfterFirstName("Dhara"));
	}

}
