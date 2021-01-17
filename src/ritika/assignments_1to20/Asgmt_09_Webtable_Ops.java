package ritika.assignments_1to20;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ritika.base.PredefinedActions;

/*
Q1 : How many rows are there in Employee Basic Information Table.
Q2 : print last name of the employee whose first name is 'Dhara'.
Q3 - A: print count of columns in the employee Basic Information table.
Q3 - B: print all column name of the employee Basic Information table.
Q4:  write a generic function to get column index of any column.
Q5 - A: print first row of Employee basic table
Q5 - B: print all rows of Employee basic table
Q6: print username of all employees.
Q7: print first name and last name of all employees.
Q8: find unique last name from table Employee Basic.
Q9: how many employees (rows) are there after "Dhara".
*/
public class Asgmt_09_Webtable_Ops {

	static int getColIndex(WebDriver driver, String colName) {
		int totalCol = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		for (int colIndex = 1; colIndex <= totalCol; colIndex++) {
			String colText = driver.findElement(By.xpath("//table[@id='table1']//thead//th[" + colIndex + "]")).getText();
			if (colName.equals(colText)) {
				return colIndex;
			}
		}
		return -1;
	}

	static void performWebTableOperations(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Q1 : How many rows are there in Employee Basic Information Table.");
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr"));
		System.out.println("No. of rows in Employee Basic Information Table is -> " + list.size());

		System.out.println();
		System.out.println("Q2 : Print last name of the employee whose first name is 'Dhara'");
		System.out.println("Ans is: "
				+ driver.findElement(By.xpath("//table[@id='table1']//td[(text()='Dhara')]//following-sibling::td[1]"))
						.getText());

		System.out.println();
		System.out.println("Q3_A : print count of columns in the employee Basic Information table.");
		list = driver.findElements(By.xpath("//table[@id='table1']//thead//th"));
		System.out.println("Ans is -> " + list.size());
		System.out.println();
		System.out.println("Q3_B : print all column names of the employee Basic Information table.");
		for (WebElement ele : list) {
			System.out.println(ele.getText());
		}

		System.out.println();
		System.out.println("Q4 : write a generic function to get column index of any column");
		String ColNameToFind = "Username";
		System.out.println("Ans: Column Index of " + ColNameToFind + " is: " + getColIndex(driver, ColNameToFind));

		System.out.println();
		System.out.println("Q5 - A: print first row of Employee basic table");
		System.out.println("Ans: First row of Employee basic table is:");
		int totalCol = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		for (int colIndex = 1; colIndex <= totalCol; colIndex++) {
			String colText = driver.findElement(By.xpath("//table[@id='table1']//thead//th[" + colIndex + "]"))
					.getText();
			System.out.print(colText + "\t");
		}

		System.out.println();
		System.out.println("Q5 - B: print all rows of Employee basic table");
		System.out.println("Ans: All rows of Employee basic table are as below:");
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr")).size();
		totalCol = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			for (int colIndex = 1; colIndex <= totalCol; colIndex++) {
				String colText = driver
						.findElement(
								By.xpath("//table[@id='table1']//tbody//tr[" + rowIndex + "]/td[" + colIndex + "]"))
						.getText();
				System.out.print(colText + " ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("Q6: print username of all employees.");
		System.out.println("Ans is -> Username of all employees are as below:");
		totalRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr")).size();
		ColNameToFind = "Username";
		for (int colIndex = 1; colIndex <= totalCol; colIndex++) {
			String colText = driver.findElement(By.xpath("//table[@id='table1']//thead//th[" + colIndex + "]"))
					.getText();
			if (ColNameToFind.equals(colText)) {
				for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
					String uName = driver
							.findElement(
									By.xpath("//table[@id='table1']//tbody//tr[" + rowIndex + "]/td[" + colIndex + "]"))
							.getText();
					System.out.println(uName + "\t");
				}
			}
		}

		System.out.println();
		System.out.println("Q7: print first name and last name of all employees");
		System.out.println("Ans -> First name and Last name of all employees are as below:");
		int colIndex1 = getColIndex(driver, "First Name");
		int colIndex2 = getColIndex(driver, "Last Name");
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String fName = driver
					.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + rowIndex + "]/td[" + colIndex1 + "]"))
					.getText();
			String lName = driver
					.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + rowIndex + "]/td[" + colIndex2 + "]"))
					.getText();
			System.out.println(fName + " " + lName);
		}

		System.out.println();
		System.out.println("Q8: find unique last name from table Employee Basic.");
		System.out.println("Ans -> Unique last names from table are as below:");
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			String lName = driver
					.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + rowIndex + "]/td[" + colIndex2 + "]"))
					.getText();
			lhs.add(lName);
		}
		for (String str : lhs) {
			System.out.println(str);
		}
		System.out.println();
		System.out.println("Q9: How many employees (rows) are there after \"Dhara\".");
		System.out.println("Ans -> " + driver
				.findElements(By.xpath(
						"//table[@id='table1']//tbody//tr//td[text() = 'Dhara']//parent::tr//following-sibling::tr"))
				.size());
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.findElement(By.id("demotable")).click();
		performWebTableOperations(driver);
		driver.close();
	}
}
