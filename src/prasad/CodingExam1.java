package prasad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CodingExam1 {
	String uName, fname, lName, temp;
	char fch;
	int count;

	void validateID(WebDriver driver) {
		driver.findElement(By.linkText("Demo Tables")).click();
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id= 'table1']/thead/tr/th"));
		int noOfCol = columns.size();

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id= 'table1']/tbody/tr"));
		for (int rowIndex = 1; rowIndex <= rows.size(); rowIndex++) {
			for (int colIndex = 2; colIndex <= noOfCol; colIndex++) {
				WebElement element = driver.findElement(
						By.xpath("//table[@id= 'table1']/tbody/tr[" + rowIndex + "]/td[" + colIndex + "]"));

				if (colIndex == 2) {
					fname = element.getText();
					fch = fname.charAt(0);
				} else if (colIndex == 3) {
					lName = element.getText();
				} else if (colIndex == 4) {
					uName = element.getText();
				}

			}
			temp = fch + lName;
			if (temp.equalsIgnoreCase(uName)) {
				count++;
			}
		}
		if (count == 5) {
			System.out.println("PASS : All user names are in correct format:- username = 1st char of FirstName+LastName");
		}
		else
			System.out.println("FAIL: Not all user names are in correct format");
	}

	public static void main(String[] arg) {
		CodingExam1 exam = new CodingExam1();
		WebDriver driver = StaticResources.start();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		System.out.println("Step 1: Validating all user names in the data table");
		exam.validateID(driver);
	}

}
