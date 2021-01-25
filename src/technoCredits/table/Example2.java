package technoCredits.table;

import java.util.HashMap;
import java.util.HashSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import technoCredits.base.PredefinedActions;

public class Example2 {
	
	public static void main(String[] args) {
		System.out.println("STEP - Launch Browser & URL");
		WebDriver driver = PredefinedActions.start();
		System.out.println("STEP - Navigate to Demo Tables");
		driver.findElement(By.cssSelector("a#demotable")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#empmanager")));
		
		int totalRows = driver.findElements(By.cssSelector("#empmanager tbody>tr")).size();
		HashMap<String,Integer> empDeptCountMap = new HashMap<String,Integer>();
		HashSet<String> setOfEmpName = new HashSet<String>();
		
		for(int index=1;index<=totalRows;index++) {
			String deptName = driver.findElement(By.cssSelector("div#empmanager tbody>tr:nth-of-type("+index+")>td:nth-of-type(5)")).getText();
			String empName = driver.findElement(By.cssSelector("div#empmanager tbody>tr:nth-of-type("+index+")>td:nth-of-type(3)")).getText();
			if(empDeptCountMap.containsKey(deptName)) {
				if(setOfEmpName.add(empName))
					empDeptCountMap.put(deptName, empDeptCountMap.get(deptName)+1);
			}else {
				empDeptCountMap.put(deptName, 1);
				setOfEmpName.add(empName);
			}
		}
		System.out.println(empDeptCountMap);
		
	}
}
