package nandini.Assignment_11;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import nandini.base.Driver;

public class EmpMngTable {

	 void handleTable() {

		WebDriver driver = Driver.start();
		try {
			driver.findElement(By.linkText("Demo Tables")).click();

			System.out.println("Q1 : how many rows are there in the table ?");
			List<WebElement> listOfRows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr"));
			System.out.println("Answer: " + listOfRows.size());

			System.out.println("\nQ2 : how many employees are there in the table ?");
			List<WebElement> listOfEmpRows = driver.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[2]"));
			Set<String> setOfEmployeeId = new LinkedHashSet<>();
			for (WebElement webElement : listOfEmpRows) {
				setOfEmployeeId.add(webElement.getText());
			}
			System.out.println("Answer: " + setOfEmployeeId.size());

			System.out.println("\nQ3 : how many managers we have  and print them?");
			List<WebElement> listOfManagersRows = driver
					.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[4]"));
			Set<String> setOfManagerId = new LinkedHashSet<>();
			for (WebElement webElement : listOfManagersRows) {
				setOfManagerId.add(webElement.getText());
			}
			System.out.println("Answer: " + setOfManagerId.size());
			System.out.println(setOfManagerId);

			System.out.println("\nQ4 : how many depts we have and print them ?");
			List<WebElement> listOfDepartmentRows = driver
					.findElements(By.xpath("//div[@id='empmanager']//tbody/tr/td[5]"));
			Set<String> setOfDepartment = new LinkedHashSet<>();
			for (WebElement webElement : listOfDepartmentRows) {
				setOfDepartment.add(webElement.getText());
			}
			System.out.println("Answer: " + setOfDepartment.size());
			System.out.println(setOfDepartment);

			System.out.println("\nQ5: print dept name and number of employees in each dept.");
			Map<String, Integer> mapOfDepartmant = new LinkedHashMap<>();
			for (WebElement webElement : listOfDepartmentRows) {
				String text = webElement.getText();
				if (mapOfDepartmant.containsKey(text))
					mapOfDepartmant.put(text, mapOfDepartmant.get(text) + 1);
				else
					mapOfDepartmant.put(text, 1);
			}
			System.out.println(mapOfDepartmant);

			System.out.println("\nQ6: print the manager id having maximum employee reporting to him.");
			Map<String, Integer> mapOfManager = new LinkedHashMap<>();
			for (WebElement webElement : listOfManagersRows) {
				String text = webElement.getText();
				if (mapOfManager.containsKey(text))
					mapOfManager.put(text, mapOfManager.get(text) + 1);
				else
					mapOfManager.put(text, 1);
			}
			int max = 0;
			String maxKey = null;
			for (String key : mapOfManager.keySet()) {
				if (mapOfManager.get(key) > max) {
					max = mapOfManager.get(key);
					maxKey = key;
				}
			}
			System.out.println(maxKey + " --> " + mapOfManager.get(maxKey));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}
	 
	public static void main(String args[]) {
		EmpMngTable empmngtbl = new EmpMngTable();
		empmngtbl.handleTable();	
	}
}
