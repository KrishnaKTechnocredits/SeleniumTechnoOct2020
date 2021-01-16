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
package mrunal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class form {
	
	void radioButton(WebDriver driver) {
		System.out.println("Step: Revert the selection of 'Gender' radio button.");
		WebElement element1 = driver.findElement(By.xpath("//input[@id='maleG']"));
		WebElement element2 = driver.findElement(By.xpath("//input[@id='femaleG']"));
		if (element1.isSelected()) {
			String value = element1.getAttribute("value");
			System.out.println(value + " radio button is preselected");
			System.out.println("Deselecting radio button: " + value);
			element1.click();
			value = element2.getAttribute("value");
			System.out.println("Selecting radio button: " + value);
			element2.click();

		} else if (element2.isSelected()) {
			String value = element2.getAttribute("value");
			System.out.println(value + " radio button is preselected");
			System.out.println("Deselecting radio button: " + value);
			element2.click();
			value = element1.getAttribute("value");
			System.out.println("Selecting radio button: " + value);
			element1.click();
		}

	}

	void checkBox(WebDriver driver) {
		System.out.println("Step: Revert the selection of checkboxes under 'language Wanted to learn");
		WebElement checkboxJava = driver.findElement(By.xpath("//input[@id='java']"));
		String jText = checkboxJava.getAttribute("value");
		WebElement checkboxPython = driver.findElement(By.xpath("//input[@id='python']"));
		String pText = checkboxPython.getAttribute("value");
		WebElement checkboxJavaScript = driver.findElement(By.xpath("//input[@id='javascript']"));
		String jsText = checkboxJavaScript.getAttribute("value");

		checkboxJava.click();
		checkboxPython.click();
		checkboxJavaScript.click();

		if (checkboxJava.isSelected()) {
			System.out.println(jText + " is selected");
		} else
			System.out.println(jText + " is de-selected");

		if (checkboxPython.isSelected()) {
			System.out.println(pText + " is selected");
		} else
			System.out.println(pText + " is de-selected");

		if (checkboxJavaScript.isSelected()) {
			System.out.println(jsText + " is selected");
		} else
			System.out.println(jsText + " is de-selected");
	}

	void selectFromDropdown(WebDriver driver) {
		System.out.println(
				"Step: Select 'Second Last' index from 'I am living in' dropdown and print value of selected option.");
		WebElement element = driver.findElement(By.xpath("//select[@id='continents']"));
		Select oselect = new Select(element);
		List<WebElement> list = oselect.getOptions();
		WebElement selectElement = list.get(list.size() - 2);
		String value = selectElement.getAttribute("value");
		oselect.selectByVisibleText(value);
		System.out.println("Selected value in region picklist= " + value);
	}

	void radioButtonExp(WebDriver driver) {
		System.out.println("Step: Validate 'Total Year's of Experience In Industry' radio button.");

		if (driver.findElement(By.xpath("//input[@id='student']")).isSelected()) {
			System.out.println("Pre-selected option :- Beginner");
		} else if (driver.findElement(By.xpath("//input[@id='beginner']")).isSelected()) {
			System.out.println("Pre-selected option :- Upper Beginner");
		} else if (driver.findElement(By.xpath("//input[@id='entry']")).isSelected()) {
			System.out.println("Pre-selected option :- Intermediate");
		} else if (driver.findElement(By.xpath("//input[@id='intermidiate']")).isSelected()) {
			System.out.println("Pre-selected option :- Advanced");
		} else if (driver.findElement(By.xpath("//input[@id='expert']")).isSelected()) {
			System.out.println("Pre-selected option :- Expert");
		}

	}

	void resetButton(WebDriver driver) {
		System.out.println("Step: Validate Reset functionality of form.");
		System.out.println("Clearing and then entering value in First Name field on the form");
		WebElement element = driver.findElement(By.xpath("//input[@id='first name']"));
		element.clear();
		element.sendKeys("ABBBBBff");
		String value = element.getAttribute("value");
		System.out.println("Click on reset form in same tab button");
		driver.findElement(By.xpath("//input[@id='resetBtn']")).click();
		value = element.getAttribute("value");
		if (value == null || value.equals("")) {
			System.out.println("First Name field value is reset");
		}

	}

	WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///E:/selenium%20videos/First_form_4.html");

		return driver;
	}

	public static void main(String[] args) {
	
		form form4 = new form();
		System.out.println("Opening chrome browser and accessing URL");
		WebDriver driver = form4.start();
		form4.radioButton(driver);
		System.out.println("");
		form4.checkBox(driver);
		System.out.println("");
		form4.selectFromDropdown(driver);
		System.out.println("");
		form4.radioButtonExp(driver);
		System.out.println("");
		form4.resetButton(driver);

		}

	}


