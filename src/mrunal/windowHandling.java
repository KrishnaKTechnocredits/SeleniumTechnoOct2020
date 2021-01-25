package mrunal;
/*2. Verify that by click on any button on form new window is opening
Note: use Window_Handling Form from resources*/
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class windowHandling {

	public static void getNewWindowOpening(WebDriver driver){

		System.out.println("STEP - Provided Implicit Wait to Driver Object");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		System.out.println("STEP - Click on First Window");
		String mainWindow=driver.getWindowHandle();
		System.out.println(" Main window Name is->"+mainWindow);
		driver.findElement(By.xpath("//button[text()='First Window']")).click();
		Set<String> windows=driver.getWindowHandles();
		System.out.println("Total Windows After Opening new Window -->"+windows.size());
		for(String win :windows){
			System.out.println("Child Window is--"+win);
		}
	}

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		System.out.println("STEP - Maximising the browser");
		driver.manage().window().maximize();
		
		System.out.println("STEP - Opening Window Handling WebPage");
		driver.get("file:///E:/project/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");
		
		getNewWindowOpening(driver);
		
		System.out.println("STEP - Closing browser ");
		driver.close();
		

	}
}