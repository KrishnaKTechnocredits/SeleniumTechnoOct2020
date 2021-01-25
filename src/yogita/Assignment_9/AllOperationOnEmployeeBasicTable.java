package yogita.Assignment_9;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllOperationOnEmployeeBasicTable {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Website open successfully.");
		driver.manage().window().maximize();
		System.out.println("STEP-Finding DemoTable");
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	static void findAllColumnName() {
		List<WebElement> totalColumn = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
		System.out.println("Total No Of Columns are:" + totalColumn.size());
		for (WebElement element : totalColumn) {
			System.out.println(element.getText());
		}

	}

	static void findAllRowsInfo() {
		int totalNoOfRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr")).size();
		System.out.println("All Row Information\n");
		for (int i = 1; i <= totalNoOfRows; i++) {
			int totalNoOfCol = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[" + i + "]//td")).size();
			for (int index = 1; index <= totalNoOfCol; index++) {
				String info = driver
						.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + i + "]//td[" + index + "]"))
						.getText();
				System.out.print(info + " ");
			}
			System.out.println();
		}
	}

	static void findFirstRow() {
		int totalNoOfCol = driver.findElements(By.xpath("//table[@id='table1']//th")).size();
		for (int i = 1; i <= totalNoOfCol; i++) {
			String data = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[1]//td[" + i + "]")).getText();
			System.out.print(data + " ");
		}
	}

	static void findHowManyRowsInEmployeeBasicTable() throws InterruptedException {
		List<WebElement> listOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		int sizeOfRows = listOfRows.size();
		System.out.println("Total Rows:" + sizeOfRows);

	}

	static void findLastName() {
		String lastName = driver.findElement(By.xpath("//td[text()='Dhara']//following-sibling::td[1]")).getText();
		System.out.println("Last name of 'Dhara' is:" + lastName);
	}

	static int findColIndex(String colName) {
		driver.findElement(By.linkText("Demo Tables")).click();
		int totalCols = driver.findElements(By.xpath("//table[@id='table1']/thead//th")).size();
		for (int colIndex = 1; colIndex <= totalCols; colIndex++) {
			String currentCol = driver.findElement(By.xpath("//table[@id='table1']/thead//th[" + colIndex + "]"))
					.getText();
			if (currentCol.equals(colName))
				return colIndex;
		}
		return -1;
	}

	static void findUserNameOfAll() {

		int totalRow = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr")).size();
		for (int i = 1; i < totalRow; i++) {
			String text = driver.findElement(By.xpath("//table[@id='table1']//tbody/tr[" + i + "]//td[4]")).getText();
			System.out.println(text + " ");
		}

	}

	public static void main(String[] args) {
		AllOperationOnEmployeeBasicTable.launchBrowser();
		System.out.println("\n"+"Display Toatal No.Of columns");
		AllOperationOnEmployeeBasicTable.findAllColumnName();
		System.out.println("-----------------------------------------------------");
		System.out.println("\n" + "Display All rows data of Employee basic table");
		AllOperationOnEmployeeBasicTable.findAllRowsInfo();
		System.out.println("-----------------------------------------------------");
		System.out.println("\n" + "Display First row data of Employee basic table");
		AllOperationOnEmployeeBasicTable.findFirstRow();
		System.out.println("\n-----------------------------------------------------");
		System.out.println("\n" + "\nDisplay UserName From Employee basic table");
		AllOperationOnEmployeeBasicTable.findUserNameOfAll();
		System.out.println("-----------------------------------------------------");
		System.out.println("\n" + "Display All Column Name from Employee basic table");
		String colName = "First Name";
		System.out.println("\n" + "Get column index of any column.");
		int colIndex = AllOperationOnEmployeeBasicTable.findColIndex(colName);
		System.out.println("Column Index is:" + colIndex);
		System.out.println("-----------------------------------------------------");
		System.out.println("\n" + "Display Last Name of Employee whose First name is 'Dhara'");
		AllOperationOnEmployeeBasicTable.findLastName();
		driver.close();

	}

}
