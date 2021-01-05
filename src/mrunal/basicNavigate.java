/*Assignment - 1: 
Write a program to cover below methods.
b) navigation cmd:
        1) void navigate().to(String url)
        2) void navigate().forward()
        3) void navigate().back()
        4) void navigate().refresh()*/
package mrunal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicNavigate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//1) void navigate().to(String url)
		String URL = "https://www.irctc.co.in/nget/train-search"; 
		driver.get(URL); 
		
        //3) void navigate().back()
		driver.navigate().to("https://www.emirates.com/in/english/"); 
		
		driver.navigate().back(); 
		String expectedTitle = "IRCTC HOMEPAGE";
		String actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
		
		//2) void navigate().forward()
		driver.navigate().forward(); 
		expectedTitle = "Emirates HOMEPAGE";
		actualTitle = driver.getTitle();
		
		if(expectedTitle.equals(actualTitle))
			System.out.println("Pass");
		else
			System.out.println("Fail");
		
       // 4) void navigate().refresh()
		System.out.println("Refreshing the page ");
		driver.navigate().refresh();
		driver.close();  
		driver.quit();

	}

}
