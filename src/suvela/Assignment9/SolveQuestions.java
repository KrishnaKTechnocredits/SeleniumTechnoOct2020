/*Assignment - 9 : 16th Jan'2021  

Q1 : How many rows are there in Employee Basic Information Table.
-->  List<WebElement> listOfRows= driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
     listOfRows.size();

	 
Q2 : print last name of the employee whoes first name is 'Dhara'.
--> 

Q3 - A: print count of columns in the employee Basic Information table.
--> findElements : //table[@id='table1']/thead/tr/th


Q3 - B: print all column name of the employee Basic Information table.
--> List<WebElement> allColumns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
	for(WebElement element : allColumns){
		Sop(element.getText());
	}

Q4: generic function to get column index of any column.
--> int getColIndex(String colName){ // username
		int totolCol = driver.findElements("//table[@id='table1']//th").size();
		for(int colIndex=1;colIndex<=totolCol;colIndex++){
			String currentCol = driver.findElement("//table[@id='table1']//th["+colIndex+"]").getText();
			if(currentCol.equals(colName))
				return colIndex;
		}
		return -1;
	}

Q5 -a : print first row of Employee basic table
--> 
	int temp = 10;
	"Maulik" + temp + "Kanani"
	int totalColumn = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
	for(int index=1;index<=totalColumn;index++){
		String text = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td["+index+"]")).getText();
		sop(text);
	}
	
	
Q5 - b : print all rows of Employee basic table
--> int totolRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

for(int rowIndex=1;rowIndex<=totolRows;rowIndex++){
	int totalColumns = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td")).size();
	for(int colIndex=1;colIndex<=totalColumns;colIndex++){
		String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+rowIndex+"]/td["+colIndex+"]")).getText();
		System.out.print(data + " ");
	}
	System.out.println();
}*/
package suvela.Assignment9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import suvela.basic.RequiredActions;

public class SolveQuestions {
	public void answers(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Q1-How many rows are there in Employee Basic Information Table?");
		driver.findElement(By.linkText("Demo Tables")).click();
		int rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		System.out.println("Total rows in Employee Basic Information Table are : " + rows);
		System.out.println("=========");
		System.out.println("Q2 -Print last name of the employee whoes first name is 'Dhara'");
		String lName = driver.findElement(By.xpath("//td[text()='Dhara']//following-sibling::td[1]")).getText();
		System.out.println("Last name of 'Dhara' is:" + lName);
		System.out.println("=========");
		System.out.println("Q3 - A: print count of columns in the employee Basic Information table.");
		int totalColumns = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		System.out.println("Total rows in Employee Basic Information Table are : " + totalColumns);
		System.out.println("=========");
		System.out.println("Q3 - B: print all column name of the employee Basic Information table.");
		List<WebElement> colHead = driver.findElements(By.xpath("//table[@id='table1']/thead//th"));
		for (WebElement el : colHead) {
			System.out.println("Column Name ->" + el.getText());
		}
		System.out.println("=========");
		System.out.println("Q5 -a : print first row of Employee basic table");
		int totalCols = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		System.out.println("Data of first row is:-");
		for (int rIndex = 1; rIndex <= totalCols; rIndex++) {
			String data = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[" + rIndex + "]"))
					.getText();
			System.out.print(data + " ");
		}
		System.out.println();
		System.out.println("=========");
		System.out.println("Q5 - b : print all rows of Employee basic table");
		System.out.println("Data of all rows :-");
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
		System.out.println("=========");
	}

	public int colIndex(String colName, WebDriver driver) {
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("Q4: generic function to get column index of any column.");
		int totalCols = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		for (int colIndex = 1; colIndex <= totalCols; colIndex++) {
			String currentCol = driver.findElement(By.xpath("//table[@id='table1']/thead//th[" + colIndex + "]"))
					.getText();
			// System.out.println(currentCol);
			if (currentCol.equals(colName)) {
				return colIndex;

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		WebDriver driver = RequiredActions.start();
		new SolveQuestions().answers(driver);
		String colName = "Last Name";
		int index = new SolveQuestions().colIndex(colName, driver);
		System.out.println("Column index of " + colName + " is:" + index);
		driver.close();
	}

}
