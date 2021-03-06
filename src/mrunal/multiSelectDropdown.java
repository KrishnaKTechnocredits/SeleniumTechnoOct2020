/*Assignment - 7 : Scroll & MultiSelect
Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.*/
package mrunal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class multiSelectDropdown {

	WebDriver driver = PredefinedActions.start();

	void selectValueFromDropdown() {
		System.out.println("STEP : Adding Implicit Wait");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("STEP : Redirect to basic element page");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP : Scroll By Element");
		WebElement multiDropdownElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", multiDropdownElement);
		System.out.println("STEP : Select Value from multi select dropdown");
		Select select = new Select(multiDropdownElement);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");
		System.out.println("STEP : Verify selected option");
		List<WebElement> selectedOptionFromDropdown = select.getAllSelectedOptions();
		if(selectedOptionFromDropdown.size()==2) {
			if(selectedOptionFromDropdown.get(0).getText().equals("1") && selectedOptionFromDropdown.get(1).getText().equals("3")) {
				System.out.println("You get correct option as selected");
			}else {
				System.out.println("Your selection is worng");
			}
		}else {
			System.out.println("You have selected more than 2 options");
		}
		System.out.println("Refresh the page");
		driver.navigate().refresh();

	}

	void printAllDeselectedOption() {
		System.out.println("STEP : Adding Implicit Wait");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("STEP : Redirect to basic element page");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Scroll the web page upto element");
		WebElement multiDropdownElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", multiDropdownElement);
		System.out.println("STEP : Select Value from multi select dropdown");
		Select select = new Select(multiDropdownElement);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");
		System.out.println("Get all option of dropdown");
		List<WebElement> allOptionFromDropdown = select.getOptions();
		System.out.println("Get all selected option form dropdown");
		List<WebElement> allSelectedOption = select.getAllSelectedOptions();
		System.out.println("Remeove selected option from all option");
		allOptionFromDropdown.remove(allSelectedOption.get(0));
		allOptionFromDropdown.remove(allSelectedOption.get(1));
		for(WebElement element: allOptionFromDropdown) {
			System.out.println(element.getText());
		}
		System.out.println("Refresh the page");
		driver.navigate().refresh();
	}

	void deselectAllDeselectedOption() {
		System.out.println("STEP : Adding Implicit Wait");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("STEP : Redirect to basic element page");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("Scroll the web page upto element");
		WebElement multiDropdownElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", multiDropdownElement);
		System.out.println("STEP : Select Value from multi select dropdown");
		Select select = new Select(multiDropdownElement);
		select.selectByVisibleText("1");
		select.selectByVisibleText("3");
		System.out.println("STEP : Deselect the selected option");
		select.deselectAll();
		System.out.println("STEP : Verify No option is selected");
		if(select.getAllSelectedOptions().isEmpty()) {
			System.out.println("All option get deselected");
		}else {
			System.out.println("Still some option are selected please deselect it");
		}
	}

	public static void main(String[] args) {
		multiSelectDropdown MultiSelectDropdown = new multiSelectDropdown();
		MultiSelectDropdown.selectValueFromDropdown();
		MultiSelectDropdown.printAllDeselectedOption();
		MultiSelectDropdown.deselectAllDeselectedOption();
		MultiSelectDropdown.driver.close();
	}

}