package milind.assignment_8;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyMissingLinks {
	
	WebDriver driver;
	
	void missingLinks() throws IOException {
		driver = PredefinedActions.start();
		System.out.println("STEP : Get all link count");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println("STEP : Verify is link present");
		Iterator<WebElement> itr = allLinks.iterator();
		while(itr.hasNext()) {
			WebElement element = itr.next();
			String url = element.getAttribute("href");
			if(url == null || url.isEmpty()) {
				System.out.println("Broken link is : " +element.getText());
			}
		}
	}
	
	void multiWindowHandle() throws IOException {
		driver = PredefinedActions.start("https:\\www.naukri.com");
		Set<String> listOfWindowID = driver.getWindowHandles();
		for(String windowID : listOfWindowID) {
			String windowTitle = driver.switchTo().window(windowID).getTitle();
			if(!(windowTitle.contains("Jobs - Recruitment"))) {
				driver.close();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		VerifyMissingLinks verifyMissingLinks = new VerifyMissingLinks();
		verifyMissingLinks.missingLinks();
		verifyMissingLinks.driver.close();
		verifyMissingLinks.multiWindowHandle();
	}
}
