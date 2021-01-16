package milind.assignment_4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RadioButtonSelection {
	
	WebDriver driver = PredefinedActions.start();
	
	void revertRadioButtonSelection() {
		System.out.println("STEP : Check Gender>Male is Selected");
		boolean maleRadioButtonIsSelected = driver.findElement(By.xpath("//input[@id='maleG']")).isSelected();
		if(maleRadioButtonIsSelected) {
			System.out.println("Male Radio button is selected, Please revert it to Female");
			driver.findElement(By.xpath("//input[@id='femaleG']")).click();
		}else {
			System.out.println("Male Radio button is not selected, Please Select it");
			driver.findElement(By.xpath("//input[@id='maleG']")).click();
		}
		System.out.println("STEP : Check Female radio button is selected");
		boolean femaleRadioButtonIsSelected = driver.findElement(By.xpath("//input[@id='femaleG']")).isSelected();
		if(femaleRadioButtonIsSelected) {
			System.out.println("=====Pass=====");
		}else {
			System.out.println("=====Fail=====");
		}
	}
	
	void revertSelectionOfCheckboxUnderLanguage() {
		System.out.println("STEP : Check Java language check box is selected or not");
		boolean javaCheckBoxIsSelected = driver.findElement(By.xpath("//input[@id='java']")).isSelected();
		if(javaCheckBoxIsSelected) {
			System.out.println("STEP : Checkbox is selected please Deselect it");
			driver.findElement(By.xpath("//input[@id='java']")).click();
			System.out.println("STEP : check current Java checkbox is Deselected");
			boolean currentJavaCheckboxState = driver.findElement(By.xpath("//input[@id='java']")).isSelected();
			if(currentJavaCheckboxState) {
				System.out.println("=====Fail=====");
				System.out.println("Uncheck the Java checkbox TC Fail");
			}else {
				System.out.println("=====Pass=====");
				System.out.println("Success!! Uncheck the checkbox done");
			}
		}else {
			System.out.println("Check box is not selected please deselect it");
			driver.findElement(By.xpath("//input[@id='java']")).click();
			boolean currentJavaCheckboxState = driver.findElement(By.xpath("//input[@id='java']")).isSelected();
			if(currentJavaCheckboxState) {
				System.out.println("=====Pass=====");
				System.out.println("Success!! Checkbox selected");
			}else {
				System.out.println("=====Fail=====");
				System.out.println("Checkbox is not selected");
			}
		}
		
		System.out.println("************************************************************************************************");
		System.out.println("STEP : Check Python language check box is selected or not");
		boolean pythonCheckBoxIsSelected = driver.findElement(By.xpath("//input[@id='python']")).isSelected();
		if(pythonCheckBoxIsSelected) {
			System.out.println("STEP : Checkbox is selected please Deselect it");
			driver.findElement(By.xpath("//input[@id='python']")).click();
			System.out.println("STEP : check current Python checkbox is Deselected");
			boolean currentJavaCheckboxState = driver.findElement(By.xpath("//input[@id='python']")).isSelected();
			if(currentJavaCheckboxState) {
				System.out.println("=====Fail=====");
				System.out.println("Uncheck the Python checkbox TC Fail");
			}else {
				System.out.println("=====Pass=====");
				System.out.println("Success!! Uncheck the checkbox done");
			}
		}else {
			System.out.println("Check box is not selected please deselect it");
			driver.findElement(By.xpath("//input[@id='python']")).click();
			boolean currentJavaCheckboxState = driver.findElement(By.xpath("//input[@id='python']")).isSelected();
			if(currentJavaCheckboxState) {
				System.out.println("=====Pass=====");
				System.out.println("Success!! Checkbox selected");
			}else {
				System.out.println("=====Fail=====");
				System.out.println("Checkbox is not selected");
			}
		}
		
		System.out.println("***********************************************************************************");
		System.out.println("STEP : Check JavaScript language check box is selected or not");
		boolean javaScriptCheckBoxIsSelected = driver.findElement(By.xpath("//input[@id='javascript']")).isSelected();
		if(javaScriptCheckBoxIsSelected) {
			System.out.println("STEP : Checkbox is selected please Deselect it");
			driver.findElement(By.xpath("//input[@id='javascript']")).click();
			System.out.println("STEP : check current Java acript checkbox is Deselected");
			boolean currentJavaCheckboxState = driver.findElement(By.xpath("//input[@id='javascript']")).isSelected();
			if(currentJavaCheckboxState) {
				System.out.println("=====Fail=====");
				System.out.println("Uncheck the Java Script checkbox TC Fail");
			}else {
				System.out.println("=====Pass=====");
				System.out.println("Success!! Uncheck the checkbox done");
			}
		}else {
			System.out.println("Check box is not selected please deselect it");
			driver.findElement(By.xpath("//input[@id='javascript']")).click();
			boolean currentJavaCheckboxState = driver.findElement(By.xpath("//input[@id='javascript']")).isSelected();
			if(currentJavaCheckboxState) {
				System.out.println("=====Pass=====");
				System.out.println("Success!! Checkbox selected");
			}else {
				System.out.println("=====Fail=====");
				System.out.println("Checkbox is not selected");
			}
		}
	}
	
	void selectSecondLastValueFromDropdown() {
		System.out.println("STEP : Get all reason options from dropdown");
		WebElement reasonDropdown = driver.findElement(By.xpath("//select[@class = 'input-xlarge']"));
		Select select = new Select(reasonDropdown);
		System.out.println("STEP : get Length of reason dropdown");
		List<WebElement> listOfReasonOptions = select.getOptions();
		int reasonTotalLength = listOfReasonOptions.size();
		int secondLastIndex = reasonTotalLength - 2;
		select.selectByIndex(secondLastIndex);
		System.out.println("=====Pass=====");
	}
	
	void validateTotalYearOfExperience() {
		System.out.println("Check Total year of experience");
		if(driver.findElement(By.xpath("//input[@id = 'student']")).isSelected()) {
			System.out.println("==Student radio button selected==");
			System.out.println("Beginner");
		}else if(driver.findElement(By.xpath("//input[@id =  'beginner']")).isSelected()) {
			System.out.println("==1-3 Year radio button selected==");
			System.out.println("Upper Beginner");
		}else if(driver.findElement(By.xpath("//input[@id =  'entry']")).isSelected()) {
			System.out.println("==3-6 Year radio button selected==");
			System.out.println("Intermediate");
		}else if(driver.findElement(By.xpath("//input[@id='intermidiate']")).isSelected()) {
			System.out.println("==6-10 Year radio button selected==");
			System.out.println("Advanced");
		}else if(driver.findElement(By.xpath("//input[@id='expert']")).isSelected()){
			System.out.println("==Above 10 Year radio button selected==");
			System.out.println("Expert");
		}else {
			System.out.println("=====Fail=====");
			System.out.println("No Radio button selected");
		}
	}
	
	void resetFormFunctionality() {
		System.out.println("Enter value in First name field");
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys("Milind");
		System.out.println("Click reset form button");
		driver.findElement(By.xpath("//input[@id='resetBtn']")).click();
		System.out.println("Check enter first name field is clear or not");
		String valueOfFNameField = driver.findElement(By.xpath("//input[@id='first name']")).getAttribute("value");
		System.out.println("1: " + valueOfFNameField);
		if(valueOfFNameField.isEmpty()) {
			System.out.println("Reset form button is working");
		}else {
			System.out.println("Rest form button is not working");
		}
	}
	
	public static void main(String[] args)  {
		RadioButtonSelection radioButtonSelection = new RadioButtonSelection();
		radioButtonSelection.revertRadioButtonSelection();
		radioButtonSelection.revertSelectionOfCheckboxUnderLanguage();
		radioButtonSelection.selectSecondLastValueFromDropdown();
		radioButtonSelection.validateTotalYearOfExperience();
		radioButtonSelection.resetFormFunctionality();
		radioButtonSelection.driver.close();
	}
}
