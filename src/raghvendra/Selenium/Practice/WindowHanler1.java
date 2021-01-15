package raghvendra.Selenium.Practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import raghvendra.base.ConstantAction;

public class WindowHanler1 {
	static WebDriver driver=ConstantAction.start("https://www.naukri.com/");
	public static void main(String[] args) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Set<String>  set1=driver.getWindowHandles();
		System.out.println("Number of windows opened by current browser are:"+set1.size());
		//Iterator<String> itr1=set1.iterator();
		for(String window:set1) {
			driver.switchTo().window(window);
			driver.manage().window().maximize();
		}
		
	}

}
