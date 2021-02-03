package raghvendra.TestNG.GeneralPractice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class TestDate {
	
	@Test
	void display() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

		//get current date time with Date()
		Date date = new Date();
		System.out.println(date);
		// Now format the date
		String dateFormatted= dateFormat.format(date);
		String[] date1=dateFormatted.split("/");
		System.out.println(date1[2]);
	
		System.out.println(dateFormatted);
	}

}
