package ritika.assignments_1to20;

/* Scroll & MultiSelect
Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.*/

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ritika.base.PredefinedActions;

public class Asgmt_07 {
	static WebDriver driver;

	static void multiSelectDropdown() {
		WebElement multiSelectDD = driver.findElement(By.xpath("//select[@class ='form-control']"));
		Select dropdown = new Select(multiSelectDD);
		dropdown.selectByVisibleText("1");
		dropdown.selectByIndex(2);
		List<WebElement> allOptions = dropdown.getOptions();
		System.out.println("List of options not selected:");
		for (WebElement element : allOptions) {
			if (!element.isSelected())
				System.out.println(element.getText());
			else {
				if (element.getText().equals("1") || element.getText().equals("3"))
					continue;
			}
		}
		System.out.println("All expected values are selected");
		dropdown.deselectAll();
		List<WebElement> selectedOptions = dropdown.getAllSelectedOptions();
		if (selectedOptions.size() == 0)
			System.out.println("All options are deselected now");
	}

	public static void main(String[] args) {
		driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Basic Elements")).click();
		multiSelectDropdown();
		driver.close();
	}
}
