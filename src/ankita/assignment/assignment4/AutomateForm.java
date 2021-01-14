/*

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

package ankita.assignment.assignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import ankita.base.PredefinedActions;

public class AutomateForm {
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions
				.start("H:\\JAVA selenium\\Selenium\\SeleniumTechnoOct2020\\resources\\forms\\First_Form_4.html");
		System.out.println(" ==========Program 1 ============");
		WebElement element1 = driver.findElement(By.xpath("//input[@name='gender' and @value='male']"));
		if (element1.isSelected())
			driver.findElement(By.xpath("//input[@id='femaleG']")).click();
		else
			element1.click();
		System.out.println("Test Passed");

		System.out.println(" ==========Program  2 ============");
		List<WebElement> element2 = driver.findElements(By.xpath("//input[@name='language']"));
		for (WebElement ele : element2)
			ele.click();
		System.out.println("Test Passed");

		System.out.println(" ==========Program  3 ============");
		element1 = driver.findElement(By.xpath("//select[@id='continents']"));
		Select select = new Select(element1);
		element2 = select.getOptions();
		select.selectByIndex(element2.size() - 2);
		WebElement option = select.getFirstSelectedOption();
		System.out.println("Selected Value : " + option.getText());
		System.out.println("Test Passed");

		System.out.println(" ==========Program  4 ============");
		element2 = driver.findElements(By.xpath("//input[@id='experience']"));
		for (WebElement ele : element2) {
			if (ele.isSelected())
				System.out.println(ele.getAttribute("id") + "Selected");

		}
		System.out.println("Test passed");

		System.out.println(" ==========Program  5 ============");
		System.out.println("Step : Entering First Name");
		element1 = driver.findElement(By.xpath("//input[@id='first name']"));
		element1.sendKeys("Ankita");
		if (element1.getAttribute("value").equals("Ankita")) {
			System.out.println("Step : Clicking on reset");
			driver.findElement(By.xpath("//input[@id='resetBtn']")).click();
			System.out.println("Step : Check page");
			String currentMsg = element1.getAttribute("value");
			if (currentMsg == null || currentMsg.length() == 0)
				System.out.println("Test passed");
			else
				System.out.println("Test Failed");
		}
		driver.close();
	}
}
