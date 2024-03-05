package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FindSearch extends BasePage {
       
	public FindSearch (WebDriver driver)
	{
		super(driver);
		
	}
		
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
	WebElement City;
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement Inspec;
	
	@FindBy(xpath="//span[normalize-space()='Cardiologist']")
	WebElement SPec;
	
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-main'][text()='Mumbai']")
	//@FindBy(xpath="//div[text()='Search in entire Mumbai']")
	WebElement Loc;
	
	
	public void clickCity(){
		City.click();
	}
	public void clearCity() {
		City.clear();
	}
	
	public void sendCity() {
		City.sendKeys("Mumba");
	}
	public void clickInspec() {
		Inspec.click();
	}
	
	public void sendSpeciality() {
		Inspec.sendKeys("Cardiolo");
	}
	
	public void clickSPec() {
		SPec.click();
	}
	
	public void clickLocation() {
		Loc.click();
	}
}
