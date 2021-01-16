package raghvendra.Alert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import raghvendra.base.ConstantAction;
/*Program - 3 : Go to Basic element page,
a) verify alert message on "Alert demo" form*/
public class AlertDemo {
	WebDriver driver = ConstantAction.url();
	void alertDemoMessageOnRegistrationPage(String fName,String lName,String company,String expMsg) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//a[@id='basicelements']")).click();
		driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(fName);
		driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(lName);
		driver.findElement(By.xpath("//input[@id='UserCompanyName']")).sendKeys(company);
		driver.findElement(By.xpath("//div[@id='firstRow']/div[1]//button[@type='submit']")).click();
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if(alertText.equals(expMsg)) {
			System.out.println("Testcase Passed");
		}else {
			System.out.println("Testcase Failed");
		}
		alert.accept();
	}

	public static void main(String[] args) {
		String firstName = "Raghvendra";
		String lastName = "Tiwari";
		String companyName = "Quinnox";
		String expectedMessage="Raghvendra and Tiwari and Quinnox";
		AlertDemo alertDemo = new AlertDemo();
		alertDemo.alertDemoMessageOnRegistrationPage(firstName,lastName,companyName,expectedMessage);
		alertDemo.driver.close();
	}
}
