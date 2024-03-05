package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.excelUtility;

public class Doctor extends BasePage{
	public Doctor (WebDriver driver)
	{
		super(driver);
		
	}
	
	String data;
	int row=0;
	
	@FindBy(xpath="//span[@data-qa-id='doctor_review_count_selected']")
	public WebElement PatSto;
	
	@FindBy(xpath="//span[text()='10+ Patient Stories']")
	public WebElement AmtPatSto;
	
	@FindBy(xpath="//span[@data-qa-id='years_of_experience_selected']")
	public WebElement Experience;
	
	@FindBy(xpath="//li[@aria-label='5+ Years of experience']")
	public WebElement DocEx;
	
	@FindBy(xpath="//span[text()='All Filters']")
	public WebElement AppFilter;
	
	@FindBy(xpath="//span[text()='Above ₹500']")
	public WebElement Fees;
	
	@FindBy(xpath="//span[text()='Available Tomorrow']")
	public WebElement Avail;
	
	@FindBy(xpath="//span[@data-qa-id='sort_by_selected']")
	WebElement Sort;
	
	@FindBy(xpath="//span[text()='Experience - High to Low']")
	WebElement Metsor;
	
	@FindBy(xpath="//div[@class='u-border-general--bottom']")
	List<WebElement> DocInf;
	
	public void clickPatSto(){
		//System.out.println("*****************");
		PatSto.click();
	}
	
	public void clickAmtPatSto() {
		AmtPatSto.click();
	}
	
	public void clickExp() {
		Experience.click();
	}
	
	public void clickDocEx() {
		DocEx.click();
	}
	
	public void clickAppFilter() {
		
		AppFilter.click();
	}
	
	public void clickFees() {
		Fees.click();
	}
	
	public void clickAvail() {
		Avail.click();
	}
	
	public void clickSOrt() {
		Sort.click();
	}
	
	public void clickMetSor() {
		Metsor.click();
	}
 
	public void DOcInfoM() {
		for(int i=0;i<5;i++) {
			data = DocInf.get(i).getText();
			try {
				excelUtility.write("Sheet1", row, 0, data);
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			row++;
	    	System.out.println(DocInf.get(i).getText());
	    	System.out.println();
	    }
	}
}
