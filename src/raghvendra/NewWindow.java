package raghvendra;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import raghvendra.base.ConstantAction;
/*2. Verify that by click on any button on form new window is opening
Note: use Window_Handling Form from resources*/
public class NewWindow {
	void openFormNewWindow() {
		WebDriver driver=ConstantAction.start("file:///C:/Java%20Selenium/Oct22/SeleniumTechnoOct2020/resources/forms/Window_Handling_Form.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String currentWinHandle=driver.getWindowHandle();
		System.out.println("Current Window Handle"+currentWinHandle);
		System.out.println("Click on First link");
		driver.findElement(By.xpath("//button[text()='First Window']")).click();
		Set<String> set=driver.getWindowHandles();
		String firstLink="";
		System.out.println(set);
		for(String st:set) {
			if(!(st.equals(currentWinHandle))) {
				driver.switchTo().window(st);
				firstLink=driver.getWindowHandle();
				System.out.println("Moved to new window, handle name:"+firstLink);
			}
		}
	}
	public static void main(String[] args) {
		new NewWindow().openFormNewWindow();
	}
}
