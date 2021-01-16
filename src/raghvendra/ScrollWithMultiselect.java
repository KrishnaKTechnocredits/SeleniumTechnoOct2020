package raghvendra;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import raghvendra.base.ConstantAction;
/*Assignment - 7 : Scroll & MultiSelect 

Step1 : Go to AutomationByKrishna.com
Step2 : navigate to Basic Elements
Step3 : select 1 and 3 value in a multi select dropdown
Step 4 : Verify both values get selected
Step 5 : print all options which not selected.
Step 6 : deselect all selected options
Step 7 : verify none of the options are selected now.*/
public class ScrollWithMultiselect {
	WebDriver driver=ConstantAction.url();
	void scrollAndMultiSelect(String select1,String select3) {
		int count=0;
		System.out.println("Step 1->Go to AutomationByKrishna.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Step2 : navigate to Basic Elements");
		driver.findElement(By.xpath("//a[contains(@id,'basic')]")).click();
		WebElement dropdown=driver.findElement(By.xpath("//select[@class='form-control']"));
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].scrollIntoView(true)", dropdown);
		Select select=new Select(dropdown);
		System.out.println("Step3 : Select 1 and 3 value in a multi select dropdown");
		select.selectByVisibleText(select1);
		select.selectByVisibleText(select3);
		System.out.println("Step4 :Verify both values get selected");
		List<WebElement> allSelectedOptions=select.getAllSelectedOptions();
		for(WebElement option:allSelectedOptions) {
			if(option.getText().equals(select1))
				count++;
			else if (option.getText().equals(select3))
				count++;
			else
				System.out.println("Given Options are not selected");
		}
		if(count==2)
			System.out.println("Given Options 1 & 3 are selected");
		List<WebElement> unselectOption=select.getOptions();
		System.out.println("Step 5 : print all options which not selected");
		for(WebElement option:unselectOption) {
			if(!(option.isSelected()))
				System.out.print(option.getText()+" ");
		}
		System.out.println("\n"+"Step 6 : Deselect all selected options");
		select.deselectAll();
		List<WebElement>allSelectafterDesect=select.getAllSelectedOptions();
		System.out.println("Step 7 : Verify none of the options are selected now");
		if(allSelectafterDesect.size()<1)
			System.out.println("None of items are selected now");
		}
		
	public static void main(String[] args) {
		ScrollWithMultiselect scrollWithMultiselect=new ScrollWithMultiselect();
		String select1="1";
		String select3="3";
		scrollWithMultiselect.scrollAndMultiSelect(select1,select3);
	}
}
