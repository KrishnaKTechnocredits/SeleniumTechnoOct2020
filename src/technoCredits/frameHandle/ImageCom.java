package technoCredits.frameHandle;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

public class ImageCom {

	
	public static void main(String[] args) throws Exception {
		String os = System.getProperty("os.name").toLowerCase();
		System.out.println("os : "+ os);
		String path = os.contains("windows") ? "./resources/windows/chromedriver.exe"
				: os.contains("mac") ? "./resources/mac/chromedriver" : null;

		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationbykrishna.com/index.html");
		WebElement e = driver.findElement(By.xpath("//img//parent::a[@href='index.html']/img"));

		Thread.sleep(2000);
		Screenshot logoImageScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider())
				.takeScreenshot(driver, e);

		ImageIO.write(logoImageScreenshot.getImage(), "png",
				new File("C:\\Users\\harsh\\OneDrive\\Desktop\\New folder\\Inkedtechnochange_LI.jpg"));

		BufferedImage expectedImage = ImageIO
				.read(new File("C:\\Users\\harsh\\OneDrive\\Desktop\\New folder\\update.jpg"));
		BufferedImage actualImage = logoImageScreenshot.getImage();

		ImageDiffer imgdiffer = new ImageDiffer();

		ImageDiff imgdiff = imgdiffer.makeDiff(expectedImage, actualImage);

		if (imgdiff.hasDiff()) {
			System.out.println("Diff Image");
		}

	}
}
