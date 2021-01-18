package anjaliS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoRadioButtonAndCheckbox {
	static WebDriver driver;

	void start() {
		String path = "./resources/windows/chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();

		driver.get("file:///C:/Users/anjal/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
		System.out.println("TechnoCredit website opened successfully.");
		driver.manage().window().maximize();
	}

	void selectButtonCheckbox() throws InterruptedException {
       driver.findElement(By.id("femaleG")).click();
       System.out.println("Gender selected as: female");
       Thread.sleep(5000);
       WebElement actual=  driver.findElement(By.id("maleG"));
       actual.click();
      // System.out.println("Gender selected as: male");*/
       if(actual.isSelected()){
    	   System.out.println("Gender selected as: male");	   
	}
}
	public static void main(String args[]) throws InterruptedException {
		AutoRadioButtonAndCheckbox abc = new AutoRadioButtonAndCheckbox();
		abc.start();
		abc.selectButtonCheckbox();
	}

}
