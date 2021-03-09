package raghvendra.TestNG.GeneralPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import raghvendra.base.ConstantAction;

public class Autosuggestion {
	WebDriver driver=ConstantAction.start("https://www.goibibo.com");
	
	@Test
	void autoSuggestion() {
		driver.findElement(By.cssSelector("#gosuggest_inputSrc")).sendKeys("Pune");
		 WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@id='react-autosuggest-1-suggestion--0']")));
	    driver.findElement(By.cssSelector("#react-autosuggest-1-suggestion--0")).click();
	}
}
