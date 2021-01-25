package milind.Exam1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserNameValidation {
	
	WebDriver driver;
	void verifyUserName() {
		driver = PredefinedActions.start();
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		int rowCount = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		List<Character> firstNameFirstLetter = new ArrayList<Character>();
		List<String> lastFullName = new ArrayList<String>();
		for(int index = 1; index <= rowCount; index++) {
			firstNameFirstLetter.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[2]")).getText().charAt(0));
			lastFullName.add(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+index+"]/td[3]")).getText().toLowerCase());
		}
		for(int index = 0; index < rowCount; index++) {
			String expectedUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+(index+1)+"]/td[4]")).getText();
			String actualUserName = Character.toLowerCase(firstNameFirstLetter.get(index)) + lastFullName.get(index);
			System.out.println(expectedUserName + " : " + actualUserName);
			if(expectedUserName.equals(actualUserName)) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
		}
	}

	public static void main(String[] args) {
		UserNameValidation userNameValidation = new UserNameValidation();
		userNameValidation.verifyUserName();
		userNameValidation.driver.close();
	}

}
