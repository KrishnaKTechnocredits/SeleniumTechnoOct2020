package deepak.assignment9;

import java.awt.List;
import java.util.LinkedHashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import deepak.methods.UtilityMethods;

public class Assignment_9 {

	static WebDriver driver;
	
	
	public static void getColumnIndex(java.util.List<WebElement>headersList, String columnName) {
		
		for(int i=0 ; i<headersList.size(); i++) {
			
			if(columnName.equals(headersList.get(i).getText())) {
				
				System.out.println("Index of "+ columnName + " is"+ i);
			}
		}
			
	}
	
	public static void main(String[] args) {
		
		driver = UtilityMethods.start();
		
		System.out.println("Q1 : How many rows are there in Employee Basic Information Table?");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		java.util.List<WebElement> rowsInEmpBasicInfoTable = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
		System.out.println("Ans: Total number of rows in Employee Basic Information Table are: "+ rowsInEmpBasicInfoTable.size());
		
		System.out.println("\nQ2 : print last name of the employee whoes first name is 'Dhara'?");
		String dharaLastName = driver.findElement(By.xpath("//table[@id='table1']//td[text()='Dhara']//following-sibling::td[1]")).getText();
		System.out.println("Ans: Dharas last name is: "+ dharaLastName);
		
		System.out.println("\nQ3 - A: print count of columns in the employee Basic Information table?");
		java.util.List<WebElement> headersList = driver.findElements(By.xpath("//table[@id='table1']//thead//th"));
		int headerCount = headersList.size();
		System.out.println("Total number of columns are: "+ headerCount);
		
		System.out.println("\nQ3 - B: print all column name of the employee Basic Information table?");
		for(WebElement element : headersList) {
			
			String columnName = element.getText();
			System.out.println(columnName);
		}
		
		System.out.println("\nQ4: Generic function to get column index of any column?");
		getColumnIndex(headersList,"Last Name");
		
		System.out.println("\nQ5 -a : print first row of Employee basic table?");
		WebElement firstRow = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[1]"));
		System.out.println(firstRow.getText());
		
		System.out.println("\nQ5 - b : print all rows of Employee basic table");
		java.util.List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
		
		for(int i=1; i<=rows.size(); i++) {
			String rowText = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+ i +"]")).getText();
			System.out.println(rowText);
		}
		
		System.out.println("\nQ6: print username of all employees?");
		for(int i=1; i<=rows.size(); i++) {
			
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[4]")).getText();
			System.out.println(userName);
		}
		
		System.out.println("\nQ7: print first name and last name of all employees?");
		for(int i=1; i<=rows.size(); i++) {
			
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[2]")).getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println(firstName +"\t"+ lastName);
		}
		
		System.out.println("\nQ8: find unique last name from table Employee Basic?");
		
		LinkedHashSet<String> uniqueLastNames = new LinkedHashSet<>();
		for (int i=1; i <= rows.size(); i++) {
			String lastName = driver
					.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[3]"))
					.getText();
			uniqueLastNames.add(lastName);
		}
		System.out.println(uniqueLastNames);
		
		System.out.println("\nQ9: how many employees (rows) are there after Dhara?");
		java.util.List<WebElement> empListAfterDhara = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[text()='Dhara']//parent::tr//following-sibling::tr"));
		System.out.println("Number of Employees after Dhara: "+ empListAfterDhara.size());
		
		driver.close();
	}

}
