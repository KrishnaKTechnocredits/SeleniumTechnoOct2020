package prasad;

/*Frame handling on automation by krishna site using 3 different methods*/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Iframe {
	
	@Test
	void handleIFrame() throws InterruptedException {
		WebDriver driver = StaticResources.start();
		WebDriverWait wait = new WebDriverWait(driver , 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("IFrame Demo"))).click();
		Thread.sleep(3000);
		System.out.println("Step 1: Switching to first frame(frame-0) using string");
		driver.switchTo().frame("site1");
		
		System.out.println("Step 2: Clicking on menu in first frame");
		driver.findElement(By.id("dropdownButton")).click();
		driver.findElement(By.xpath("//span[text() = 'About']")).click();
		driver.findElement(By.id("dropdownButton")).click();
		
		System.out.println("Step 3: Switching to main frame");
		driver.switchTo().parentFrame();
		System.out.println("Step 4: Switching to third frame(frame-2) using index");
		driver.switchTo().frame(2);
		System.out.println("Step 5; Clicking on project tab in third frame");
		driver.findElement(By.xpath("//font[text()='Projects']")).click();
		System.out.println("Step 6: Switching to main frame");
		driver.switchTo().defaultContent();
		
		System.out.println("Step 7: Switching to first frame again using iframe element");
		 WebElement element = driver.findElement(By.xpath("//iframe[@name = 'site1']")) ; 
		 driver.switchTo().frame(element); 
		 System.out.println("Step 8: Clicking on selenium logo in first frame");
		 element = driver.findElement(By.xpath("//a[@class = 'headerLink']"));
		 element.click();
		  
		 
		
	}

}
