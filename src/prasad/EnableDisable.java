package prasad;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignment - 5 [form : /resources/forms/Enable_And_Disable_&_Display_&_Hide_Form]

a) if element visible -> gettext and print it and hide the element and make sure element is no more visible.

if element is not visible -> click on visible and hide button -> gettext and print it -> make sure element is now visible on the page.

b) click on Enbled & Disabled button and verify whether that name inputbox is disabled or not.

c) once name textbox is disabled, try to call sendkeys method and verify behavior.

d) enabled name textbox -> sendKeys("Maulik") -> turn it to disabled -> getAttribute("value") -> compare text with "Maulik".

Note : This will prove, getAttribute will work even though, element is disabled.*/

public class EnableDisable {
	String name = "Prasad Chitale";

	void validateElements(WebDriver driver) {
		System.out.println("Step: Validate if text element is visible on the page");
		WebElement textElement = driver.findElement(By.xpath("//div[@id='myDIV']"));
		String text = textElement.getText();
		String output = checkVisiblity(textElement, text);
		System.out.println(output);

		System.out.println("");
		System.out.println("Step: Hide the text element from the page");
		System.out.println("Clicking on Visible & Hidden button");
		driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
		System.out.println("Checking if text element visiblity on the page");
		output = checkVisiblity(textElement, text);
		System.out.println(output);

		System.out.println("");
		System.out.println("Step: Validate Enable & Disable button");
		System.out.println("Clicking on Enable & Disable button and then checking if Name text field is disabled");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='myText']"));
		String outputmsg = checkIfEnable(element);
		System.out.println(outputmsg);
		try {
			System.out.println("Trying to enter value in disabled Name text field");
			element.sendKeys(name);
		} catch (ElementNotInteractableException e) {
			System.out.println(
					"Encountered ElementNotInteractableException when we tried to enter value in disabled Name text field");
		}

		System.out.println("");
		System.out.println("Step: Enabling Name text field by clicking on Enable & Disable button");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		outputmsg = checkIfEnable(element);
		System.out.println(outputmsg);
		System.out.println("Entering name in text field");
		element.sendKeys(name);

		System.out.println("");
		System.out.println("Step: Disabling name text field");
		driver.findElement(By.xpath("//button[text()='Enable & Disable Button']")).click();
		System.out.println("Validate if current value in name text field is still same as previously entered name");
		String enteredValue = element.getAttribute("value");
		System.out.println(name.equals(enteredValue));
	}

	String checkVisiblity(WebElement element, String str) {
		if (element.isDisplayed())
			return "TRUE: " + str + " element is present on the page";

		else
			return "FALSE: " + str + " element is NOT present on the page";
	}

	String checkIfEnable(WebElement element) {
		if (element.isEnabled())
			return "Name text field is enabled";
		else
			return "Name text field is disabled";
	}

	public WebDriver start() {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"file:///C:/Users/Prasad%20Chitale/Documents/java_selenium/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_%26_Display_%26_Hide_Form.html");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return driver;
	}

	public static void main(String[] arg) {
		EnableDisable enabledisable = new EnableDisable();
		System.out.println("Step: Opening chrome browser and accessing the URL");
		WebDriver driver = enabledisable.start();
		enabledisable.validateElements(driver);
	}
}
