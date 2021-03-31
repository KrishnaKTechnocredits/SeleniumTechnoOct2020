/*
Assignmnet 8

Program 1. Print missing link button text
Note: use missing link form from resources folder
*/
package pooja.Assignment_8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MissingLink {

	static WebDriver driver;

	void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get("file:///F:/JavaPractice_Techno/SeleniumTechnoOct2020/resources/forms/MissingLink.html");
		System.out.println(" Website open successfully.");
		driver.manage().window().maximize();
	}

	void findLink() {
		List<WebElement> list1 = driver.findElements(By.xpath("//a"));
		System.out.println("Total Links :" + list1.size());
		for (WebElement elements : list1) {
			System.out.println(elements.getAttribute("href"));
			if (elements.getAttribute("href") == null || elements.getAttribute("href").isEmpty())
				;
			{
				System.out.println(elements.getText());
			}
		}
	}

	public static void main(String[] args) {
		MissingLink missingLink = new MissingLink();
		missingLink.launchBrowser();
		missingLink.findLink();
		driver.close();
	}
}