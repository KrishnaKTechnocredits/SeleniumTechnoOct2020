package raghvendra;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import raghvendra.base.ConstantAction;
/*Assignment - 8 : Missing_Link & Multiwindow_Handle 

1. Print missing link button text
Note: use missing link form from resources folder*/
public class MissingLink {
	WebDriver driver=ConstantAction.start("file:///C:/Java%20Selenium/Oct22/SeleniumTechnoOct2020/resources/forms/MissingLink.html");
	void displayMissing() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> links=driver.findElements(By.xpath("//a"));
		System.out.println("Missing Links are:");
		for(WebElement elements:links) {
				if(elements.getAttribute("href")==null||elements.getAttribute("href").isEmpty())
					System.out.println(elements.getText());
		}
	}
	public static void main(String[] args) {
		MissingLink link=new MissingLink();
		link.displayMissing();
	}
}
