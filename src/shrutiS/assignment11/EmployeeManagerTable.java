package shrutiS.assignment11;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import shrutiS.base.LauchBrowser;

public class EmployeeManagerTable {
	static WebDriver driver;

	static void handleEmployeeTable(WebDriver driver) {
		driver.findElement(By.linkText("Demo Tables")).click();

		System.out.println("Q1) how many rows are there in the table ?");
		System.out.println(
				"Answer ; " + driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size());
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Q2) how many employees are there in the table ?");
		List<WebElement> listOfEmpName = driver.findElements(By.xpath("//table[@class='table table-striped']//td[3]"));
		Set<String> empNames = new LinkedHashSet<String>();
		for (WebElement name : listOfEmpName) {
			empNames.add(name.getText());
		}
		System.out.println("Ans : " + empNames.size());
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Q3 : how many managers we have and print them?");
		List<WebElement> listOFMngID = driver.findElements(By.xpath("//table[@class='table table-striped']//td[4]"));
		Set<String> mngId = new LinkedHashSet<String>();
		for (WebElement eleemnt : listOFMngID) {
			mngId.add(eleemnt.getText());
		}
		System.out.println("Ans :" + mngId.size());
		System.out.println(mngId);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Q4 : how many depts we have and print them ?");
		List<WebElement> listOfDept = driver.findElements(By.xpath("//table[@class='table table-striped']//td[5]"));
		Set<String> deptName = new LinkedHashSet<String>();
		for (WebElement element : listOfDept) {
			deptName.add(element.getText());
		}
		System.out.println("Ans : " + deptName.size());
		System.out.println(deptName);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Q5: print dept name and number of employees in each dept.");
		Map<String, Integer> deptEmpMp = new LinkedHashMap<String, Integer>();
		for (WebElement element : listOfDept) {
			String text = element.getText();
			if (deptEmpMp.containsKey(text)) {
				deptEmpMp.put(text, deptEmpMp.get(text) + 1);
			} else
				deptEmpMp.put(text, 1);
		}
		System.out.println(deptEmpMp);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Q6: print the manager id having maximum employee reporting to him.");
		Map<String, Integer> mngEmpMp = new LinkedHashMap<String, Integer>();
		for (WebElement element : listOFMngID) {
			if (mngEmpMp.containsKey(element.getText())) {
				mngEmpMp.put(element.getText(), mngEmpMp.get(element.getText()) + 1);
			} else
				mngEmpMp.put(element.getText(), 1);
		}
		System.out.println(mngEmpMp);
		int max = 0;
		String keyMax = "";
		for (String key : mngEmpMp.keySet()) {
			if (mngEmpMp.get(key) > max) {
				max = mngEmpMp.get(key);
				keyMax = key;
			}
		}
		System.out.println(keyMax + " " + max + " reporting employee");
	}

	public static void main(String[] args) {
		driver = LauchBrowser.start("http://automationbykrishna.com/");
		handleEmployeeTable(driver);
		driver.close();
	}
}
