package raghvendra.Exam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import raghvendra.base.ConstantAction;

//Validate if userName is combination first name first character and last name all in small
public class validateUserName {
	WebDriver driver=ConstantAction.url();
	ArrayList<String>definedUserName=new ArrayList<String>();
	void checkUserName(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='demotable']")).click();
		List<WebElement>listOfUserName=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
		List<WebElement>listOfFirstName=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[2]"));
		List<WebElement>listOfLastName=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
		ArrayList<String>firstName=new ArrayList<String>();
		ArrayList<String>lastName=new ArrayList<String>();
		for(WebElement element:listOfFirstName) {
			firstName.add(element.getText());
		}
		for(WebElement element:listOfLastName) {
			lastName.add(element.getText());
		}
		defineUserName(firstName,lastName,listOfUserName);
	}
	void defineUserName(List<String>first,List<String>last,	List<WebElement>listOfUserName) {
		boolean flag=true;
		for(int index=0;index<first.size();index++) {
			String computedUserName= first.get(index).substring(0, 1).toLowerCase()+last.get(index).substring(0).toLowerCase();
			definedUserName.add(computedUserName);
		}
		for(WebElement element:listOfUserName) {
			if(!definedUserName.contains(element.getText()))
				System.out.println(element.getText()+" User name is incorrect");
		}
		if(flag)
			System.out.println("All UserNames are correct");
	}
	public static void main(String[] args) {
		validateUserName validateUserName=new validateUserName();
		validateUserName.checkUserName();
	}

}
