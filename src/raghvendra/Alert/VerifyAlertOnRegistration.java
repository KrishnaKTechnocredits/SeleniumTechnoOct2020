package raghvendra.Alert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import raghvendra.base.ConstantAction;
/*1) Verify alert message on Registration page.

String username = "mkanani";
String password = "mk123";
String expectedMessage = "Failed! please enter strong password";

String username = "maulik.kanani";
String password = "hjp123";
String expectedMessage = "Failed! please enter strong password";

String username = "mkanani";
String password = "mk12312312";
String expectedMessage = "Success!";*/
public class VerifyAlertOnRegistration {
	WebDriver driver = ConstantAction.url();
	
	void validateAlertOnRegistration(String username,String password,String expectedMessage) {
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
	System.out.println("Open Registartion Screen");
	driver.findElement(By.xpath("//a[@id='registration2']")).click();
	String text=driver.findElement(By.xpath("//a[@id='registration2']")).getText();
	System.out.println("Screen name: "+text);
	driver.findElement(By.xpath("//input[@id='unameSignin']")).clear();
	driver.findElement(By.xpath("//input[@id='unameSignin']")).sendKeys(username);
	String enteredUserName=driver.findElement(By.xpath("//.//input[@id='unameSignin']")).getAttribute("value");
	System.out.println("Entered User Name is: "+enteredUserName);
	driver.findElement(By.xpath("//input[@id='pwdSignin']")).clear();
	driver.findElement(By.xpath("//.//input[@id='pwdSignin']")).sendKeys(password);
	String enteredPassword=driver.findElement(By.xpath("//.//input[@id='pwdSignin']")).getAttribute("value");
	System.out.println("Entered Password is: "+enteredPassword);
	driver.findElement(By.xpath(".//button[@id='btnsubmitdetails']")).click();
	Alert alert = driver.switchTo().alert();
	String actualTextFromAlert = alert.getText();
	System.out.println("Actual Alert message: "+actualTextFromAlert);
	alert.accept();
	if(expectedMessage.equals(actualTextFromAlert)) 
		System.out.println("Testcase passed");
	else
		System.out.println("Testcase Failed");

	}
	
	public static void main(String[] args) {
		String username = "mkanani";
		String password = "mk123";
		String expectedMessage = "Failed! please enter strong password";
		new VerifyAlertOnRegistration().validateAlertOnRegistration(username,password,expectedMessage);
		System.out.println("------------------------------------------------------------");
		String username1 = "maulik.kanani";
		String password1 = "hjp123";
		String expectedMessage1 = "Failed! please enter strong password";
		new VerifyAlertOnRegistration().validateAlertOnRegistration(username1,password1,expectedMessage1);
		System.out.println("------------------------------------------------------------");
		String username2 = "mkanani";
		String password2 = "mk12312312";
		String expectedMessage2 = "Success!";
		new VerifyAlertOnRegistration().validateAlertOnRegistration(username2,password2,expectedMessage2);
	}

}
