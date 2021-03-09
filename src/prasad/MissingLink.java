package prasad;

/*Assignment - 8 : Missing_Link & Multiwindow_Handle

1. Print missing link button text
Note: use missing link form from resources folder

2. Verify that by click on any button on form new window is opening
Note: use Window_Handling Form from resources
*/
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MissingLink {

	public WebDriver start() {
		System.setProperty("webdriver.chrome.driver", ".//resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"C:\\Users\\Prasad Chitale\\Documents\\java_selenium\\SeleniumTechnoOct2020\\resources\\forms\\MissingLink.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		return driver;
	}

	void findMissing(WebDriver driver) {
		ArrayList<WebElement> hyperLinks = new ArrayList<WebElement>();
		WebElement element1 = driver.findElement(By.xpath("//a[text()=' Google ']"));
		WebElement element2 = driver.findElement(By.xpath("//a[text()=' AutomationByKrishna ']"));
		WebElement element3 = driver.findElement(By.xpath("//a[text()=' Facebook ']"));
		WebElement element4 = driver.findElement(By.xpath("//a[text()=' Instagram ']"));
		WebElement element5 = driver.findElement(By.xpath("//a[text()=' Globant ']"));
		WebElement element6 = driver.findElement(By.xpath("//a[text()=' Synechron ']"));

		hyperLinks.add(element1);
		hyperLinks.add(element2);
		hyperLinks.add(element3);
		hyperLinks.add(element4);
		hyperLinks.add(element5);
		hyperLinks.add(element6);

		ArrayList<WebElement> missingLinks = new ArrayList<WebElement>();

		for (WebElement e : hyperLinks) {
			String hrefVal = e.getAttribute("href");
			if (hrefVal == null || hrefVal.length() == 0) {
				missingLinks.add(e);
			}
		}
		
		System.out.println("Step 2: Missing link text:-");
		for (WebElement el : missingLinks) {
			String fieldName = el.getText();
			System.out.println(fieldName);
		}
		
		System.out.println("Step 3: Navigating to Window Handling page");
		driver.get("file:///C:/Users/Prasad%20Chitale/Documents/java_selenium/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");
		
		System.out.println("Step 4: Clicking on First Window button");
		driver.findElement(By.xpath("//button[text()='First Window']")).click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println("Step 5: Printing browser window handle names");
		System.out.println("Number of browser windows open: " + windows.size());
		
		driver.quit();
	}

	public static void main(String[] arg) {
		MissingLink link = new MissingLink();
		System.out.println("Step 1: Launching chrome browser and accessing");
		WebDriver driver = link.start();
		link.findMissing(driver);
	}

}
