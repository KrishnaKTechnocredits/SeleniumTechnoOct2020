package raghvendra.Assignment_13;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import raghvendra.base.ConstantAction;
//1. Drag And Drop on (https://demos.telerik.com/kendo-ui/dragdrop/index)
public class DragAndDrop {
	WebDriver driver=ConstantAction.start("https://demos.telerik.com/kendo-ui/dragdrop/index");
	void performDragDrop() {
	WebElement dropTarget=	driver.findElement(By.xpath("//div[@id='droptarget']"));
	WebElement dargElement=	driver.findElement(By.xpath("//div[@id='draggable']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy (0,200)");
	Actions act=new Actions(driver);
	act.dragAndDrop(dargElement, dropTarget).build().perform();
	}
	public static void main(String[] args) {
		DragAndDrop dragAndDrop=new DragAndDrop();
		dragAndDrop.performDragDrop();
	}
}
