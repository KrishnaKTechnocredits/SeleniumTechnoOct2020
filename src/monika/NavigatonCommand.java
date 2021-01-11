package monika;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatonCommand {
	public static void main(String[] args) {
		String path = "./resources/windows/chromedriver.exe";
		//System.setProperty("Webdriver.chrome.driver",path);
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		//navigate to google or launch the google
		driver.navigate().to("https://google.com/");
		
		//driver.navigate().forward();
		
		driver.navigate().refresh();
		System.out.println("page is refreshing");
		
		driver.navigate().back();
		System.out.println("Back is wrking");
		
		driver.navigate().forward();
		
	

}
}

