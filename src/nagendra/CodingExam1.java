package nagendra;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mrunal.loginPage;
import nagendra.base.PredefinedActions;

/*
Selenium Exam - 1 : [complete it by Monday EOD] *
requirement - https://drive.google.com/file/d/1tjKG61d9RniItQL5NHjkYdesxhev0AKE/view?usp=sharing
 Note :  Branch name should be GitUserName_Coding_Exam_1
*/

public class CodingExam1 {
	public static WebDriver driver;

	public static void verifyUserName() {
		boolean flag = true;
		String userName="";
		int totalRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr")).size();
		for (int index = 1; index <= totalRows; index++) {
			 userName = driver.findElement(By.xpath("//table[@id='table1']//tbody//tr[" + index + "]")).getText();
			String rowData[] = userName.split(" ");
			for (int innerLoop = 0; innerLoop < rowData.length; innerLoop++) {
				char fName = rowData[1].charAt(0);
				String lName = rowData[2];
				if (rowData[3] .equalsIgnoreCase(fName + lName)) {
					continue;
				} else {
					flag = false;
					System.out.println("ThE User Name " + rowData[3] + " is not correct");
					break;
				}
			}	}
		
		if (flag)
			System.out.println("All Information is Perfectly Correct!!");
		
	}

	public static void main(String[] args) {
		 driver = PredefinedActions.start("http://automationbykrishna.com/#");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//a[text()='Demo Tables']")).click();
		verifyUserName();
		driver.close();
	}
}
