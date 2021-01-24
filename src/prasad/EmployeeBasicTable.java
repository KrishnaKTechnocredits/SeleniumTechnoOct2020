package prasad;

import java.awt.List;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
/*Assignment 9:-*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeBasicTable {
	String fName = "Dhara";
	String tableHeader = "//table[@id='table1']/thead/tr/th";
	int totalFirstNames;

	int findTablerows(WebDriver driver) {
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		java.util.List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
		int noOfRows = tableRows.size();
		return noOfRows;
	}

	String findLastName(WebDriver driver) {

		WebElement emp = driver
				.findElement(By.xpath("//table[@id='table1']//td[text()='" + fName + "']//following-sibling::td[1]"));
		String lName = emp.getText();
		return lName;
	}

	int countOfColumns(WebDriver driver) {
		java.util.List<WebElement> columnsOfTable = driver.findElements(By.xpath(tableHeader));
		int countOfColumns = columnsOfTable.size();
		return countOfColumns;
	}

	String printAllColumnNames(WebDriver driver) {
		String columnNames = "";
		java.util.List<WebElement> columnsOfTable = driver.findElements(By.xpath(tableHeader));
		for (WebElement e : columnsOfTable) {
			columnNames += "   " + e.getText();
		}

		return columnNames;
	}

	int columnIndex(String name, WebDriver driver) {
		java.util.List<WebElement> listOfCol = driver.findElements(By.xpath(tableHeader));
		int columnIndex = 0;
		while (columnIndex < listOfCol.size()) {
			String str = listOfCol.get(columnIndex).getText();
			if (str.equalsIgnoreCase(name)) {
				return columnIndex + 1;
			}
			columnIndex++;
		}

		return -1;
	}

	void printFirstRow(WebDriver driver) {
		java.util.List<WebElement> ColHeaderNames = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		for (WebElement element : ColHeaderNames) {
			System.out.print(element.getText() + " ");
		}
		System.out.println("");
		java.util.List<WebElement> firstRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[1]/td"));
		for (WebElement element : firstRow) {
			System.out.print(element.getText() + "   ");
		}
	}

	void printingAllRows(WebDriver driver) {
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int rowCount = 1; rowCount <= totalRows; rowCount++) {
			int totalCols = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[" + rowCount + "]/td")).size();
			for (int colCount = 1; colCount <= totalCols; colCount++) {
				System.out.print(driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowCount + "]/td[" + colCount + "]"))
						.getText() + "  ");
			}
			System.out.println("");
		}
	}

	void printUserNames(WebDriver driver) {
		int totalUserNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]")).size();
		for (int index = 1; index <= totalUserNames; index++) {
			System.out.println(
					driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]")).getText());
		}
	}

	void firstLastName(WebDriver driver) {
		totalFirstNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]")).size();
		System.out.println("First Names:-");
		for (int index = 1; index <= totalFirstNames; index++) {
			System.out.println(
					driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]")).getText());
		}
		int totalLasttNames = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]")).size();
		System.out.println("Last Names:-");
		for (int index = 1; index <= totalLasttNames; index++) {
			System.out.println(
					driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]")).getText());
		}
	}

	void uniqueLastName(WebDriver driver) {
		java.util.List<WebElement> lastName = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		LinkedHashSet<String> uniqueLastNames = new LinkedHashSet<String>();

		for (WebElement element : lastName) {
			uniqueLastNames.add(element.getText());
		}

		for (String str : uniqueLastNames) {
			System.out.println(str);
		}

	}

	int countRows(WebDriver driver, String fName) {
		int refRowCount = 0;
		java.util.List<WebElement> listOfFnames = driver
				.findElements(By.xpath("//table[@id='table1']//tbody/tr/td[2]"));
		for (int index = 0; index <= totalFirstNames; index++) {
			WebElement element = listOfFnames.get(index);
			String str = element.getText();
			if (str.equals(fName)) {
				refRowCount = index + 1;
				break;
			}
		}
		int precedingRows = driver
				.findElements(By.xpath("//table[@id='table1']//tbody/tr[" + refRowCount + "]//following-sibling::tr"))
				.size();

		return precedingRows;
	}

	public static void main(String[] arg) {
		EmployeeBasicTable basictable = new EmployeeBasicTable();
		Scanner scanner = new Scanner(System.in);
		WebDriver driver = StaticResources.start();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Step 1:- Finding number of rows in Employee Basic Information table");
		int noOfRows = basictable.findTablerows(driver);
		System.out.println("Total number of rows in Employee Basic Information table:- " + noOfRows);
		System.out.println("");
		System.out.println("Step 2:- Finding last name of emp whose first name is " + basictable.fName);
		String lName = basictable.findLastName(driver);
		System.out.println("Last name:- " + lName);
		System.out.println("");
		System.out.println("Step 3:- Printing count of columns in the employee Basic Information table");
		int countOfColumns = basictable.countOfColumns(driver);
		System.out.println("Number of columns:- " + countOfColumns);
		System.out.println("");
		System.out.println("Step 4:- Printing column names of employee Basic Information table");
		String columnNames = basictable.printAllColumnNames(driver);
		System.out.println(columnNames);
		System.out.println("");
		System.out.println("Step 5:- Please enter column name to get column index");
		String colName = scanner.nextLine();
		int colIndex = basictable.columnIndex(colName, driver);
		if (colIndex > -1) {
			System.out.println("Column index: " + colIndex);
		} else
			System.out.println("Incorrect column name entered!");
		System.out.println("");
		System.out.println("Step 6:- Printing first row of employee basic table");
		basictable.printFirstRow(driver);
		System.out.println("");
		System.out.println("Step 7:- Printing all the rows of employee basic table");
		basictable.printingAllRows(driver);
		System.out.println("");
		System.out.println("Step 8:- Printing user name of all employees");
		basictable.printUserNames(driver);
		System.out.println("");
		System.out.println("Step 9:- Printing all first name and last name");
		basictable.firstLastName(driver);
		System.out.println("");
		System.out.println("Step 10:- Printing all unique last names from employee table");
		basictable.uniqueLastName(driver);
		System.out.println("");
		System.out.println("Step 11:- Printing number of rows after name " + basictable.fName);
		int precedingRows = basictable.countRows(driver, basictable.fName);
		System.out.println("Number of employees after " + basictable.fName + " = " + precedingRows);
	}

}
