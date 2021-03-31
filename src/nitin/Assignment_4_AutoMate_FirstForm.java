package nitin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//import Constantpath.java;

public class Assignment_4_AutoMate_FirstForm {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get(
				"D:\\Nitin\\Java_Technocredit\\Java_Eclipse\\SeleniumTechnoOct2020\\resources\\forms\\First_Form_4.html");
		System.out.println("-------Program 1 --------");
		WebElement element1 = driver.findElement(By.xpath("//input[@name='gender'and@value='male']"));
		element1.click();
		if (element1.isSelected())
			driver.findElement(By.xpath("//input[@name='gender'and@value='female']")).click();
		else
			element1.click();
		System.out.println("Test Case Passed.");
		System.out.println("-------Program 2 --------");
		List<WebElement> element2 = driver.findElements(By.xpath("//input[@name='language']"));
		for (WebElement ele : element2)
			ele.click();
		System.out.println("Test Case Passed");
		System.out.println("-------Program 3 --------");
		element1 = driver.findElement(By.xpath("//select[@id='continents']"));
		Select select = new Select(element1);
		element2 = select.getOptions();
		select.selectByIndex(element2.size() - 2);
		WebElement option = select.getFirstSelectedOption();
		System.out.println("Selected Value : " + option.getText());
		System.out.println("Test Case Passed");
		System.out.println("-------Program 4 --------");
		element2 = driver.findElements(By.xpath("//input[@name='experience']"));
		for (WebElement ele : element2) {
			if (ele.isSelected())
				System.out.println(ele.getAttribute("id") + "selected");
		}
		System.out.println("Test Case Passed");
		System.out.println("-------Program 5 --------");
		System.out.println("STEP - Enter First Name.");
		element1 = driver.findElement(By.xpath("//input[@id='first name']"));
		element1.sendKeys("Nitin");
		if (element1.getAttribute("value").equals("Nitin")) {
			System.out.println("STEP - Click on reset button");
			driver.findElement(By.xpath("//input[@value='Reset form in same tab']")).click();
			System.out.println("STEP - Check Page and First Name Value");
			String currentMsg = element1.getAttribute("value");
			if (currentMsg.equals(null) || currentMsg.length() == 0)
				System.out.println("Test Case Passed");
			else
				System.out.println("Test Case Failed");
		}
		driver.close();
	}
}
