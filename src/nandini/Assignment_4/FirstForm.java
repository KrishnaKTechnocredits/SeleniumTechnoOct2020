package nandini.Assignment_4;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import nandini.base.Driver;
public class FirstForm {
	
	public static void main(String[] args) {
		WebDriver driver = Driver.start(
				"G:\\SeleniumOct_2020\\SeleniumTechnoOct2020\\resources\\forms\\First_Form_4.html");
		try {
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
			element.sendKeys("Nandini");
			if (element.getAttribute("value").equals("Nandini")) {
				System.out.println("Clicking on form reset button");
				driver.findElement(By.id("resetBtn")).click();
				System.out.println("Validating text of 'First Name' field. It should be null or empty.");
				String text = element.getAttribute("value");
				if (text == null || text.length() == 0)
					System.out.println("Test Passed");
				else
					System.out.println("Test Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Driver.quit(driver);
		}
	}
}
