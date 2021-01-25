package suvela.exams;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import suvela.basic.RequiredActions;

public class Exam1 {

	public void compareStrings(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		int totalRow = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
		for (int index = 1; index <= totalRow; index++) {
			String fName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[2]"))
					.getText();
			String lName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[3]"))
					.getText();
			String convertToLower= fName.toLowerCase();
			char c = convertToLower.charAt(0);
			String singleChar = Character.toString(c);
			String lNameToLower= lName.toLowerCase();
			String expectedUserName = singleChar.concat(lNameToLower);
			String actualUserName = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + index + "]/td[4]"))
					.getText();
			if (expectedUserName.equals(actualUserName))
				System.out.println("UserName is Correct! >> ExpectedUserName is:" + expectedUserName
						+ " >> ActualUserName is:" + actualUserName);

			else
				System.out.println(
						"UserName is Incorrect! >> ExpectedUserName is:"+expectedUserName + " >> ActualUserName is:"+actualUserName);

		}
		driver.close();
	}

	public static void main(String[] args) {
		WebDriver driver = RequiredActions.start();
		new Exam1().compareStrings(driver);
	}

}
