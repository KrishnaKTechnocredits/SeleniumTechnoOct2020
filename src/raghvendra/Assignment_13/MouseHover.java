package raghvendra.Assignment_13;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import raghvendra.base.ConstantAction;
//3. Mouse hover on Amazon(Verify how many links available under Account & Lists)
public class MouseHover {
	WebDriver driver=ConstantAction.start("https://www.amazon.com/");
	void perfromMouseHover() {
		WebElement elemnt=driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		Actions act=new Actions(driver);
		act.moveToElement(elemnt).build().perform();
		List<WebElement>listOfAccountItem=driver.findElements(By.xpath("//span[@class='nav-text']"));
		System.out.println("Number of links available under Account & Lists are:"+listOfAccountItem.size());
		
	}
	public static void main(String[] args) {
		MouseHover mouseHover=new MouseHover();
		mouseHover.perfromMouseHover();
	}

}
