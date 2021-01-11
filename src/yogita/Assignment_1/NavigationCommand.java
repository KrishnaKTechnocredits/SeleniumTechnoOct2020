/*
  Program_2
   Write a program to cover below methods.
b) navigation cmd:
        1) void navigate().to(String url)
        2) void navigate().forward()
        3) void navigate().back()
        4) void navigate().refresh()

 */

package yogita.Assignment_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommand {
	public static void main(String[] args) throws InterruptedException {

		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		System.out.println("STEP- Launching Blank Chrome Driver");
		WebDriver driver = new ChromeDriver();

		System.out.println("STEP- Launching Google Home Page");
		driver.get("https://www.google.com/");
		String launchGoogle = driver.getCurrentUrl();
		System.out.println(" URL Is:" + launchGoogle);

		System.out.println("STEP- Navigate To Gmail");
		driver.navigate().to("https://mail.google.com/");
		String navigateTo = driver.getCurrentUrl();
		System.out.println("After Navigate_To URL is :" + navigateTo);

		System.out.println("STEP- Navigate Back To Google");
		driver.navigate().back();
		String navigateBack = driver.getCurrentUrl();
		System.out.println("After Navigate_Back URL is: " + navigateBack);
		if (launchGoogle.equals(navigateBack)) {
			System.out.println("Validate Navigate back");
		} else {
			System.out.println("Invalid:Faild");
		}
		driver.navigate().forward();
		String navigateForwrd = driver.getCurrentUrl();
		System.out.println("After Nvaigate Forward URL is: " + navigateForwrd);
		if (navigateTo.equals(navigateForwrd)) {
			System.out.println("Validate Navigate Forward");
		} else {
			System.out.println("Invalid:Failed");
		}

		driver.navigate().refresh();
		String expectedUrl = driver.getCurrentUrl();
		if (navigateForwrd.equals(expectedUrl)) {
			System.out.println(" Validate Refresh");
		} else {
			System.out.println("Invalid");
		}
		System.out.println("STEP-Closing Browser");
		driver.close();

	}
}
