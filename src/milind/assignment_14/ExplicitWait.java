package milind.assignment_14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	WebDriver driver;
	
	void clickableExplicitWait() {
		driver = PredefinedActions.start("file:///D:/Technocredits/eclipseProject/Oct2020/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		System.out.println("STEP : Get enabled and disabled button and click it");
		driver.findElement(By.cssSelector("button[onclick = 'disable()']")).click();
		System.out.println("STEP : Adding Explicit wait for Element to be disbaled");
		try {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#myText")));
		}catch(Exception e){
			System.out.println("STEP : Check textbox is disabled");
			if(driver.findElement(By.cssSelector("#myText")).isEnabled()) {
				System.out.println("iSEnabled");
			}else {
				System.out.println("is not enabled");
			}
		}
	}
	
	void visibilityExplicitWait() {
		driver = PredefinedActions.start("file:///D:/Technocredits/eclipseProject/Oct2020/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_&_Display_&_Hide_Form.html");
		System.out.println("STEP : Get Hidden and Visible button and click it");
		driver.findElement(By.cssSelector("button[onclick='myFunction()']")).click();
		WebDriverWait webDriverWait = new WebDriverWait(driver, 3);
		webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#myDIV")));
	}
	
	public static void main(String[] args) {
		ExplicitWait explicitWait = new ExplicitWait();
		explicitWait.clickableExplicitWait();
		explicitWait.driver.close();
		explicitWait.visibilityExplicitWait();
		explicitWait.driver.close();
	}
}
