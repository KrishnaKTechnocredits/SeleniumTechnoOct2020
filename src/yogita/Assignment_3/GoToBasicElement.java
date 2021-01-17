package yogita.Assignment_3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoToBasicElement {
	static WebDriver driver;

	static void launchBrowser() {
		String path = "./resources/windows/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("http://automationbykrishna.com/");
		System.out.println("AutomationByKrishna website open successfully.");
		driver.manage().window().maximize();

	}

	static void verifyAlertMsgOnAlerButton(String expectedAlertMsg) {
		System.out.println("Step-Go to Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='javascriptAlert']")).click();
		Alert okAlert = driver.switchTo().alert();
		String actualAlertMsg = okAlert.getText();
		okAlert.accept();
		if (expectedAlertMsg.equals(actualAlertMsg)) {
			System.out.println("Verification Of Alert Button--> Pass");
		} else {
			System.out.println("Verification Of Alert Button --> Failed");
		}
	}

	static void verifyLabelMessageOnJavaScriptConfirmationButton(String expectedOkLabelMsg,
			String expectedCancelLabelMsg) {
		System.out.println("Step-Go to Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		System.out.println("STEP-Click On Javascript Confimation Button");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		System.out.println("STEP-Switching to Alert");
		Alert OkAlert = driver.switchTo().alert();
		System.out.println("STEP-Accepting Alert");
		OkAlert.accept();
		System.out.println("STEP-Finding Ok Label");
		String actualOkLabelMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (expectedOkLabelMsg.equals(actualOkLabelMsg)) {
			System.out.println("Verification Of Ok Label --> Pass");
		} else {
			System.out.println("Verification Of Ok Label --> Failed");
		}
		System.out.println("STEP-Click On Javascript Confimation Button");
		driver.findElement(By.xpath("//button[text()='Javascript Confirmation']")).click();
		System.out.println("STEP-Switching to Alert");
		Alert cancelAlert = driver.switchTo().alert();
		System.out.println("STEP-Dismiss Alert");
		cancelAlert.dismiss();
		System.out.println("STEP-Finding Cancel Label");
		String actualCancelLabelMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		if (expectedCancelLabelMsg.equals(actualCancelLabelMsg)) {
			System.out.println("Verification Of Cancel Label --> Pass");
		} else {
			System.out.println("Verification Of Cancel Label --> Failed");
		}

	}

	static void verifyLabelMessageOnJavaScriptPromptButton(String expectedPrompt) {
		System.out.println("Step-Go to Basic Elements");
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("STEP-Finding Java Script Button");
		driver.findElement(By.xpath("//button[@id='javascriptPromp']")).click();
		System.out.println("STEP-Switch To Alert");
		Alert promptAlert = driver.switchTo().alert();
		System.out.println("STEP-Sending Data to alert field");
		promptAlert.sendKeys("Yogita");
		System.out.println("STEP-Accept Alert");
		promptAlert.accept();
		System.out.println("STEP-Finding Label  ");
		String actualPromptMsg = driver.findElement(By.xpath("//p[@id='pgraphdemo']")).getText();
		System.out.println("STEP-Verifying Label Text");
		if (expectedPrompt.equals(actualPromptMsg)) {
			System.out.println("Verification Of Msg on Java Script Prompt Button -->Pass");
		} else {
			System.out.println("Verification Of Msg on Java Script Prompt Button -->Failed");

		}
	}

	public static void main(String[] args) {
		GoToBasicElement.launchBrowser();
		String expectedAlertMsg = "You must be TechnoCredits student!!";
		GoToBasicElement.verifyAlertMsgOnAlerButton(expectedAlertMsg);
		String expectedOkLabelMsg = "You pressed OK!";
		String expectedCancelLabelMsg = "You pressed Cancel!";
		String expectedPrompt = "Hello Yogita! How are you today?";
		GoToBasicElement.verifyLabelMessageOnJavaScriptConfirmationButton(expectedOkLabelMsg, expectedCancelLabelMsg);
		GoToBasicElement.verifyLabelMessageOnJavaScriptPromptButton(expectedPrompt);
		driver.close();

	}

}
