package raghvendra;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*Write a program to cover below methods.

a) Browser Cmd :
		1) void get(String url)
		2) String getCurrentUrl()
		3) String getTitle()
        4) String getPageSource()
        5) void close()
        6) void quit()*/
public class BrowserCommand {

	public static void main(String[] args) {
		String path="./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		String url=driver.getCurrentUrl();
		System.out.println("URL of page is: "+url);
		String title=driver.getTitle();
		System.out.println("Ttile of page is: "+title);
		boolean pageSource=driver.getPageSource().contains("Gmail");
		System.out.println("Page Source has Gmail text: "+pageSource);
		driver.close();
	}
}
