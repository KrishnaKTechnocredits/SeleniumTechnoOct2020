package prasad;

import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*Assignment - 13 Actions class methods to perform

1. Drag And Drop on (https://demos.telerik.com/kendo-ui/dragdrop/index)
2. Double Click on (AutomationByKrishna)
3. Mouse hover on Amazon(Verify how many links available under Account & Lists)*/

public class ActionsMethods {
	static WebDriver driver;

	public static void main(String[] arg) throws InterruptedException {
		ActionsMethods act = new ActionsMethods();
		System.out.println("Step 1: Perform drag and drop action");
		driver = StaticResources.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		act.drag();
		System.out.println("");
		System.out.println("Step 2: Perform double click action on element");
		act.doubleClick();
		System.out.println("");
		System.out.println("Step 3: Perform mouse over action");
		act.mouseOver();
	}

	void drag() throws InterruptedException {

		String refMsg = "You did great!";
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droptarget']"));
		System.out.println("Clicking on accept cookies");
		driver.findElement(By.xpath("//button[text() = 'Accept Cookies']")).click();

		System.out.println("Scrolling to get elements in view port");

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,100)");

		System.out.println("Dragging small circle into target circle");
		Actions action = new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
		String msg = drop.getText();
		if (msg.equals(refMsg)) {
			System.out.println("Element dragged and dropped successfully");
		} else
			System.out.println("Element was not dragged and dropped successfully");
	}
	
	void doubleClick() {
		String refMsg = "You successfully double clicked it";
		driver.get("http://automationbykrishna.com");
		System.out.println("Navigate to Basic Elements tab");
		driver.findElement(By.linkText("Basic Elements")).click();
		System.out.println("Scrolling down to get element in view port");
		WebElement element = driver.findElement(By.linkText("Double-click on me"));
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView();",element);
		
		Actions action = new Actions(driver);
		System.out.println("Double clicking on link");
		action.doubleClick(element).build().perform();
		System.out.println("Validate alert msg");
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		if(msg.equals(refMsg)) {
			System.out.println(msg);
		}
		else 
			System.out.println("Element not double clicked");
		
		alert.accept();
	}
	
	void mouseOver() throws InterruptedException {
		driver.get("http://amazon.in");
		System.out.println("Hover mouse over Account & Lists");
		WebElement element = driver.findElement(By.xpath("//a[@href ='https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@id = 'nav-al-container']//a[@class = 'nav-link nav-item']"));
		System.out.println("Number of links under Accounts & Lists");
		System.out.println(listOfLinks.size());
	}

}
