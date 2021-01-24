package deepak.assignment12;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import deepak.methods.UtilityMethods;

public class MissingAndBrokenLinks {
	
	static WebDriver driver;
	
	public static void findMissingAndBrokenLinks() throws IOException {
		
		//Step1: Finding all the links
		System.out.println("Step1: Finding all the links");
		java.util.List<WebElement> List = driver.findElements(By.xpath("//a"));
		
		//Step2 : Checking link is missing or broken
		System.out.println("//Step2 : Checking list is missing or broken");
		for(WebElement list : List) {
			
			String link = list.getAttribute("href");
			
			if(link == null || link.isEmpty()) {
				System.out.println("Link "+ list.getText() + " is missing");
			}
			else {
				
				URL url = new URL(link);
				HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
				con.connect();
				int responseCode = con.getResponseCode();
				//String responseMessage = con.getResponseMessage();
				
				if(responseCode >=400) {
					System.out.println(list.getText() +" "+ responseCode);
				}
			}
		}
		
		System.out.println("----------Test Pass-----------");
	}
	
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		
		driver = UtilityMethods.start("file:///G:/Technocredits/Selenium_Technocredits/SeleniumTechnoOct2020/resources/forms/Broken_Link_Form.html");
		findMissingAndBrokenLinks();
		driver.close();
	}		
		
}
