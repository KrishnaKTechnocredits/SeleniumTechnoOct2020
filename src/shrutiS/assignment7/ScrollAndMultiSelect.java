/*Assignment - 7 : Scroll & MultiSelect 

Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.*/
package shrutiS.assignment7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ScrollAndMultiSelect {
	static WebDriver driver;

	static void start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		System.out.println("AutomationByKrishna website open successfully");
	}

	public void validateScrollAndDropdown() {
		System.out.println("Step1: Click on basic elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)");

		System.out.println("Step2: Select values 1 & 3 from multiple dropdown");
		WebElement e = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select oselect = new Select(e);
		oselect.selectByVisibleText("1");
		oselect.selectByVisibleText("3");

		System.out.println("Step3: Verify both values get selected");
		List<WebElement> list = oselect.getAllSelectedOptions();
		if (list.size() == 2)
			System.out.println("2 values are selected");
		else if (list.size() == 0)
			System.out.println("No values are selected");

		System.out.println("Step4: Print non selected values:");
		List<WebElement> elementlist = oselect.getOptions();
		elementlist.removeAll(list);
		for (WebElement el : elementlist) {
			System.out.println(el.getText());
		}
		System.out.println("Step5: Deselect all selected values");
		oselect.deselectByVisibleText("1");
		oselect.deselectByVisibleText("3");
		List<WebElement> nonselect = oselect.getAllSelectedOptions();
		if (nonselect.size() == 0)
			System.out.println("No options are selected now");
		else
			System.out.println("Elements are still selected");
		driver.close();
	}

	public static void main(String[] args) {
		ScrollAndMultiSelect scrollAndSelect = new ScrollAndMultiSelect();
		start();
		scrollAndSelect.validateScrollAndDropdown();
	}
}
