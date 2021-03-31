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
package shrutiS.assignment4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstForm {
	static WebDriver driver;

	public static void start() throws InterruptedException {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("E:\\SeleniumOCT20\\SeleniumTechnoOct2020\\resources\\forms\\First_Form_4.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	public void ValidateForm() {

		System.out.println("Program1: Revert selection of gender radio button");
		WebElement element = driver.findElement(By.xpath("//input[@name='gender' and @value='male']"));
		if (element.isSelected())
			driver.findElement(By.xpath("//input[@name='gender' and @value='female']")).click();
		else
			element.click();
		System.out.println("Test Passed");

		System.out.println("\nProgram2: Revert the selection of checkboxes under 'language Wanted to learn'");
		List<WebElement> elements = driver.findElements(By.xpath("//input[@name='language']"));
		for (WebElement webElement : elements) {
			webElement.click();
		}
		System.out.println("Test Passed");

		System.out.println(
				"\nProgram3: Select 'Second Last' index from 'I am living in' dropdown and print value of selected option.");
		element = driver.findElement(By.id("continents"));
		Select select = new Select(element);
		elements = select.getOptions();
		select.selectByIndex(elements.size() - 2);
		WebElement option = select.getFirstSelectedOption();
		System.out.println("Step: Selected value from dropdown " + option.getText());
		System.out.println("Test Passed");

		System.out.println("\nProgram4: Validate 'Total Year's of Experience In Industry' radio button.");
		elements = driver.findElements(By.name("experience"));
		for (WebElement webElement : elements) {
			if (webElement.isSelected())
				System.out.println("Step: " + webElement.getAttribute("id") + " selected");
		}
		System.out.println("Test Passed");

		System.out.println("\nProgram5: Validate Reset functionality of form.");
		System.out.println("Type name in First Name field");
		element = driver.findElement(By.id("first name"));
		element.sendKeys("Shruti");
		if (element.getAttribute("value").equals("Shruti")) {
			System.out.println("Clicking on form reset button");
			driver.findElement(By.id("resetBtn")).click();
			System.out.println("Validating text of 'First Name' field. It should be null or empty.");
			String text = element.getAttribute("value");
			if (text == null || text.length() == 0)
				System.out.println("Test Passed");
			else
				System.out.println("Test Failed");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		FirstForm form = new FirstForm();
		start();
		form.ValidateForm();
	}
}
