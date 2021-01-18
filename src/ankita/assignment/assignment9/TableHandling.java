package ankita.assignment.assignment9;

import ankita.base.PredefinedActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class TableHandling {

	static int findColumnIndex(WebDriver driver, String colName) {
		int size = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		int colIndex = 0;
		for (int i = 1; i <= size; i++) {
			if (colName.equals(driver.findElement(By.xpath("//table[@id='table1']//th[" + i + "]")).getText()))
				colIndex = i;
		}
		return colIndex;
	}

	public static void handleTable(WebDriver driver) {
		driver.findElement(By.xpath("//a[@id='demotable']")).click();

		System.out.println("Step : Q1 : How many rows are there in Employee Basic Information Table");
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Ans :" + listOfRows.size());

		System.out.println("Step : Q2 : print last name of the employee whoes first name is 'Dhara'.");
		String suraname = driver
				.findElement(By.xpath("//table[@id='table1']//td[text()='Dhara']//following-sibling::td[1]")).getText();
		System.out.println("Surname:" + suraname);

		System.out.println("Step : Q3 - A: print count of columns in the employee Basic Information table");
		List<WebElement> listOfCols = driver.findElements(By.xpath("//table[@id='table1']//th"));
		System.out.println("Ans : " + listOfCols.size());

		System.out.println("Step : Q3 - B: print all column name of the employee Basic Information table");
		for (WebElement element : listOfCols) {
			System.out.println(element.getText());
		}

		System.out.println("Step : Q4 - generic function to get column index of any column.");

		System.out.println("Step : Q5 -a : print first row of Employee basic table");
		int headerCnt = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		for (int i = 1; i <= headerCnt; i++) {
			System.out
					.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[1]/td[" + i + "]")).getText());
		}

		System.out.println("Step : Q5 -b : print all rows of Employee basic table");
		int rowsCnt = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int i = 1; i <= rowsCnt; i++) {
			for (int j = 1; j <= headerCnt; j++) {
				System.out.print(" " + driver
						.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText());
			}
			System.out.println();
		}

		System.out.println("Step : Q6: print username of all employees.");
		for (int i = 1; i <= rowsCnt; i++)
			System.out.print(" " + driver
					.findElement(By.xpath(
							"//table[@id='table1']//tr[" + i + "]//td[" + findColumnIndex(driver, "Username") + "]"))
					.getText());
		System.out.println();

		System.out.println("Step : Q7: print first name and last name of all employees.");
		int firstNameColIndex = findColumnIndex(driver, "First Name");
		int lastNameColIndex = findColumnIndex(driver, "Last Name");

		for (int i = 1; i <= rowsCnt; i++) {
			System.out.print(
					driver.findElement(By.xpath("//table[@id='table1']//tr[" + i + "]/td[" + firstNameColIndex + "]"))
							.getText() + " ");
			System.out.println(
					driver.findElement(By.xpath("//table[@id='table1']//tr[" + i + "]/td[" + lastNameColIndex + "]"))
							.getText() + " ");
		}

		System.out.println("Step : Q8: find unique last name from table Employee Basic");
		List<WebElement> listOfLastName = driver.findElements(By.xpath("//table[@id='table1']//tr/td[3]"));
		Set<String> set = new LinkedHashSet<String>();
		for (WebElement element : listOfLastName) {
			set.add(element.getText());
		}
		System.out.println(set);

		System.out.println("Step : Q9: how many employees (rows) are there after Dhara");
		int index = 0;
		for (int i = 1; i <= rowsCnt; i++) {
			if (driver
					.findElement(By.xpath(
							"//table[@id='table1']//tr[" + i + "]/td[" + findColumnIndex(driver, "First Name") + "]"))
					.getText().equals("Dhara")) {
				index = i;
				break;
			}
		}
		System.out.println("Employees after Dhara present are :" + (rowsCnt - index));
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		handleTable(driver);
		System.out.println("Step : Closing browser");
		driver.close();
	}
}