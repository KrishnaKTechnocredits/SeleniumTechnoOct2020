/*Program
a) if element visible -> gettext and print it and hide the element and make sure element is no more visible.
   if element is not visible -> click on visible and hide button -> gettext and print it -> make sure element is now visible on the page. 
b) click on Enbled & Disabled button and verify whether that name inputbox is disabled or not.
c) once name textbox is disabled, try to call sendkeys method and verify behavior.
d) enabled name textbox -> sendKeys("Maulik") -> turn it to disabled -> getAttribute("value") -> compare text with "Maulik". 
Note : This will prove, getAttribute will work even though, element is disabled. 
*/
package pooja.Assignment_5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_5 {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.get(
				"file:///F:/JavaPractice_Techno/SeleniumTechnoOct2020/resources/forms/Enable_And_Disable_%26_Display_%26_Hide_Form.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Website open successfully.");
		driver.manage().window().maximize();
	}

	static void visibleHideElement() {
		System.out.println("STEP-Finding Visible Block");
		WebElement element = driver.findElement(By.xpath("//div[@id='myDIV']"));
		System.out.println("STEP-Finding Visible And Hidden Button");
		WebElement visHidBtn = driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
		if (element.isDisplayed()) {
			System.out.println("Visible block text is : " + element.getText());
			visHidBtn.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!element.isDisplayed())
				System.out.println("Test Result - Passed");
			else
				System.out.println("Test Result - failed");
		} else {
			visHidBtn.click();
			if (element.isDisplayed())
				System.out.println("Test Result - Passed");
			else
				System.out.println("Test Result - Failed");
		}
	}

	static void enabledDisabledElement() {
		System.out.println("STEP-Finding Name Input Field");
		WebElement element1 = driver.findElement(By.xpath("//input[@id='myText']"));
		System.out.println("STEP-Finding Enable And Disable Button");
		WebElement enblDsblBtn = driver.findElement(By.xpath("//button[@onclick='disable()']"));
		if (element1.isEnabled()) {
			System.out.println("STEP-Enter Name");
			element1.sendKeys("Pooja");
			enblDsblBtn.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (!element1.isEnabled()) {
				if (element1.getAttribute("value").equals("Pooja"))
					System.out.println("Test Result- Passed");
			} else
				System.out.println("Test Result - Failed");
		}
		enblDsblBtn.click();
		element1.clear();
		if (element1.isEnabled()) {
			System.out.println("STEP-Entering value ");
			element1.sendKeys("Pooja");
			System.out.println("Step-Clicking");
			enblDsblBtn.click();
		}
	}

	public static void main(String[] args) {
		Assignment_5.launchBrowser();
		Assignment_5.visibleHideElement();
		Assignment_5.enabledDisabledElement();
		System.out.println("Closing Browser");
		driver.close();
	}
}
