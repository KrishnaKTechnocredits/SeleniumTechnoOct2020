package milind.assignment_5;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;

public class Form_5_TC {
	
	WebDriver driver = PredefinedActions.start();
	
	void testVisibilityOfElement() {
		System.out.println("Check Element is Visible");
		if(driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed()) {
			System.out.println("Element is Visible");
			System.out.println(driver.findElement(By.xpath("//div[@id='myDIV']")).getText());
			System.out.println("Click Hide the Element button");
			driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
			if(driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed()) {
				System.out.println("=====Fail=====");
				System.out.println("Element is not hide");
			}else {
				System.out.println("=====Pass=====");
				System.out.println("Element is hide");
			}
		}else {
			System.out.println("Element is not visible");
			if(!driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed()) {
				System.out.println("Click Hide/Unhide the Element button");
				driver.findElement(By.xpath("//button[text()='Visiable & Hidden Button']")).click();
				if(driver.findElement(By.xpath("//div[@id='myDIV']")).isDisplayed()) {
					System.out.println("Element is visible now");
					System.out.println(driver.findElement(By.xpath("//div[@id='myDIV']")).getText());
				}else {
					System.out.println("Element is not visible still");
				}
			}
		}
	}
	
	void verifyInputTextFieldEnabledOrDisabled() {
		System.out.println("STEP : Verify name textbox field is enabled or not");
		if(driver.findElement(By.xpath("//input[@id='myText']")).isEnabled()) {
			System.out.println("Textbox is enabled");
			System.out.println("STEP : Click disabled button to disabled textbox");
			driver.findElement(By.xpath("//button[text() = 'Enable & Disable Button']")).click();
			System.out.println("STEP : Check Checkbox is Disabled");
			if(!driver.findElement(By.xpath("//input[@id='myText']")).isEnabled()) {
				System.out.println("Success!! Text box is disabled");
			}else {
				System.out.println("Checkbox is not disabled");
			}
		}else {
			System.out.println("Testbox is disabled");
		}
	}
	
	void checkSendkeysInDisabledTextbox() {
		System.out.println("STEP : Refresh the page");
		driver.navigate().refresh();
		System.out.println("STEP : Click the disabled enabled button");
		driver.findElement(By.xpath("//button[text() = 'Enable & Disable Button']")).click();
		System.out.println("STEP : Check textfield is disabled");
		if(driver.findElement(By.xpath("//input[@id='myText']")).isEnabled()) {
			System.out.println("Text field is emanled, Please Disbaled it");
			driver.findElement(By.xpath("//button[text() = 'Enable & Disable Button']")).click();
		}else {
			System.out.println("Text field is disabled");
			System.out.println("STEP : Send date with disabled textbox");
			try {
				driver.findElement(By.xpath("//input[@id='myText']")).sendKeys("Milind");
			}catch(ElementNotInteractableException eie) {
				System.out.println("Exception for interaction with disabled element");
				//eie.printStackTrace();
			}
		}
	}
	
	void elementIsDisabledStillWeCanGetText() throws Exception{
		System.out.println("STEP : Refresh the Page");
		driver.navigate().refresh();
		String name = "Milind";
		String actualName;
		System.out.println("STEP : Enter Text in Name field");
		driver.findElement(By.xpath("//input[@id='myText']")).sendKeys(name);
		System.out.println("STEP : Disabled the Name text field");
		driver.findElement(By.xpath("//button[text() = 'Enable & Disable Button']")).click();
		System.out.println("STEP : Verify Text field is disabled");
		if(driver.findElement(By.xpath("//input[@id='myText']")).isDisplayed()) {
			System.out.println("Name Text field Element is disabled");
			Thread.sleep(10000);
			actualName = driver.findElement(By.xpath("//input[@id='myText']")).getText();
			System.out.println(actualName);
		}else {
			System.out.println("Name text field Element is not disabled");
			throw new Exception();
		}
		System.out.println("STEP : Verify get text from disabled element");
		if(actualName.equals(name)) {
			System.out.println("Success!! We are able to get text from disabled element");
		}else {
			System.out.println("Not able to get text from disabled element");
		}
	}
	

	public static void main(String[] args) throws Exception {
		Form_5_TC form_5_TC = new Form_5_TC();
		form_5_TC.testVisibilityOfElement();
		form_5_TC.verifyInputTextFieldEnabledOrDisabled();
		form_5_TC.checkSendkeysInDisabledTextbox();
		form_5_TC.elementIsDisabledStillWeCanGetText();
		form_5_TC.driver.close();
	}
}






