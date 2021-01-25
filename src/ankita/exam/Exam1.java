package ankita.exam;

import java.util.Arrays;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ankita.base.PredefinedActions;

public class Exam1 {

	static void checkUserName(WebDriver driver) {
		driver.findElement(By.linkText("Demo Tables")).click();
		int rowsCnt = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		String[] arr = new String[rowsCnt];
		int cnt = 0;
		for (int i = 1; i <= rowsCnt; i++) {
			String firstName = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + i + "]//td[2]"))
					.getText();
			String lastName = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + i + "]//td[3]"))
					.getText();
			String userName = driver.findElement(By.xpath("//table[@id='table1']/tbody//tr[" + i + "]//td[4]"))
					.getText();
			String expectedUserName = firstName.toLowerCase().charAt(0) + lastName.toLowerCase();
			if (!expectedUserName.equals(userName)) {
				arr[cnt++] = userName;
			}
		}
		if (cnt > 0)
			System.out.println("Wrong UserName " + Arrays.toString(arr));
		else
			System.out.println("Test Passed : All username are correct");
	}

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		checkUserName(driver);
		System.out.println("Step : Closing Browser");
		driver.close();
	}
}