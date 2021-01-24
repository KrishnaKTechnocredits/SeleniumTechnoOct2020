package nandini.Assignment7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import nandini.base.*;

public class MultiSelectDrpDown {
	
	void MultiDrpDown() {
		
		WebDriver driver = Driver.start();
		try {
			System.out.println("Step: Click on Basic Elements link");
			driver.findElement(By.linkText("Basic Elements")).click();

			System.out.println("Step: select 1 and 3 value in a multi select dropdown");
			WebElement webElement = driver.findElement(By.xpath("//select[@multiple='']"));
			Select select = new Select(webElement);
			select.selectByVisibleText("1");
			select.selectByVisibleText("3");

			System.out.println("Step: Verify both values get selected");
			List<WebElement> selectedList = select.getAllSelectedOptions();
			List<String> selectedListText = new ArrayList<String>(selectedList.size());
			String[] expected = { "1", "3" };
			List<String> expectedListText = Arrays.asList(expected);
			for (WebElement element : selectedList) {
				selectedListText.add(element.getText());
			}
			if (selectedListText.equals(expectedListText)) {
				System.out.println("Test1 Passed");
			} else
				System.out.println("Test1 Failed");

			System.out.println("Step: print all options which not selected");
			List<WebElement> allOptions = select.getOptions();
			allOptions.removeAll(selectedList);
			for (WebElement element : allOptions) {
				System.out.println(element.getText());
			}

			System.out.println("Step: deselect all selected options");
			select.deselectAll();

			System.out.println("Step: verify none of the options are selected now.");
			if (select.getAllSelectedOptions().size() == 0)
				System.out.println("Test2 Passed");
			else
				System.out.println("Test2 Failed");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Driver.quit(driver);
		}
	}
	
	public static void main(String args[]) {
		MultiSelectDrpDown multiDrpDownOption = new MultiSelectDrpDown();
		multiDrpDownOption.MultiDrpDown();
	}

}
