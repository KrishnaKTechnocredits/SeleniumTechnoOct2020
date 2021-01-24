package monika;

/*Assignment - 1:
Write a program to cover below methods.

a) Browser Cmd :
1) void get(String url)
2) String getCurrentUrl()
3) String getTitle()
4) String getPageSource()
5) void close()
6) void quit()

*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserCommand {
	public static void main(String[] args) {
		String path = "./resources/windows/chromedriver.exe";
		//System.setProperty("Webdriver.chrome.driver",path);
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");
		
	
				String currentUrl = driver.getCurrentUrl();//Verifying the current URL
				String expectedUrl = "https://google.com/";
				if(currentUrl.equals(expectedUrl)) {
					System.out.println("Page loaded successfully");
					
					
					//Verifying the current page title 
					
					String currentPageTitle = driver.getTitle();
					String expectedpageTitle = "Google";
					if(currentPageTitle.equals(currentPageTitle)) {
						System.out.println("We are on the coorect page :"+ currentPageTitle);
						
						//Getting the page source
						String pageSource = driver.getPageSource();
						
						if(pageSource.contains(expectedpageTitle)) {
							System.out.println("All checks pass");
					}
						driver.close();
						//driver.quit();
				}
		
	
}
	}
}
