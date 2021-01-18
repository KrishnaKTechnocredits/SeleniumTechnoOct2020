package monika;

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


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import raghvendra.base.ConstantAction;

public class Radiobutton {
	WebElement element;
	WebDriver driver=ConstantAction.start("file:///C:\\Users\\sethimon\\Desktop\\OCT\\Selenium_Oct\\SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
	//C:\Users\sethimon\Desktop\OCT\Selenium_Oct\SeleniumTechnoOct2020
	void revertGenderSelection() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("Opening the First_Form_4.html Page");
		boolean maleSelected=driver.findElement(By.xpath("//input[@id='maleG']")).isSelected();
		System.out.println("Verify if male is selected: " +maleSelected);
		if(maleSelected) {
			System.out.println("Male is selected by default so selecting Female now");
			driver.findElement(By.xpath("//input[@id='femaleG']")).click();
		}
		else {
			System.out.println("Female is selected by default so selecting Male now");
			driver.findElement(By.xpath("//input[@id='maleG']")).click();
		}
	}
	void revertSelectionOfLanguage() {
		List<WebElement> lanugaeElement=driver.findElements(By.xpath("//input[@name='language']"));
		System.out.println("Selecting non selected Language checkbox present on page: ");
		for(WebElement element:lanugaeElement) {
			element.click();	
		}
	} 

	void selectSecondLastDropdwon() {
		WebElement livingDropdown=driver.findElement(By.xpath("//select[@id='continents']"));
		Select oneSelect=new Select(livingDropdown);
		List<WebElement>numberOfElement=oneSelect.getOptions();
		System.out.println("Seleting Second last element from Drop-down");
		oneSelect.selectByIndex(numberOfElement.size()-2);
	}

	void displayExprience() {
		List<WebElement> expreienceElements=driver.findElements(By.xpath("//input[@name='experience']"));
		for(WebElement element:expreienceElements) {
			if(element.isSelected())
				System.out.println("Experience of student"+"-->"+element.getAttribute("id"));
			}
	}
	void validateReset() {
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys("Monika");
		String nameText=driver.findElement(By.xpath("//input[@id='first name']")).getAttribute("value");
		System.out.println("Eneterd Value in First Name is:"+nameText);
		driver.findElement(By.xpath("//input[@id='resetBtn']")).click();
		String ResetText=driver.findElement(By.xpath("//input[@id='first name']")).getAttribute("value");
		if (ResetText == null || ResetText.length() == 0)
			System.out.println("TestCase Passed");
		else
			System.out.println("Testcase Failed");
	}

	public static void main(String[] args) {
		Radiobutton radiobutton=new Radiobutton();
		radiobutton.revertGenderSelection();
		radiobutton.revertSelectionOfLanguage();
		radiobutton.selectSecondLastDropdwon();
		radiobutton.displayExprience();
		radiobutton.validateReset();
	}
}

