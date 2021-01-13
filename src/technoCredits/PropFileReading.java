package technoCredits;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropFileReading {

	public static void main(String[] args) throws IOException {
		File file = new File("./src/technoCredits/config/confData.properties");
		FileInputStream inputStream = new FileInputStream(file);
		
		Properties prop = new Properties();
		prop.load(inputStream);
		
		String username = prop.getProperty("username");
		System.out.println(username);
		
		String lang = prop.getProperty("lang");
		String[] temp = lang.split(",");
		for(String currentLang : temp) {
			System.out.println(currentLang);
		}
		
		String temp1 = prop.getProperty("UserName");
		System.out.println(temp1);
		
		String exp = prop.getProperty("yearsofexp");
	}
}
