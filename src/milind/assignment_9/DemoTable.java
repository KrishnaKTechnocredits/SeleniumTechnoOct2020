package milind.assignment_9;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoTable {
	
	WebDriver driver;
	
	void rowCountFromTable() {
		driver = PredefinedActions.start(); 
		System.out.println("STEP : Redirect to demo table");
		driver.findElement(By.xpath("//a[@id = 'demotable']")).click();
		System.out.println("STEP : Find row count of Employee basic information");
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println(rowCount.size());
	}
	
	void lastNameOfEmployee(String userName) {
		System.out.println("STEP : Find " +userName+" In employee basic information table");
		String userLastName = driver.findElement(By.xpath("//table[@id='table1']//td[text()='"+userName+"']/following-sibling::td[1]")).getText();
		System.out.println(userLastName);
	}
	
	void countOfColumn() {
		System.out.println("STEP : Column count of employee basic information table");
		int columnCount = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		System.out.println(columnCount);
	}
	
	void printAllColumnName() {
		System.out.println("STEP : Column name of employee basic information table");
		List<WebElement> tableHeader = driver.findElements(By.xpath("//table[@id='table1']//th"));
		for(WebElement element: tableHeader) {
			System.out.println(element.getText());
		}
	}
	
	void getColumnIndex(String columnName) {
		System.out.println("STEP : Search column index");
		List<WebElement> tableHeader = driver.findElements(By.xpath("//table[@id='table1']//th"));
		int columnIndex = 0;
		System.out.println("Find column name index");
		for(int index = 0; index < tableHeader.size(); index++) {
			if(tableHeader.get(index).getText().equals(columnName)) {
				columnIndex = index;
				System.out.println(columnName +" : "+ columnIndex);
			}
		}
	}
	
	void printFirstRow() {
		System.out.println("STEP : Get First row of Employee basic information table");
		int firstRowDataCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td")).size();
		for(int index = 1; index <= firstRowDataCount; index++) {
			String firstRowData = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td["+index+"]")).getText();
			System.out.print(firstRowData + " ");
		}
		System.out.println("");
	}
	
	void printAllRow() {
		System.out.println("STEP : Get number of rows from table");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index = 1; index <= rowCount; index++) {
			int columnCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td")).size();
			for(int innerIndex = 1; innerIndex <= columnCount; innerIndex++) {
				String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td["+innerIndex+"]")).getText();
				System.out.print( data + " ");
			}
			System.out.println("");
		}
	}
	
	int columnIndex(String columnName) {
		int columnSizeInTable = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		for(int index = 1; index <= columnSizeInTable; index++) {
			if(driver.findElement(By.xpath("//table[@id='table1']//th["+index+"]")).getText().equals(columnName)) {
				return index;
			}
		}
		return -1;
	}
	
	void printUserNameOfEmployee() {
		
		System.out.println("STEP : Find Index of UserName");
		int userNameIndex = columnIndex("Username");
		
		System.out.println("STEP : Get row count of table");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td["+userNameIndex+"]")).size();
		for(int index = 1; index <= rowCount; index++) {
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td["+userNameIndex+"]")).getText();
			System.out.println(userName);
		}
	}
	
	void printFirstNameAndLastName() {
		System.out.println("STEP : Find index of First name");
		int firstNameIndex = columnIndex("First Name");
		System.out.println("STEP : find index of Last name");
		int lastNameIndex = columnIndex("Last Name");
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for(int index = 1; index <= rowCount; index++) {
			String fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td["+firstNameIndex+"]")).getText();
			String lname = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td["+lastNameIndex+"]")).getText();
			System.out.println("First Name : " + fName + " Last name : " + lname);
		}
	}
	
	void printUniqueLastName() {
		System.out.println("STEP : Find all Last name from table");
		List<WebElement> lastNameElement = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		HashSet<String> uniqueLastName = new HashSet<String>();;
		for(WebElement element: lastNameElement) {
			uniqueLastName.add(element.getText());
		}
		System.out.println("Unique last Name : ");
		System.out.println(uniqueLastName);
	}
	
	void rowCountAfterUserName(String userName) {
		int rowCountAfterUserName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[text() = '"+userName+"']//parent::tr//following-sibling::tr")).size();
		System.out.println("Row Count after "+userName+" : " + rowCountAfterUserName);
	}
	
	public static void main(String[] args) {
		DemoTable demoTable = new DemoTable();
		demoTable.rowCountFromTable();
		demoTable.lastNameOfEmployee("Dhara");
		demoTable.countOfColumn();
		demoTable.printAllColumnName();
		demoTable.getColumnIndex("Last Name");
		demoTable.printFirstRow();
		demoTable.printAllRow();
		demoTable.printUserNameOfEmployee();
		demoTable.printFirstNameAndLastName();
		demoTable.printUniqueLastName();
		demoTable.rowCountAfterUserName("Krishna");
		demoTable.driver.close();
	}

}
