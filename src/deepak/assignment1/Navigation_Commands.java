/*
 * /*Assignment-1 : 05 Jan 2021
Write a program to cover below methods
b) Navigation cmd:
1) void navigate().to(String url)
2) void navigate().forward()
3) void navigate().back()
4) void navigate().refresh()
*/

package deepak.assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation_Commands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Launch the url
		driver.navigate().to("https://google.com/");
		
		//Moving forward
		driver.navigate().forward();
		
		//Clicking the link Gmail
		driver.findElement(By.xpath("//body[@id='gsr']")).click();
		
		//Moving Backword
		driver.navigate().back();
		
		//Moving Forward
		driver.navigate().back();
		
		//Refreshingt the page
		driver.navigate().refresh();
		
		System.out.println("All checks Pass");
		
		driver.close();
	}

}
