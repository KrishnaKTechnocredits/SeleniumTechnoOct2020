package prasad;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

public class EmpManager {
	int maxFreq, value;
	String key;

	void searchAndPrintData(WebDriver driver, String path) {
		List<WebElement> temp = driver.findElements(By.xpath(path));
		HashSet<String> hSet = new HashSet<String>();
		for (WebElement element : temp) {
			String str = element.getText();
			hSet.add(str);
		}
		System.out.println(hSet.size());
		System.out.println("");
		for (String str : hSet) {
			System.out.println(str);
		}
	}

	HashMap<String, Integer> getKeyVal(List<WebElement> tempList, WebDriver driver) {
		HashMap<String, Integer> keyVal = new HashMap();
		for (WebElement element : tempList) {
			String key = element.getText();
			if (keyVal.containsKey(key)) {
				int value = keyVal.get(key);
				keyVal.put(key, value + 1);
			} else
				keyVal.put(key, 1);
		}

		return keyVal;
	}

	void scanTable(WebDriver driver) {
		driver.findElement(By.linkText("Demo Tables")).click();
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class = 'table table-striped']//tbody/tr"));
		System.out.println("Step 1: Number of rows in Employee Manager table");
		System.out.println(tableRows.size());
		System.out.println("");

		System.out.println("Step 2: Number of employees in Employee Manager table");
		searchAndPrintData(driver, "//table[@class='table table-striped']/tbody/tr/td[2]");
		System.out.println("");

		System.out.println("Step 3: Number of managers in Employee Manager table");
		searchAndPrintData(driver, "//table[@class='table table-striped']/tbody/tr/td[4]");

		System.out.println("");
		System.out.println("Step 4: Number of departments in Employee Manager table");
		searchAndPrintData(driver, "//table[@class='table table-striped']/tbody/tr/td[5]");

		System.out.println("");
		System.out.println("Step 5: Printing dept name and number of employees in each dept");
		List<WebElement> dept = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[5]"));
		HashMap<String, Integer> deptEmp = new HashMap<String, Integer>();
		deptEmp = getKeyVal(dept, driver);
		for (Entry<String, Integer> e : deptEmp.entrySet()) {
			String key = e.getKey();
			int value = e.getValue();
			System.out.println(key + " : " + value);
		}
		System.out.println("");
		System.out.println("Step 6: Printing the manager id having maximum employee reporting to him");
		List<WebElement> mngId = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr/td[4]"));
		HashMap<String, Integer> maxMng = new HashMap<String, Integer>();
		maxMng = getKeyVal(mngId, driver);
		for (Entry<String, Integer> entry : maxMng.entrySet()) {
			if (entry.getValue() > maxFreq) {
				value = entry.getValue();
				maxFreq = value;
				key = entry.getKey();
			}
		}
		System.out.println(key + " : " + value);
	}

	public static void main(String[] arg) {
		EmpManager eManager = new EmpManager();
		WebDriver driver = StaticResources.start();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		eManager.scanTable(driver);
	}
}
