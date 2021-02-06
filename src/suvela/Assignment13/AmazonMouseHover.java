package suvela.Assignment13;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import suvela.basic.RequiredActions;

public class AmazonMouseHover {
	static WebDriver driver;

	public void mouseHover() {
		System.out.println("We are on Amazon ");
		WebElement e = driver.findElement(By.xpath("//span[@class='nav-line-2 nav-long-width']"));

		Actions ac = new Actions(driver);
		ac.moveToElement(e).build().perform();
		System.out.println("Hovered on Accounts & Lists!");

		List<WebElement> lists = driver.findElements(By.xpath("//div[@id='nav-al-wishlist']//a"));
		System.out.println("Size of Your Lists is: " + lists.size());
		List<WebElement> accounts = driver.findElements(By.xpath("//div[@id='nav-al-your-account']//a"));
		System.out.println("Size of Your Accounts is: " + accounts.size());
		System.out.println("Script ran successfully!");
		driver.close();
	}

	public static void main(String[] args) {
		driver = RequiredActions.start("https://www.amazon.in/");
		new AmazonMouseHover().mouseHover();

	}

}
