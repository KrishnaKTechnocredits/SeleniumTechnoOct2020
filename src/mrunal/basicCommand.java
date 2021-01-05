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
package mrunal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicCommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String URL = "https://www.irctc.co.in/nget/train-search"; //1) void get(String url)
		driver.get(URL);  
		
	    String CurrentUrl = driver.getCurrentUrl(); //2) String getCurrentUrl()
		System.out.println("Current URL is :" + CurrentUrl );

	    String PageSource = driver.getPageSource(); //4) String getPageSource()
	    System.out.println(PageSource);

		String title = driver.getTitle();  //3) String getTitle()
		System.out.println("title is :" + title );
		
		  
	
		driver.close();  
		driver.quit();


		

	}

}
