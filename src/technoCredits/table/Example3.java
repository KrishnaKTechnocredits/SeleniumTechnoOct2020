package technoCredits.table;

import java.util.HashMap;
import java.util.LinkedHashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technoCredits.base.PredefinedActions;

public class Example3 {
	
	public static void main(String[] args) {
		System.out.println("STEP - Launch Browser & URL");
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP - Navigate to Demo Tables");
		driver.findElement(By.cssSelector("a#demotable")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#empmanager")));
		
		int totalRows = driver.findElements(By.cssSelector("#empmanager tbody>tr")).size();
		HashMap<String,LinkedHashSet<String>> empDeptCountMap = new HashMap<String,LinkedHashSet<String>>();
		
		for(int index=1;index<=totalRows;index++) {
			String deptName = driver.findElement(By.cssSelector("div#empmanager tbody>tr:nth-of-type("+index+")>td:nth-of-type(5)")).getText();
			String empName = driver.findElement(By.cssSelector("div#empmanager tbody>tr:nth-of-type("+index+")>td:nth-of-type(3)")).getText();
			if(empDeptCountMap.containsKey(deptName)) {
					LinkedHashSet<String> hs = empDeptCountMap.get(deptName);
					//HashSet<String> hs = new HashSet<String>();
					hs.add(empName);
					empDeptCountMap.put(deptName, hs);
			}else {
				LinkedHashSet<String> hs = new LinkedHashSet<String>();
				hs.add(empName);
				empDeptCountMap.put(deptName, hs);
			}
		}
		System.out.println(empDeptCountMap);
		
	}
}
