/*
 * Assignment - 4 [Form : /resources/forms/First_Form_4] 

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

package deepak.assignment4;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import deepak.methods.UtilityMethods;

public class Assignment4 {
	
	
	public static void processData(WebDriver driver) {
		
		//Step1: Getting the list of gender
		System.out.println("Step1: Getting the list of gender");
		List<WebElement> genderList = driver.findElements(By.xpath("//input[@name='gender']"));
		
		//Step2 : Finding which one is selected and then clicking on other one
		System.out.println("Step2 : Finding which one is selected and then clicking on other one");
			if(genderList.get(0).isSelected()) {
				
				System.out.println("Gender value: "+ genderList.get(0).getAttribute("value")+ " is selected by default");
				genderList.get(1).click();
			}
			else {
				
				if(genderList.get(1).isSelected()) {
					
					System.out.println("Gender value: "+ genderList.get(1).getAttribute("value") + " is selected by default");
					genderList.get(1).click();
				}				
			}

			//Step4 : Getting list of languages, uncheck default selected and then select others
			System.out.println("Step4 : Getting list of languages, uncheck default selected and then select others");
			List<WebElement> langList = driver.findElements(By.xpath("//input[@name='language']"));
			
			for(WebElement list : langList)
				
				if(list.isSelected()) {
					
					System.out.println("Language: "+ list.getAttribute("value") + " is selected by default");
					System.out.println("Step5 : Unchecking the default selected value");
					list.click();
			}
				else {
					list.click();
					System.out.println("Now we have selected language: "+ list.getAttribute("value"));
				}
			
			
		WebElement livingDropDowm = driver.findElement(By.xpath("//select[@id='continents']"));
		
		Select obj = new Select(livingDropDowm);
		
		List list = obj.getOptions();
		int size  = list.size();	
		obj.selectByIndex(size-1);
		WebElement selected = obj.getFirstSelectedOption();
		System.out.println("Selected option from drop-dowmn is: "+ selected.getText() );
		
		
		//Step5: Validate 'Total Year's of Experience In Industry' radio button
		System.out.println("//Step5 : Validate 'Total Year's of Experience In Industry' radio button");
		
		List<WebElement> exp = driver.findElements(By.xpath("//input[@name='experience']"));
		
		for(WebElement refVar : exp) {
			
			if(refVar.isSelected()) {
				
				System.out.println("Experiance Level: "+ refVar.getAttribute("name"));
			}
		}
		
		//Step6: Validate reset functionality form
		System.out.println("Step6: Validate reset functionality form");
		WebElement firstNameTxtBox = driver.findElement(By.xpath("//input[@id='first name']"));
		firstNameTxtBox.clear();
		firstNameTxtBox.sendKeys("TechnoCredits");
		System.out.println("Value Entered is: "+ firstNameTxtBox.getAttribute("value"));
		driver.findElement(By.xpath("//input[@id='resetBtn']")).click();
		
		if(firstNameTxtBox.getAttribute("value") == null || firstNameTxtBox.getAttribute("value").contains("")) {

			System.out.println("Form reset successfully");	
		}
		
		System.out.println("------------------Test Pass----------");
	}
			
		public static void main(String[] args) {
			
			WebDriver driver = UtilityMethods.start("file:///G:/Technocredits/Selenium_Technocredits/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
			processData(driver);
			driver.close();
		}			
	}

