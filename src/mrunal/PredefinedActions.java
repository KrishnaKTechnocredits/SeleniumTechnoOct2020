/*Assignment - 7 : Scroll & MultiSelect
Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.*/
package mrunal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PredefinedActions {

	static WebDriver start() {
		System.out.println("STEP : Launch Chrome browser");
		System.setProperty(ConstantPath.chromeDriverKey,ConstantPath.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		System.out.println("STEP : Open 'http://automationbykrishna.com/' URL");
		driver.get("http://automationbykrishna.com/");
		System.out.println("STEP : Maximize the browser");
		driver.manage().window().maximize();
		return driver;
	}

}