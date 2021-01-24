/*/*Assignment - 7 : Scroll & MultiSelect 
Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.*/
package pooja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_7 {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		System.out.println("Website open successfully.");
		driver.manage().window().maximize();
	}

	static void scrollAndMultiSelectAction() {
		System.out.println("STEP-Go to Basic Element");
		driver.findElement(By.xpath("//a[text()='Basic Elements']")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
		System.out.println("STEP-select 1 and 3 value in a multi select dropdown");
		WebElement webElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(webElement);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");
		System.out.println("STEP-Verify both values Are get selected");
		List<WebElement> selectedList = select.getAllSelectedOptions();
		List<String> selectedListTxt = new ArrayList<String>(selectedList.size());
		for (WebElement ele : selectedList) {
			selectedListTxt.add(ele.getText());
		}
		String[] expectedList = { "1", "3" };
		List<String> expectedListTxt = Arrays.asList(expectedList);
		if (selectedListTxt.equals(expectedListTxt))
			System.out.println("Test Result- Passed");
		else
			System.out.println("Test Result - Failed");
		System.out.println("STEP-Print all options which are not selected.");
		List<WebElement> options = select.getOptions();
		options.removeAll(selectedList);
		for (WebElement ele : options)
			System.out.println(ele.getText());
		System.out.println("STEP-Deselect all selected options.");
		select.deselectAll();
		System.out.println("STEP-Verify none of the options are selected now.");
		if (select.getAllSelectedOptions().size() == 0)
			System.out.println("Test Result -Passed");
		else
			System.out.println("Test Result - Failed");
	}

	public static void main(String[] args) {
		Assignment_7.launchBrowser();
		Assignment_7.scrollAndMultiSelectAction();
		System.out.println("STEP-Closing Browser");
		driver.close();
	}
}
