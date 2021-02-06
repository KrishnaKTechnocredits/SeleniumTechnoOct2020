package nagendra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import nagendra.base.PredefinedActions;

public class MultiSelectDropDown {

	public static WebDriver driver;

	static void verifyDropDownFunctionality() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("STEP - Click on Basic Elements link");
		driver.findElement(By.id("basicelements")).click();
		WebElement webElement = driver.findElement(By.xpath("//select[contains(@class,'form-control')]//following-sibling::select"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", webElement);
		System.out.println("STEP - Select the 1 and 3 Element");
		Select select = new Select(webElement);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");
		System.out.println("STEP - Get All The Selected Item");
		List<WebElement> selectedItem = select.getAllSelectedOptions();
		List<String> selectedListText = new ArrayList<String>(selectedItem.size());
		String[] expected = { "1", "3" };
		List<String> expectedListText = Arrays.asList(expected);
		for (WebElement element : selectedItem) {
			selectedListText.add(element.getText());
		}
		if (selectedListText.equals(expectedListText)) {
			System.out.println("Test1 Passed");
		} else{
			System.out.println("Test1 Failed");
		}
		System.out.println("STEP - Get All The  Item in drop down");
		List<WebElement> notSelectedItem=select.getOptions();
		notSelectedItem.removeAll(selectedItem);
		for (WebElement element : notSelectedItem) {
			System.out.println("Not Selected Items are :"+element.getText());
		}
		System.out.println("STEP - Deselect All the options");
		select.deselectAll();
		System.out.println("STEP - get  All the selected options");
		List<WebElement> itemsSelected = select.getAllSelectedOptions();
		if(itemsSelected.size()==0){
			System.out.println("Total Selected item "+itemsSelected.size());
		}
	}

	public static void main(String[] args) {
		driver = PredefinedActions.start("http://automationbykrishna.com/#");
		verifyDropDownFunctionality();
		System.out.println("STEP - Close The driver");
		driver.close();

	}

}
