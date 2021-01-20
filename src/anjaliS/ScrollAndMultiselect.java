package anjaliS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import brijesh.base.Driver;

public class ScrollAndMultiselect {

	void isSelected() {
		WebDriver driver = Driver.start();
		System.out.println("Clicked on basic elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,750)");

		System.out.println("Value 1 and 3 is selected from multi select dropdown");
		WebElement webElement = driver.findElement(By.xpath("//select[@multiple='']"));
		Select select = new Select(webElement);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");

		System.out.println("Verify both values get selected");
		List<WebElement> list = select.getAllSelectedOptions();
		List<String> listSelected = new ArrayList<String>(list.size());
		for (WebElement ele : list) {
			listSelected.add(ele.getText());
		}

		String[] expectedList = { "1", "3" };
		List<String> expectedListText = Arrays.asList(expectedList);

		if (listSelected.equals(expectedListText))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");

		System.out.println("Print all options which has not been selected.");
		List<WebElement> options = select.getOptions();
		options.removeAll(list);
		for (WebElement ele : options)
			System.out.println(ele.getText());

		System.out.println("Deselected all the selected options.");
		select.deselectAll();

		System.out.println("Step : verify none of the options are selected now.");
		if (select.getAllSelectedOptions().size() == 0)
			System.out.println("Test passed");
		else
			System.out.println("Test failed");

		driver.close();
	}

	public static void main(String args[]) {
		ScrollAndMultiselect handler = new ScrollAndMultiselect();
		handler.isSelected();

	}
}
