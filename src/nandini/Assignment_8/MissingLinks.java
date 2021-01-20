package nandini.Assignment_8;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nandini.base.Driver;

public class MissingLinks {
	
	void missingLinks() throws IOException {
		WebDriver driver = Driver.start(
				"G:\\SeleniumOct_2020\\SeleniumTechnoOct2020\\resources\\forms\\MissingLink.html");
		try {
			System.out.println("Program1: Print missing link button text");
			List<WebElement> webElements = driver.findElements(By.tagName("a"));
			for(WebElement webElement : webElements) {
				if(webElement.getAttribute("href") == null || webElement.getAttribute("href").length()==0)
					System.out.println(webElement.getText());
			}

			System.out.println("\nProgram2: Verify that by click on any button on form new window is opening");
			driver.get("G:\\SeleniumOct_2020\\SeleniumTechnoOct2020\\resources\\forms\\Window_Handling_Form.html");
			String baseWindow = driver.getWindowHandle();
			driver.findElement(By.xpath("//button[text()='First Window']")).click();
			Set<String> windows = driver.getWindowHandles();
			System.out.println("Step: Total wondows "+windows.size());
			System.out.println(windows);
			if(windows.size()>1) {
				for(String window : windows) {
					if(!window.equals(baseWindow)) {
						System.out.println("Step: Closing window "+window);
						driver.switchTo().window(window);
						driver.close();
					}
				}
				driver.switchTo().window(baseWindow);
				System.out.println("Test Passed");
			} else
				System.out.println("Test Failed");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Driver.quit(driver);
		}
	}
	
	public static void main(String[] args) throws IOException {
		MissingLinks missingLinks = new MissingLinks();
		missingLinks.missingLinks();
	}
	
}
