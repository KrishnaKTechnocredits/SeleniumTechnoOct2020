package technoCredits.table;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technoCredits.base.PredefinedActions;

public class Example1 {
	
	public static void main(String[] args) {
		WebDriver driver = PredefinedActions.start();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Demo Tables")).click();
		String rowText = driver.findElement(By.xpath("//table[@class='table table-striped']")).getText();
		System.out.println(rowText);
		
	}
	
}
