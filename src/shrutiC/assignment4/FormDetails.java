package shrutiC.assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import shrutiC.StartWebDriver;

public class FormDetails {

	static WebDriver driver;

	// Program 1

	void toggleGenderSelection() {
		System.out.println("********************************************************************************");
		System.out.println("Program1: Revert selection of gender radio button");
		WebElement element = driver.findElement(By.xpath("//input[@name='gender' and @value='female']"));
		if (element.isSelected()) {
			driver.findElement(By.xpath("//input[@name='gender' and @value='male']")).click();
			System.out.println("Gender selected : Male");
		} else {
			element.click();
			System.out.println("Gender selected : Female");
		}
		System.out.println("Gender Selection toggled successfully");
	}

	void toggleLanguageSelection() {

		System.out.println("********************************************************************************");
		System.out.println("Language Selection : ");
		List<WebElement> listEle = driver.findElements(By.xpath("//input[@name='language']"));
		for (WebElement element : listEle) {
			String language = element.getAttribute("value");

			if (element.isSelected()) {
				element.click();
				System.out.println(language + " is unchecked");
			} else {
				element.click();
				System.out.println(language + " is checked");
			}
		}
	}

	void regionSelection() {

		System.out.println("********************************************************************************");
		WebElement element = driver.findElement(By.xpath("//select[@id='continents']"));
		Select select = new Select(element);

		List<WebElement> continents = select.getOptions();
		int size = continents.size();
		System.out.println("Second last continent is : " + continents.get(size - 2).getText());
	}

	void validateIndustryExp() {
		System.out.println("********************************************************************************");
		String experience = "";
		System.out.println("Validate 'Total Year's of Experience In Industry' radio button.");
		List<WebElement> elements = driver.findElements(By.name("experience"));
		for (WebElement element : elements) {
			if (element.isSelected()) {
				experience = element.getAttribute("id");

				System.out.println(experience);
				if (experience.equalsIgnoreCase("student"))
					System.out.println("Level : 'Beginner'");
				else if (experience.equalsIgnoreCase("beginner"))
					System.out.println("Level : 'Upper Beginner'");
				else if (experience.equalsIgnoreCase("entry"))
					System.out.println("Level : 'Intermediate'");
				else if (experience.equalsIgnoreCase("intermediate"))
					System.out.println("Level : 'Advanced'");
				else if (experience.equalsIgnoreCase("expert"))
					System.out.println("Level : Expert");
			}
		}
	}

	void validateReset() {

		System.out.println("********************************************************************************");
		WebElement element = driver.findElement(By.xpath("//input[@id='first name']"));
		element.sendKeys("Shruti");
		String enteredName = element.getAttribute("value");
		System.out.println("First name entered : " + enteredName);

		// Click on reset button
		driver.findElement(By.xpath("//input[@id='resetBtn']")).click();
		if (element.getText() == null || element.getText().isEmpty()) {
			System.out.println("Reset button validation successful");
		}
	}

	public static void main(String[] args) {

		System.out.println("********************************************************************************");
		FormDetails object = new FormDetails();
		try {
			driver = StartWebDriver.start(
					"file:///F:/TechnoCredit_JavaNotes/Workspace/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");

			object.toggleGenderSelection();
			object.toggleLanguageSelection();
			object.regionSelection();
			object.validateIndustryExp();
			object.validateReset();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}

}
