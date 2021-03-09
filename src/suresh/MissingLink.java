package suresh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PredefinedActions;

public class MissingLink {
	public static int brokenLinks;
	public static int validLinks;
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
				
		driver.navigate().to("C:\\Users\\User\\Desktop\\Suresh\\Learning\\Oct_selenium\\Resources\\MissingLink.html");
		
		List<WebElement> listle = driver.findElements(By.xpath("//a"));
		System.out.println("Total Elements:"+listle.size());
		
		/*for(WebElement ele: listle) {
			System.out.println(ele.getAttribute("href"));
		}*/
		
		for(WebElement ele: listle) {
			//System.out.println(ele.getAttribute("href"));
			String data = ele.getAttribute("href");
			if(data==null || data.isEmpty()) {
				System.out.println("Missing links is:"+ele.getText());
		}
		//driver.quit();
	}
	}
}
