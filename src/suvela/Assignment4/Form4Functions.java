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
package suvela.Assignment4;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import suvela.basic.RequiredActions;

public class Form4Functions {
	public void checkGenderRadioButton(WebDriver driver) {
		System.out.println("=======Method 1========");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Check if Gender - Male is selected or not");
		boolean flag = driver.findElement(By.xpath("//input[@id='maleG']")).isSelected();

		if (flag) {
			System.out.println("Check if Gender - Male is selected if yes click on Gender-Female");
			driver.findElement(By.xpath("//input[@id='femaleG']")).click();
			System.out.println("Female is selected now");
		} else {
			System.out.println("Check if Gender - Female is selected if yes click on Gender-male");
			driver.findElement(By.xpath("//input[@id='maleG']")).click();
			System.out.println("Male is selected now");
		}
		System.out.println("Script run successfully!");

	}

	public void checkBoxButton(WebDriver driver) {
		System.out.println("=======Method 2========");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Check which language is preselected");
		boolean flag1 = driver.findElement(By.xpath("//input[@id='java']")).isSelected();
		boolean flag2 = driver.findElement(By.xpath("//input[@id='python']")).isSelected();
		boolean flag3 = driver.findElement(By.xpath("//input[@id='javascript']")).isSelected();

		if (flag1) {
			System.out.println(driver.findElement(By.xpath("//input[@id='python']")).getAttribute("value") + " is selected");
			System.out.println("Uncheck java option And Check python & javascript option");
			driver.findElement(By.xpath("//input[@id='java']")).click();
			driver.findElement(By.xpath("//input[@id='python']")).click();
			driver.findElement(By.xpath("//input[@id='javascript']")).click();
		}
		if (flag2) {
			System.out.println(driver.findElement(By.xpath("//input[@id='python']")).getAttribute("value") + " is selected");
			System.out.println("Uncheck python option And Check java & javascript option");
			driver.findElement(By.xpath("//input[@id='java']")).click();
			driver.findElement(By.xpath("//input[@id='python']")).click();
			driver.findElement(By.xpath("//input[@id='javascript']")).click();
		}
		if (flag3) {
			System.out.println(driver.findElement(By.xpath("//input[@id='javascript']")).getAttribute("value") + " is selected");
			System.out.println("Uncheck javascript option And Check python & java option");
			driver.findElement(By.xpath("//input[@id='java']")).click();
			driver.findElement(By.xpath("//input[@id='python']")).click();
			driver.findElement(By.xpath("//input[@id='javascript']")).click();
		}
		System.out.println("Script run successfully!");

	}

	public void secondLastIndexDropDown(WebDriver driver) {
		System.out.println("=======Method 3========");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Get second last index value from Drop down");
		WebElement element = driver.findElement(By.xpath("//select[@id='continents']"));
		Select select = new Select(element);
		List<WebElement> list = select.getOptions();
		select.selectByIndex(list.size() - 2);
		System.out.println("Selected option is :" + select.getFirstSelectedOption().getText());
		System.out.println("Script run successfully!");

	}

	public void yearExpRadioButton(WebDriver driver) {
		System.out.println("=======Method 4========");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Check the experience level from the displayed radio buttons");
		if (driver.findElement(By.xpath("//input[@id='student']")).isSelected())
			System.out.println("Beginner");
		if (driver.findElement(By.xpath("//input[@id='beginner']")).isSelected())
			System.out.println(" Upper Beginner");
		if (driver.findElement(By.xpath("//input[@id='entry']")).isSelected())
			System.out.println("Intermediate");
		if (driver.findElement(By.xpath("//input[@id='intermidiate']")).isSelected())
			System.out.println("Advanced");
		if (driver.findElement(By.xpath("//input[@id='expert']")).isSelected())
			System.out.println("Expert");
		System.out.println("Script run successfully!");

	}

	public void resetButton(WebDriver driver) {
		System.out.println("=======Method 5========");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Check Reset functionality of Reset buuton");
		String name = "Suvela";
		System.out.println("Enter " + name + " in First Name");
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys(name);
		System.out.println("Now click on reset button");
		driver.findElement(By.xpath("//input[@id='resetBtn']")).click();
		System.out.println("Chcek if First Name still has the name provided or not");
		String value = driver.findElement(By.xpath("//input[@id='first name']")).getAttribute("value");
		if (value.equals(""))
			System.out.println("Reset button worked!");
		else
			System.out.println("Reset button did not worked!");
		System.out.println("Script run successfully!");
		driver.close();
	}

	public static void main(String[] args) {
		WebDriver driver = RequiredActions.start(
				"file:///F:/Java-Selenium%20course/Suvela-workspace/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
		new Form4Functions().checkGenderRadioButton(driver);

		new Form4Functions().checkBoxButton(driver);

		new Form4Functions().secondLastIndexDropDown(driver);

		new Form4Functions().yearExpRadioButton(driver);

		new Form4Functions().resetButton(driver);

	}

}
