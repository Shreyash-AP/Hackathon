package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excelUtility;

public class Surgery extends BasePage {
	JavascriptExecutor js;
	public Surgery (WebDriver driver)
	{
		super(driver);
		
	}
	String data;
	int row=0;
	
	@FindBy(xpath="//div[text()='Surgeries']")
	WebElement title;
	
	@FindBy(xpath="//h1[text()='Popular Surgeries']")
	WebElement Popular;
	
	@FindBy(xpath="//*[@id=\"surgeries\"]/div/div[1]/div/div/div")
	List<WebElement> list;
	
	public void clickSurg() {
		title.click();
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",Popular);
	}
	
	//div[@class="SurgicalSolutions-module_ailmentItemWrapper__Krx-u"]
	@FindBy(xpath="//div[@class=\"SurgicalSolutions-module_ailmentItemWrapper__Krx-u\"]")
	List<WebElement> SurNam;
	
	public void SurName() {
		for(WebElement e : SurNam) {
			data = e.getText();
			try {
				excelUtility.write("Sheet1", row, 1, data);
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			row++;
	    	System.out.println(e.getText());
	    }
	    System.out.println();
		
      }
}