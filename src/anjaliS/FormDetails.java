package anjaliS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormDetails {
	static WebDriver driver;

	void actionsOnForm() {

		System.out.println("Form page opened successfully");
		driver.get("file:///C:/Users/anjal/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");

		System.out.println("Step 1- Switch the selection of 'Gender' radio button");
		List<WebElement> list = driver.findElements(By.xpath("//input[@name=\"gender\"]"));
		if (list.get(0).isSelected()) {
			System.out.println(list.get(0).getAttribute("value") + " is selected by default");
			list.get(1).click();
			System.out.println("Now " + list.get(1).getAttribute("value") + " selected");
		} else if (list.get(1).isSelected()) {
			System.out.println(list.get(1).getAttribute("value") + " is selected by default");
			list.get(0).click();
			System.out.println("Now " + list.get(0).getAttribute("value") + " selected");
		}
		System.out.println();
		System.out.println("Step - Revert the selection of checkboxes");
		list = driver.findElements(By.xpath("//input[@name=\"language\"]"));
		System.out.println("Selected checkboxes before revert operation");
		for (WebElement ele : list) {
			if (ele.isSelected())
				System.out.println(ele.getAttribute("value") + " ");
			ele.click();
		}
		System.out.println("Selected checkboxes after revert operation");
		for (WebElement ele : list) {
			if (ele.isSelected())
				System.out.println(ele.getAttribute("value") + " ");
		}
		System.out.println();
		System.out.println(
				"Step - Select 'Second Last' index from 'I am living in' dropdown and print value of selected option");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id=\"continents\"]"));
		Select select = new Select(dropdown);
		list = select.getOptions();
		select.selectByIndex(list.size() - 2);
		System.out.println("Selected option is -> " + select.getFirstSelectedOption().getText());
		System.out.println();
		System.out.println("Step - Validate 'Total Years of Experience In Industry' radio button.");
		list = driver.findElements(By.xpath("//input[@name='experience']"));
		for (WebElement ele : list) {
			if (ele.isSelected()) {
				String str = ele.getAttribute("id");
				if (str.equalsIgnoreCase("student"))
					System.out.println("Beginner");
				else if (str.equalsIgnoreCase("beginner"))
					System.out.println("Upper Beginner");
				else if (str.equalsIgnoreCase("entry"))
					System.out.println("Intermediate");
				else if (str.equalsIgnoreCase("intermediate"))
					System.out.println("Advanced");
				else if (str.equalsIgnoreCase("expert"))
					System.out.println("Expert");
			}
		}
		System.out.println();
		System.out.println("Step - Validate Reset functionality of form.");
		WebElement element = driver.findElement(By.id("first name"));
		element.clear();
		element.sendKeys("Ritika");
		System.out.println("First name entered: " + element.getAttribute("value"));
		driver.findElement(By.id("resetBtn")).click();
		if (element.getAttribute("value") == null || element.getAttribute("value").equals(""))
			System.out.println("Form reset successfull");
	}

	public static void main(String[] args) {
	//	driver = Driver.start();
		FormDetails fd = new FormDetails();
		fd.actionsOnForm();

	}

}
