/*Scroll & MultiSelect 
Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.
*/


package deepak.assignment7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import deepak.methods.UtilityMethods;

public class DropDownDemo {
	
	
	public static void selectDeselectDropDown( WebDriver driver, String option1, String option2) {
		
		int count=0;
		
		//Pre-requisite
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("http://automationbykrishna.com/");
		driver.manage().window().maximize();
		
		System.out.println("Step1 : Click on Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		
		System.out.println("Step2 : Finding the multi select drop-down on web page");
		WebElement dropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
		
		System.out.println("Step3 : Scroll logic as multi select drop-down is not in view port");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", dropDown);
		
		System.out.println("Step4 : Selecting multiple values frrom drop-down");
		Select obj = new Select(dropDown);
		
		obj.selectByVisibleText("1");
		obj.selectByVisibleText("3");
		
		System.out.println("Step5 : Fetting all selected options");
		java.util.List<WebElement> selectedOptns = obj.getAllSelectedOptions();
		
		for(WebElement options : selectedOptns) {
			
			if(options.getText().equals("1") || options.getText().equals("3") ) {
				
				count++;
			}
			else
				System.out.println("Options are not selected");
		}
		
		if(count == 2) {
			
			System.out.println("Given options 1 and 3 are selected");
		}
			
		System.out.println("Step6 : Finding all unselected options");
		
		java.util.List<WebElement> unSelectedOptions = obj.getOptions();
		
		for(WebElement unSelectOpts : unSelectedOptions) {
			
			if(!(unSelectOpts.isSelected())) {
				
				System.out.println(unSelectOpts.getText() + " ");
			}
		}
		
		System.out.println("Step7 : Deselect all the options ");
		obj.deselectAll();
		
		System.out.println("Step8 : Verify all options are deselected");
		
		java.util.List<WebElement> listOfAllSelectedAfterDeselect = obj.getAllSelectedOptions();
		
		if(listOfAllSelectedAfterDeselect.size() < 1) {
			
			System.out.println("None of the options are selected as size is "+ listOfAllSelectedAfterDeselect.size() + " Test Pass");
		}
	}
		
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = UtilityMethods.start();
		selectDeselectDropDown(driver, "1", "3");
		driver.close();
	}	
}

