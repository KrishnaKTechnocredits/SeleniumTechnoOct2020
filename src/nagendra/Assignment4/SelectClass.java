package nagendra.Assignment4;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import nagendra.base.PredefinedActions;

/*Assignment - 4 [Form : /resources/forms/First_Form_4] 
a) Revert the selection of 'Gender' radio button.
	Example: If 'Male' is preselected then select 'Female'.
			 If 'Female' is preselected then select 'Male'.	 
b) Revert the selection of checkboxes under 'language Wanted to learn'
	Example: Whatever language is selected in checkboxes, please uncheck those 
			 & Select unchecked checkboxes		 
c) Select 'Second Last' index from 'I am living in' dropdown and print value of selected option.
	Note: This is dynamic dropdown. Options may get changed in future. So don't search it by name. 
		  We want second last index in any situation	  
d) Validate 'Total Year's of Experience In Industry' radio button.
	Print message like below based on preselected experience radio button. 
	1. Student -> print 'Beginner'
	2. 1-3 -> print 'Upper Beginner'
	3. 3-6 -> print 'Intermediate'
	4. 6-10 -> print 'Advanced'
	5. Above 10 -> print 'Expert'
e) Validate Reset functionality of form.
	1. Type something in 'First Name'. Validate text of this field.
	2. Click on 'Reset form in same tab' button.
	3. Validate text of 'First Name' field again. It should be empty or null.
*/

public class SelectClass {

	public static WebDriver driver;

	public static void revertTheSelectionOfGenderRadioButton() {
		System.out.println("Revert the selection of 'Gender' radio button");
		List<WebElement> radioButton = driver.findElements(By.xpath("//div//label//following-sibling::input"));
		for (WebElement element : radioButton) {
			if (!element.isSelected()) {
				System.out.println("Not Selected Radiob Button is :" + element.getAttribute("value"));
				System.out.println("STEP-Select the unselected radio Button");
				element.click();
				System.out.println("is Radion button " + element + " Button Selected ->" + element.isSelected());
			}
		}
	}

	public static void revertLanguageWantedToLearn() {
		System.out.println("Revert the selection of checkboxes under language Wanted to learn");
		List<WebElement> checkckBox = driver.findElements(By.xpath(
				"//b[text()='language Wanted to learn']//parent::label//following-sibling::input[@name='language']"));
		System.out.println("STEP-Checked the Unchecked Checkbox and Unchecked The Checked Checkboxes");
		for (WebElement check : checkckBox) {
			check.click();
		}
	}

	public static void selectSecondLastOptionFromDropDown() {
		System.out.println("Select 'Second Last' index from 'I am living in' dropdown and print value of selected option.");
		Select option = new Select(driver.findElement(By.xpath("//select[@id='continents']")));
		List<WebElement> list = option.getOptions();
		System.out.println("STEP-Select The Second Last Option from dropdown");
		option.selectByIndex(list.size() - 2);
		List<WebElement> selectedOpiont = option.getAllSelectedOptions();
		for (WebElement selected : selectedOpiont) {
			System.out.println("Selected Option is -->" + selected.getText());
		}
	}
	
	public static void printSelectedRadioButtonMessage(){
		System.out.println("Print message like below based on preselected experience radio button");
		List<WebElement> element=driver.findElements(By.xpath("//b[contains(text(),'Experience In Industry')]//following::input[@name='experience']"));
		for(WebElement list:element){
			if(list.isSelected()){
				System.out.println("Message on Preselected Radio Button is"+list.getAttribute("id"));
			}
		}
	}

	public static void verifyResetFunctionality(){
		System.out.println("Validate Reset functionality of form.");
		WebElement element=driver.findElement(By.id("first name"));
		System.out.println("Type Name in First Name Element field ");
		element.sendKeys("Nagendra");
		if (element.getAttribute("value").equals("Nagendra")) {
			System.out.println("Clicking on form reset button");
			driver.findElement(By.id("resetBtn")).click();
			System.out.println("Validating text of 'First Name' field. It should be null or empty.");
			String text = element.getAttribute("value");
			if (text == null || text.length() == 0)
				System.out.println("Passed");
			else
				System.out.println("Failed");
		}
	}
	public static void main(String[] args) {
		driver = PredefinedActions.start(
				"file:///C:/Users/Nagendra/Documents/Training/Training/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
		verifyResetFunctionality();
		System.out.println("STEP-Close The driver");
		driver.close();
		System.out.println("STEP- Test Completed");
	}
}
