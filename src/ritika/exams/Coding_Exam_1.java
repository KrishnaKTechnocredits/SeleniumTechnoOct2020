package ritika.exams;

//Que - Validate all usernames are valid in Employee Basic Table 

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ritika.base.PredefinedActions;

public class Coding_Exam_1 {

	static WebDriver driver;

	static void validateUsernames() {
		List<WebElement> listOfFirstNames = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[2]"));
		List<WebElement> listOfLastNames = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[3]"));
		List<WebElement> listOfUsernames = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[4]"));

		for (int index = 0; index < listOfUsernames.size(); index++) {
			char fNameChar = Character.toLowerCase(listOfFirstNames.get(index).getText().charAt(0));
			String lName = listOfLastNames.get(index).getText().toLowerCase();
			String uName = listOfUsernames.get(index).getText().toLowerCase();
			String validUserName = fNameChar + lName;
			if (uName.equals(validUserName))
				System.out.println(uName + " username is Valid");
			else
				System.out.println(uName + " username is not Valid");
		}
	}

	public static void main(String[] args) {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("demotable")).click();
		validateUsernames();
		driver.close();
	}

}
