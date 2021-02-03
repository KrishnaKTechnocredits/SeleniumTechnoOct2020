package ankita.practise;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import technoCredits.base.PredefinedActions;

public class Ex1 {

	public static void main(String[] args) {
		int cnt = 1;
		int row = 5;
		String str = "java";
		for(int i=0;i<str.length();i++) {
			for(int j=0;j<=i ;j++)
				System.out.print(str.charAt(j));
			System.out.println();
		}
	}
}
