package suvela.Assignment12;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import suvela.basic.RequiredActions;

public class BrokenLink {
	static WebDriver driver;
	public void findBrokenLink() throws IOException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Find out whether the given link is broken or missing");
		List<WebElement> list=	driver.findElements(By.tagName("a"));
		for(WebElement e: list) {
			String link= e.getAttribute("href");
			if(link==null || link.isEmpty()) {
				System.out.println("Link for "+ e.getText()+" is Missing ");
			}
			else {
				URL url= new URL(link);
				HttpURLConnection httpcon= (HttpURLConnection) url.openConnection();
				httpcon.connect();
				int statusCode= httpcon.getResponseCode();
				//System.out.println("Link is:"+ link + " and status code is:"+statusCode);
				if(statusCode>400) {
					System.out.println("Broken link is:" +link +" Status code:" +httpcon.getResponseCode());
				}
			}
			
		}
		driver.close();
	}
	public static void main(String[] args) throws IOException {
		driver = RequiredActions.start("file:///F:/Java-Selenium%20course/Suvela-workspace/SeleniumTechnoOct2020/resources/forms/Broken_Link_Form.html");
		new BrokenLink().findBrokenLink();
	}

}
