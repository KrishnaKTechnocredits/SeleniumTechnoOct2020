package ritika.assignments_1to20;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import technoCredits.base.PredefinedActions;

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
3. Validate text of 'First Name' field again. It should be empty or null.*/

public class Asgmt_04_Form {

	static void formOperations(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("Step - Revert the selection of 'Gender' radio button");
		List<WebElement> list = driver.findElements(By.xpath("//input[@name=\"gender\"]"));
		if (list.get(0).isSelected()) {
			System.out.println(list.get(0).getAttribute("value") + " is default selected");
			list.get(1).click();
			System.out.println("Now " + list.get(1).getAttribute("value") + " has been selected");
		} else if (list.get(1).isSelected()) {
			System.out.println(list.get(1).getAttribute("value") + " is default selected");
			list.get(0).click();
			System.out.println("Now " + list.get(0).getAttribute("value") + " has been selected");
		}
		System.out.println();
		System.out.println("Step - Revert the selection of checkboxes");
		list = driver.findElements(By.xpath("//input[@name=\"language\"]"));
		System.out.println("Selected checkboxes before revert operation");
		for (WebElement ele : list) {
			if (ele.isSelected())
				System.out.println(ele.getAttribute("value") + " ");
			ele.click();
		}
		System.out.println("Selected checkboxes after revert operation");
		for (WebElement ele : list) {
			if (ele.isSelected())
				System.out.println(ele.getAttribute("value") + " ");
		}
		System.out.println();
		System.out.println(
				"Step - Select 'Second Last' index from 'I am living in' dropdown and print value of selected option");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"continents\"]"));
		Select select = new Select(dropdown);
		list = select.getOptions();
		select.selectByIndex(list.size() - 2);
		System.out.println("Selected option is -> " + select.getFirstSelectedOption().getText());
		System.out.println();
		System.out.println("Step - Validate 'Total Years of Experience In Industry' radio button.");
		list = driver.findElements(By.xpath("//input[@name='experience']"));
		for (WebElement ele : list) {
			if (ele.isSelected()) {
				String str = ele.getAttribute("id");
				if (str.equalsIgnoreCase("student"))
					System.out.println("Beginner");
				else if (str.equalsIgnoreCase("beginner"))
					System.out.println("Upper Beginner");
				else if (str.equalsIgnoreCase("entry"))
					System.out.println("Intermediate");
				else if (str.equalsIgnoreCase("intermediate"))
					System.out.println("Advanced");
				else if (str.equalsIgnoreCase("expert"))
					System.out.println("Expert");
			}
		}
		System.out.println();
		System.out.println("Step - Validate Reset functionality of form.");
		WebElement element = driver.findElement(By.id("first name"));
		element.clear();
		element.sendKeys("Ritika");
		System.out.println("First name entered: " + element.getAttribute("value"));
		driver.findElement(By.id("resetBtn")).click();
		if (element.getAttribute("value") == null || element.getAttribute("value").equals(""))
			System.out.println("Form reset successfull");
	}

	public static void main(String[] args) {

		WebDriver driver = PredefinedActions.start(
				"file:///D:/TechnoCredits%20Class%20Oct%202020/Project/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
		formOperations(driver);
		driver.close();
	}
}
