package shrutiS.assignment5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HideAndDisplayForm {
	static WebDriver driver;

	public static void start() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(
				"E:\\SeleniumOCT20\\SeleniumTechnoOct2020\\resources\\forms\\Enable_And_Disable_&_Display_&_Hide_Form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("AutomationByKrishna website open successfully.");
	}

	public void validateFormVisibleHideButton() {
		System.out.println("Program 1: Verify Visible and hidden Button");
		WebElement element = driver.findElement(By.xpath("//div[@id='myDIV']"));
		WebElement visHidBtn = driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']"));
		if (element.isDisplayed()) {
			System.out.println("Text from visible block : " + element.getText());
			visHidBtn.click();
			if (!element.isDisplayed())
				System.out.println("Test Passed: Text is not visible");
			else
				System.out.println("Test failed: Text is still visible");

		} else {
			visHidBtn.click();
			if (element.isDisplayed())
				System.out.println("Test Passed");
			else
				System.out.println("Test Failed");
		}

	}

	public void validateFormEnableDisableButton() {
		System.out.println("Program2: Verify Enable and Disable button");
		WebElement element1 = driver.findElement(By.xpath("//input[@id='myText']"));
		WebElement enblDsblBtn = driver.findElement(By.xpath("//button[text()='Enable & Disable Button']"));
		if (element1.isEnabled()) {
			System.out.println("Step : Enter Name");
			element1.sendKeys("Nandini");
			enblDsblBtn.click();

			if (!element1.isEnabled()) {
				if (element1.getAttribute("value").equals("Nandini"))
					System.out.println("Test Passed");
			} else
				System.out.println("Test Failed");
		}
		enblDsblBtn.click();
		element1.clear();
		if (element1.isEnabled()) {
			System.out.println("Step : Entering value ");
			element1.sendKeys("Nandini");
			enblDsblBtn.click();
		}
		System.out.println("Step : Closing browser");
		driver.close();
	}

	public static void main(String[] args) {
		HideAndDisplayForm form = new HideAndDisplayForm();
		start();
		form.validateFormVisibleHideButton();
		form.validateFormEnableDisableButton();
	}
}
