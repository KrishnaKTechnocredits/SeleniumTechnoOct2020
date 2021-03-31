package ruby;

/*Assignment 3.*/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

	static WebDriver driver;

	// Open Browser and maximize
	static void start() {
		System.setProperty("webdriver.chrome.driver", "./resources/windows/chromedriver.exe");
		driver = new ChromeDriver();

		System.out.println("Open Browser and launch website");
		driver.get("http://automationbykrishna.com");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("Title is  " + title);
	}

	// *Program - 1 : Verify alert message on Registration Page -> login.
	void verifyMessageOnRegistration() {

		driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);

		System.out.println("Verify alert message on Registration Page --> Login section");
		System.out.println("Step 1: Click on Registration link");
		driver.findElement(By.xpath("//a[@id='registration2']")).click();

		System.out.println("Step 2: Enter Username");
		driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys("rubykh123");

		System.out.println("Step 3: Enter Password");
		driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys("test123");

		System.out.println("Step 4: Click on Button");
		driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

		System.out.println("Step 5: Alert display");
		Alert al = driver.switchTo().alert();
		String loginMsg = al.getText();
		if (loginMsg.equals("Failed! please enter strong password"))
			System.out.println("Message on Alert after Login are same");
		al.accept();
	}

	/*
	 * Program - 2: Go to Basic element page,
	 */
	// a) verify alert message on Alert button.
	void verifyAlerts() {
		System.out.println("Handling Alert");

		System.out.println("Step 1: Verify BasicElements");
		driver.findElement(By.id("basicelements")).click();

		driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
		// System.out.println("Find Button Element");
		WebElement buttonElement = driver.findElement(By.xpath("//button[@id='javascriptAlert']"));

		System.out.println("Step 3: ScrollPage");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();", buttonElement);

		System.out.println("Step 2: Click on Alert button on the Form");
		buttonElement.click();

		System.out.println("Step 3: Alert appear");
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		System.out.println("Step 4: Verify Message on Alert " + actualMessage);
		if (actualMessage.equals("You must be TechnoCredits student!!"))
			System.out.println("Messages on Alert are same : Test cases Pass");

		System.out.println("Step 5: Click on OK on alert");
		alert.accept();
	}

	// b) verify label message on JavaScript Confirmation button
	void verifyConfirmation() {
		System.out.println("Handling Confirmation Box");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.MILLISECONDS);
		// System.out.println("Find Button Element");
		WebElement buttonElement = driver.findElement(By.xpath("//button[@class='btn btn-warning']"));

		// System.out.println("Step 3: ScrollPage");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();", buttonElement);

		System.out.println("Step 1: Click on JavaScript Confirmation button on the Form");
		buttonElement.click();

		System.out.println("Step 2: Confirmation Box appear");
		Alert confirmBox = driver.switchTo().alert();
		String actualMessage = confirmBox.getText();
		System.out.println("Step 3: Verify Message on Confirmation Box " + actualMessage);
		if (actualMessage.equals("Are you are doing your homework regularly, Press Okay else Cancel!!")) {
			System.out.println("Messages on Confirmation are same : Test cases Pass");
			System.out.println("Step 4: Click on OK on Confirmation Box");
			confirmBox.accept();
		} else {
			System.out.println("Step 4: Click on Cancel on Confirmation Box");
			confirmBox.dismiss();
		}
	}

	// c) verify label message on JavaScript prompt button

	public void verifyPromptBox() {
		System.out.println("Handling Prompt Box");
		WebElement buttonElement = driver.findElement(By.xpath("//button[@id='javascriptPromp']"));

		// System.out.println("Scroll the page to find Button ");
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView();", buttonElement);

		System.out.println("Step 1- Click on prompt Button");
		buttonElement.click();

		System.out.println("Step 2- Enter Text in Prompt textbox ");
		Alert prompt = driver.switchTo().alert();
		String text = "Ruby";
		prompt.sendKeys(text);

		System.out.println("Step 3- click on OK button ");
		prompt.accept();

		// System.out.println("Get message after Click on OK button on Prompt box ");
		String actualText = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("Step 4- Verify Message");
		if (actualText.equals("Hello " + text + "! How are you today?"))
			System.out.println("Both the message are same : TestCase Pass");
		else
			System.out.println("Both the messages are not same : Test Case Fail");
	}

	// Program - 3 : Go to Basic element page, a) verify alert message on "Alert
	// demo" form

	public void verifyAlertDemo() {
		System.out.println("Verify alert message on Alert demo form");
		String username = "Ruby";
		String lastname = "Khan";
		String company = "Company";
		System.out.println("Step 1 - Enter Username");
		driver.findElement(By.xpath("//input[@name='ufname']")).sendKeys(username);

		System.out.println("Step 2 - Enter Last Name");
		driver.findElement(By.xpath("//input[@name='ulname']")).sendKeys(lastname);

		System.out.println("Step 3 - Enter Company Name");
		driver.findElement(By.xpath("//input[@name='cmpname']")).sendKeys(company);

		System.out.println("Step 4 - Click on Submit Button");
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		Alert pop = driver.switchTo().alert();
		String actualText = pop.getText();
		if (actualText.equals(username + " and " + lastname + " and " + company))
			System.out.println("Both message are same " + actualText + " Test Case Pass");
		else
			System.out.println("Both message are not same : Test Case Fail");
		pop.accept();
	}

	public static void main(String[] args) {
		HandlingAlerts.start();
		HandlingAlerts al = new HandlingAlerts();
		al.verifyMessageOnRegistration();
		al.verifyAlerts();
		al.verifyConfirmation();
		al.verifyPromptBox();
		al.verifyAlertDemo();
		driver.quit();
	}
}
