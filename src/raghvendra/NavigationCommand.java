package raghvendra;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*navigation cmd:
    1) void navigate().to(String url)
    2) void navigate().forward()
    3) void navigate().back()
    4) void navigate().refresh()*/
public class NavigationCommand {

	public static void main(String[] args) {
		String path="./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.navigate().to("https://www.naukri.com/");
		String url=driver.getCurrentUrl();
		System.out.println("Current URL:"+url);
		driver.navigate().back();
		String backUrl=driver.getCurrentUrl();
		System.out.println("Ttile after back:"+backUrl);
		driver.navigate().forward();
		String urlforward=driver.getCurrentUrl();
		System.out.println("Ttile after forward:"+urlforward);
		driver.navigate().refresh();
		String urlAfterRefresh=driver.getCurrentUrl();
		System.out.println("Ttile after refresh:"+urlAfterRefresh);
		driver.quit();
	}
}
