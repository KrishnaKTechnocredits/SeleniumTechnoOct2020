package prasad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

/*Assignment - 7 : Scroll & MultiSelect

Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.*/

public class MultiSelectPicklist {
	String selectVal1 = "1", selectVal2 = "3";

	public WebDriver start() {
		System.setProperty("webdriver.chrome.driver", ".//resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		return driver;
	}

	void selectPicklistValues(WebDriver driver) {
		System.out.println("Step 2: Navigating to Basic Elements page");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		System.out.println("Step 3: Scrolling to the multiselect picklist field");
		WebElement element = driver.findElement(By.xpath("//select[@class='form-control']"));

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		
		System.out.println("Step 4: Selecting values 1 & 3 from the multiselect picklist");
		Select oselect = new Select(element);
		oselect.selectByVisibleText(selectVal1);
		oselect.selectByVisibleText(selectVal2);
		System.out.println("Selected values:-");
		java.util.List<WebElement> selectedValues = oselect.getAllSelectedOptions();
		for (WebElement e : selectedValues) {
			String val = e.getAttribute("value");
			System.out.println(val);
		}

		//Fetching all available options/values from multiselect picklist.
		java.util.List<WebElement> allValues = oselect.getOptions();
		//Creating resultant arraylist to store unselected values.
		ArrayList<WebElement> notSelectedValues = new ArrayList();

		Iterator<WebElement> itr = allValues.iterator();
		while (itr.hasNext()) {
			WebElement ele = itr.next();
			if (!ele.getAttribute("value").equals(selectVal1) && !ele.getAttribute("value").equals(selectVal2)) {
				notSelectedValues.add(ele);
			}
		}

		System.out.println("Step 5: Printing unselected values from the multiselect picklist");
		for (WebElement we : notSelectedValues) {
			String value = we.getAttribute("value");
			System.out.println(value);
		}
		
		System.out.println("Step 6: Deselecting options from multiselect picklist");
		oselect.deselectAll();
		selectedValues = oselect.getAllSelectedOptions();
		System.out.println("Number of values currently selected in multiselect picklist " +selectedValues.size() );
		if(selectedValues.size()==0 && notSelectedValues.size()==3) {
			System.out.println("Overall test outcome:- PASSED");
		}
		else
			System.out.println("Overall test outcome:- FAILED");
		
		/*Giving java.util.ConcurrentModificationException
		 * Iterator<WebElement> itr = allValues.iterator(); while (itr.hasNext()) {
		 * WebElement ele = itr.next(); 
		 * if (ele.getAttribute("value").equals(val1) ||
		 * ele.getAttribute("value").equals(val2)) { 
		 * allValues.remove(ele); 
		 * } 
		 * }
		 * System.out.println(allValues.size());
		 */

	}

	public static void main(String[] arg) {
		MultiSelectPicklist multiselect = new MultiSelectPicklist();
		System.out.println("Step 1: Launching chrome browser and accessing URL");
		WebDriver driver = multiselect.start();
		multiselect.selectPicklistValues(driver);
	}
}
