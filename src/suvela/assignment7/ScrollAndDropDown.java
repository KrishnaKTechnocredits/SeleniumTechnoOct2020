package suvela.assignment7;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import technoCredits.base.PredefinedActions;

public class ScrollAndDropDown {
	public void practice(WebDriver driver) {
		System.out.println("Navigate to basic elements");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Scroll down");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)");

		System.out.println("Select values 1 & 3 from multiple dropdown");
		WebElement e = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select oselect = new Select(e);
		oselect.selectByVisibleText("1");
		oselect.selectByVisibleText("3");

		System.out.println("Verify both values get selected");
		List<WebElement> list = oselect.getAllSelectedOptions();
		if (list.size() == 2)
			System.out.println("2 values are selected");
		else if (list.size() == 0)
			System.out.println("No values are selected");

		System.out.println("Print non selected values:");
		List<WebElement> elementlist = oselect.getOptions();
		elementlist.removeAll(list);
		for (WebElement el : elementlist) {
			System.out.println(el.getText());
		}

		System.out.println("Deselect all selected values");
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
		WebDriver driver = PredefinedActions.start("http://automationbykrishna.com/");
		new ScrollAndDropDown().practice(driver);
	}

}
