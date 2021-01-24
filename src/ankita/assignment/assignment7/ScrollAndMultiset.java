/*Assignment - 7 : Scroll & MultiSelect

Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.
*/

package ankita.assignment.assignment7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import ankita.base.PredefinedActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ScrollAndMultiset {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = PredefinedActions.start();
		System.out.println("Step : Clicking on Basic element");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");

		System.out.println("Step : select 1 and 3 value in a multi select dropdown");
		WebElement webElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select select = new Select(webElement);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");

		System.out.println("Step : Verify both values get selected");
		List<WebElement> selectedList = select.getAllSelectedOptions();
		List<String> selectedListTxt = new ArrayList<String>(selectedList.size());
		for (WebElement ele : selectedList) {
			selectedListTxt.add(ele.getText());
		}

		String[] expectedList = { "1", "3" };
		List<String> expectedListTxt = Arrays.asList(expectedList);

		if (selectedListTxt.equals(expectedListTxt))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");

		System.out.println("Step : print all options which not selected.");
		List<WebElement> options = select.getOptions();
		options.removeAll(selectedList);
		for (WebElement ele : options)
			System.out.println(ele.getText());

		System.out.println("Step : deselect all selected options.");
		select.deselectAll();

		System.out.println("Step : verify none of the options are selected now.");
		if (select.getAllSelectedOptions().size() == 0)
			System.out.println("Test passed");
		else
			System.out.println("Test failed");

		System.out.println("Step : Closing browser");
		driver.close();

	}
}