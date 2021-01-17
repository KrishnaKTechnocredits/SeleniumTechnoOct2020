/*Exam-1-Validation on Tabledata using List and String methods */

package kajol.codingExam1.webtable;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import kajol.predefinedMethods.DriverMethods;

public class TableDataValidation {
	static WebDriver driver;
	void validateUsernameofEmployees() {
		System.out.println("1.Launch http://automationbykrishna.com/ ");
		System.out.println();
		driver = DriverMethods.start();
		System.out.println();
		System.out.println("2.Click On Demo Tables:");
		driver.findElement(By.linkText("Demo Tables")).click();
		System.out.println("3.Validate Username of all Employees from Basic Information Table");
		List<WebElement> webElements=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		for (WebElement element:webElements) {
			Boolean validationCondition=(element.findElement(By.xpath("./td[2]")).getText().toLowerCase().charAt(0) + element.findElement(By.xpath("./td[3]")).getText().toLowerCase()).equals(element.findElement(By.xpath("./td[4]")).getText());
			if (!validationCondition) 
				System.out.println(element.findElement(By.xpath("./td[4]")).getText()+" is not valid Username");		
			else
				System.out.println(element.findElement(By.xpath("./td[4]")).getText()+" is valid Username");		
		
		}
	}
		
	public static void main(String[] args) {
		try {
			new TableDataValidation().validateUsernameofEmployees();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				driver.quit();
			}
	}
}
