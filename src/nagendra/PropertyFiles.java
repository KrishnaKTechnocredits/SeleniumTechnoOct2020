package nagendra;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import nagendra.base.PredefinedActions;

public class PropertyFiles {
	
	static WebDriver driver=PredefinedActions.start("file:///C:/Users/Nagendra/Documents/Training/Training/SeleniumTechnoOct2020/resources/forms/First_Form_4.html");
	void fillForm() throws IOException{
		File file=new File("./src/nagendra/First_Form_4_form_data");
		FileInputStream inputStream=new FileInputStream(file); 
		Properties prop=new Properties();
		System.out.println("Load Prprty file in memory");
		prop.load(inputStream);
		System.out.println("Enter First Name");
		driver.findElement(By.xpath("//input[@id='first name']")).sendKeys(prop.getProperty("firstname"));
		System.out.println("Enter Last Name");
		driver.findElement(By.xpath("//input[@id='last name']")).sendKeys(prop.getProperty("lastname"));
		System.out.println("Enter E-mail");
		driver.findElement(By.xpath("//input[@id='E-mail']")).sendKeys(prop.getProperty("E-mail"));
		System.out.println("Enter Company");
		driver.findElement(By.xpath("//input[@id='Company Name']")).sendKeys(prop.getProperty("CompanyName"));
		String gender=prop.getProperty("gender");
		System.out.println("Select Gender");
		if(gender.equals("Female"))
			driver.findElement(By.xpath("//input[@id='femaleG']")).click();
		else
			driver.findElement(By.xpath("//input[@id='maleG']")).click();
		String cont=prop.getProperty("continents");
		System.out.println("Select Continents");
		WebElement Continents = driver.findElement(By.xpath("//select[@id='continents']"));
		Select selectCont = new Select(Continents);
		if(cont.contains("North America"))
			selectCont.selectByVisibleText(cont);
		List<WebElement> elements=driver.findElements(By.xpath("//input[@name='experience']"));
		System.out.println("Select experience");
		for(WebElement exp:elements) {
			if(exp.getAttribute("id").equals(prop.getProperty("experience"))) {
				exp.click();
			}
		}
		System.out.println("Enter known programming language");
		driver.findElement(By.xpath("//input[@id='knownlanguage']")).sendKeys(prop.getProperty("knownlanguage"));
		String languages=prop.getProperty("language");
		System.out.println("Select Languages");
		elements=driver.findElements(By.xpath("//input[@name='language']"));
		for(WebElement lang:elements) {
			String lname=lang.getAttribute("id");
			if(languages.contains(lname))
				lang.click();
		}

		elements=driver.findElements(By.xpath("//input[@name='company']"));
		System.out.println("Select Dream Company");
		for(WebElement company:elements) {
			if(company.getAttribute("id").equals(prop.getProperty("dreamCompany"))) {
				company.click();
			}
		}
		System.out.println("Click on I selected required option");
		driver.findElement(By.xpath("//input[@id='confirmDetails']")).click();
		System.out.println("Click on Go and Practice button");
		driver.findElement(By.xpath("//a[text()='Go And Practice For it']")).click();
		String textTitle=driver.getTitle();
		System.out.println("Title of Current page: "+textTitle);
		driver.navigate().back();
		String backHistoryFname=driver.findElement(By.xpath("//input[@id='first name']")).getAttribute("value");
		if(backHistoryFname.equals(prop.getProperty("firstname")))
			System.out.println("First name is still there on First_Form_4.html");
		else
			System.out.println("First name is not there on First_Form_4.html");
		} 

	public static void main(String[] args) {
		try {
			new PropertyFiles().fillForm();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();

	}
}
