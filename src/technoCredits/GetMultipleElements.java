package technoCredits;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import technoCredits.base.PredefinedActions;

public class GetMultipleElements {

	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start(
				"D:/TechnoCredits/Batches/Oct2020/Projects/SeleniumTechnoOct2020/resources/forms/MissingLink.html");

		List<WebElement> listEle = driver.findElements(By.xpath("//b"));
		System.out.println("Total Element " + listEle.size());
		System.out.println(listEle.get(0));
		for(WebElement ele : listEle) {
			System.out.println(ele.getAttribute("value"));
		}
	}
}
