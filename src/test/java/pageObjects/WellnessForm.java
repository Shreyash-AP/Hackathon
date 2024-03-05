package pageObjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilities.excelUtility;

public class WellnessForm extends BasePage {

	public WellnessForm(WebDriver driver) {
		super(driver);
	}
	 
	String data;
	int row=0;
 
	String writeData[] = excelUtility.read();
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath="//span[text()='For Corporates']")
	WebElement corporateIcon;
	
	@FindBy(xpath="//a[text()='Health & Wellness Plans']")
	WebElement healthOption;
	
	@FindBy(xpath="(//input[@placeholder='Name'])[1]")
	WebElement nameInput;
	
    @FindBy(xpath="(//input[@placeholder='Organization Name'])[1]")
	WebElement organizationInput;	
    
    @FindBy(xpath="(//input[@id='contactNumber'])[1]")
    WebElement contactInput;
    
    @FindBy(xpath="(//input[@id='officialEmailId'])[1]")
    WebElement emailInput;
    
    @FindBy(xpath="(//select[@name='organizationSize'])[1]")
    WebElement clickOrgani;
    
    @FindBy(id="interestedIn")
    WebElement clickInterest; 
    
    @FindBy(xpath="(//button[text()='Schedule a demo'])[2]")
    WebElement buttonSchedule;
    
    @FindBy(xpath="(//div[text()='THANK YOU'])[2]")
    WebElement response1;
    
    @FindBy(xpath="(//div[starts-with(@class,'u-m-t--10')])[2]")
    WebElement response2;
	
	public void clickHealth() {
		corporateIcon.click();
		healthOption.click();
	}
	
	public void setName() {
		js.executeScript("arguments[0].click();", nameInput);
		nameInput.sendKeys(writeData[0]);
	}
	
	public void setOrganization() throws InterruptedException {
		organizationInput.click();
		Thread.sleep(2000);
		organizationInput.sendKeys(writeData[1]);
	}
	
	public void setContact() {
		contactInput.click();
		contactInput.sendKeys(writeData[2]);
	}
	
	public void scroll() {
		js.executeScript("arguments[0].scrollIntoView();", contactInput);
	}
	
	public void setEmail1() {
		emailInput.click();
		emailInput.sendKeys(writeData[3]);
	}
	
	public void selectOrganization() {
		clickOrgani.click();
		Select select =  new Select(clickOrgani);
	    select.selectByValue("<=500");
	}
	
	public void selectInterest() {
		clickInterest.click();
		Select select =  new Select(clickInterest);
	    select.selectByValue("Taking a demo");
	}
	
	public boolean clickButton1() {
		System.out.println();
		if(buttonSchedule.isEnabled()) {
			System.out.println("Take a demo button is enabled");
		}
		else {
	    	System.out.println("Take a demo button is disabled because email id is invalid");
	    	System.out.println();
	    }
		boolean bool = buttonSchedule.isEnabled();
		return bool;
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}

	public void setEmail2() {
		emailInput.click();
		emailInput.sendKeys(writeData[4]);
	}
	
	public boolean clickButton2() {
		js.executeScript("arguments[0].click();", buttonSchedule);
		boolean boolButton = buttonSchedule.isEnabled();
		return boolButton;
		
	}
	
	public boolean getResponse1() {
		System.out.println();
		data = response1.getText();
		try {
			excelUtility.write("Sheet1", row, 2, data);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		row++;
		System.out.println(response1.getText());
		boolean res = response1.isDisplayed();
		return res;
	}
	
	public void getResponse2() {
		data = response2.getText();
		try {
			excelUtility.write("Sheet1", row, 2, data);
		} catch (IOException e1) {
			e1.printStackTrace();
		}	
		
		System.out.println(response2.getText());
		System.out.println();
	}
	
	
	
}