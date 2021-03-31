package raghvendra.Assignment_13;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import raghvendra.base.ConstantAction;
//2. Double Click on (AutomationByKrishna)
public class DoubleClick {
	WebDriver driver=ConstantAction.url();
	void performDoubleClick() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.xpath("//a[@ondblclick='doubleClick()']"));
		js.executeScript("arguments[0].scrollIntoView();",element);
		Actions act=new Actions(driver);
		act.doubleClick(element).build().perform();
	}
	public static void main(String[] args) {
		DoubleClick doubleClick=new DoubleClick();
		doubleClick.performDoubleClick();
	}
}
