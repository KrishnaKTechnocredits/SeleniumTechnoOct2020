package shrutiS.assignment9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shrutiS.base.LauchBrowser;
import suvela.Assignment9.SolveQuestions;

public class DemoTable {

	static WebDriver driver;

	public void QuesAndAnswer(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Q1-How many rows are there in Employee Basic Information Table?");
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int rows = listOfRows.size();
		System.out.println("Total rows in Employee Basic Information Table are : " + rows);
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Q2 -Print last name of the employee whoes first name is 'Dhara'");
		String lastName = driver.findElement(By.xpath("//td[text()='Dhara']//following-sibling::td[1]")).getText();
		System.out.println("Last name of 'Dhara' is:" + lastName);
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Q3 - A: print count of columns in the employee Basic Information table.");
		int totalColumns = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		System.out.println("Total columns in Employee Basic Information Table are : " + totalColumns);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Q3  - B: print all column name of the employee Basic Information table.");
		List<WebElement> allColumns = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
		for (WebElement element : allColumns) {
			System.out.println("Column Name ->" + element.getText());
		}
		System.out
				.println("------------------------------------------------------------------------------------------");
		System.out.println("Q4 -a : print first row of Employee basic table");
		int totalCols = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		System.out.println("Data of first row ");
		for (int rIndex = 1; rIndex <= totalCols; rIndex++) {
			String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[" + rIndex + "]"))
					.getText();
			System.out.print(data + " ");
		}
		System.out.println();
		System.out
				.println("-------------------------------------------------------------------------------------------");
		System.out.println("Q4 - b : print all rows of Employee basic table");
		System.out.println("Data of all rows");
		int totalColmns = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			for (int colIndex = 1; colIndex <= totalColmns; colIndex++) {
				String text = driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"))
						.getText();
				System.out.print(text + " ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------------------------------------------------");
	}

	public int getColIndex(String colName, WebDriver driver) {
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Q5: generic function to get column index of any column.");
		int totalCols = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		for (int colIndex = 1; colIndex <= totalCols; colIndex++) {
			String currentCol = driver.findElement(By.xpath("//table[@id='table1']/thead//th[" + colIndex + "]"))
					.getText();
			if (currentCol.equals(colName))
				return colIndex;
		}
		return -1;
	}

	public static void main(String[] args) {
		driver = LauchBrowser.start("http://automationbykrishna.com/");
		new DemoTable().QuesAndAnswer(driver);
		String colName = "Last Name";
		int index = new DemoTable().getColIndex(colName, driver);
		System.out.println("Column index of " + colName + " is:" + index);
		driver.close();
	}
}
