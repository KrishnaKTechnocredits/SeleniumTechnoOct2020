package technoCredits;

import java.io.FileNotFoundException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import technoCredits.base.PredefinedActions;

public class DropdownEx1 {
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start("file:///D:/TechnoCredits/Projects/OCT20/SeleniumTechnoOct2020/resources/forms/FirstForm.html");
		WebElement branchElement = driver.findElement(By.xpath("//select[@id='branch']"));
		Select selectBranchElement = new Select(branchElement);
		selectBranchElement.selectByVisibleText("CE");
		
		List<WebElement> allElements= selectBranchElement.getOptions();
		System.out.println("Total number of elements in the list" + allElements.size());
		for(WebElement element : allElements) {
			System.out.println(element.getText());
		}
		
	}
}
