package nandini.Assignment_9;

import java.util.LinkedHashSet;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import nandini.base.Driver;

public class Table {
	static WebDriver driver;
		
		void demoTable() {
			driver = Driver.start();
			try {
				driver.findElement(By.linkText("Demo Tables")).click();
				System.out.println("Q1: How many rows are there in Employee Basic Information Table.");
				List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
				System.out.println("Answer: " + listOfRows.size());

				System.out.println("\nQ2: print last name of the employee whoes first name is 'Dhara'.");
				WebElement webElement = driver
						.findElement(By.xpath("//table[@id='table1']//td[text()='Dhara']//following-sibling::td[1]"));
				System.out.println("Answer: " + webElement.getText());

				System.out.println("\nQ3 - A: print count of columns in the employee Basic Information table.");
				List<WebElement> listOfColumns = driver.findElements(By.xpath(" //table[@id='table1']//th"));
				System.out.println("Answer: " + listOfColumns.size());

				System.out.println("\nQ3 - B: print all column name of the employee Basic Information table.");
				for (WebElement element : listOfColumns)
					System.out.print(element.getText() + ",");

				System.out.println("\nQ4: generic function to get column index of any column.");
				System.out.println("Answer: " + getColIndex("Last Name"));

				System.out.println("\nQ5 - A: print first row of Employee basic table");
				for (int index = 1; index <= listOfColumns.size(); index++) {
					System.out.print(
							driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[" + index + "]")).getText()
									+ ",");
				}

				System.out.println("\nQ5 - B : print all rows of Employee basic table");
				for (int rowIndex = 1; rowIndex <= listOfRows.size(); rowIndex++) {
					for (int colIndex = 1; colIndex <= listOfColumns.size(); colIndex++) {
						String data = driver
								.findElement(
										By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"))
								.getText();
						System.out.print(data + "\t");
					}
					System.out.println();
				}

				System.out.println("\nQ6: print username of all employees.");
				for (int rowIndex = 1; rowIndex <= listOfRows.size(); rowIndex++) {
					String data = driver
							.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[4]"))
							.getText();
					System.out.print(data + "\t");
				}
				
				System.out.println("\nQ6: print first name and last name of all employees.");
				for (int rowIndex = 1; rowIndex <= listOfRows.size(); rowIndex++) {
					String firstName = driver
							.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[2]"))
							.getText();
					String lastName = driver
							.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[3]"))
							.getText();
					System.out.println(firstName + "\t" + lastName);
				}
				
				System.out.println("\nQ8: find unique last name from table Employee Basic.");
				LinkedHashSet<String> uniqueLastNames = new LinkedHashSet<>();
				for (int rowIndex = 1; rowIndex <= listOfRows.size(); rowIndex++) {
					String lastName = driver
							.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[3]"))
							.getText();
					uniqueLastNames.add(lastName);
				}
				System.out.println(uniqueLastNames);
				
				System.out.println("\nQ9: how many employees (rows) are there after 'Dhara'.");
				System.out.println("Answer: "+driver.findElements(By.xpath("//table[@id='table1']//td[text()='Dhara']//parent::tr//following-sibling::tr")).size());
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				Driver.quit(driver);
			}
		}
	
	public static int getColIndex(String colName) {
		int totolCol = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		for (int colIndex = 1; colIndex <= totolCol; colIndex++) {
			String currentCol = driver.findElement(By.xpath("//table[@id='table1']//th[" + colIndex + "]")).getText();
			if (currentCol.equals(colName))
				return colIndex;
		}
		return -1;
	}
	
	public static void main(String args[]) {
		Table table = new Table();
		table.demoTable();
	}
}
