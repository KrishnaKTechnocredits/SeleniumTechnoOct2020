package raghvendra;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import raghvendra.base.ConstantAction;
/*Assignment : 10
1. Open Naukri.com website
2. Close all other windows apart from main window.
3. Switch to main window in the end.
Hint : find main window by title.*/
public class CloseSubWindow {
	WebDriver driver=ConstantAction.start("https://www.naukri.com/");
	void closeSubWindow() {
		System.out.println("Open Naukri.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Get Current window Hanle and Title of main page");
		String getMainWindow=driver.getWindowHandle();
		String beforeTitle=driver.getTitle();
		Set<String> listOfWindow=driver.getWindowHandles();
		System.out.println("Close Other windows apart from main window");
		for(String window:listOfWindow) {
			if(!(getMainWindow.equals(window))) {
				driver.switchTo().window(window);
				System.out.println("Title of closing window: "+driver.getTitle());
				driver.close();
			}
		}
		System.out.println("Switch to main window");
		driver.switchTo().window(getMainWindow);
		System.out.println("Get title of main window after switch");
		String afterSwitchTitle=driver.getTitle();
		if(beforeTitle.equals(afterSwitchTitle))
			System.out.println("Testcase Passed");
		else
			System.out.println("Testcase Failed");
	}
	public static void main(String[] args) {
		CloseSubWindow closeSubWindow=new CloseSubWindow();
		closeSubWindow.closeSubWindow();
	}
}
