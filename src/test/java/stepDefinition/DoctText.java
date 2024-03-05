package stepDefinition;

import pageObjects.FindSearch;
import pageObjects.Surgery;
import pageObjects.WellnessForm;
import pageObjects.Doctor;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DoctText extends BaseClass {
	FindSearch f;
	Doctor a;
	Surgery s;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WellnessForm w;
	
	@Given("User present on practo.com Website_one")
	public void user_present_on_practo_com_website_one() {
		f = new FindSearch(BaseClass.getDriver()); 
	    a = new Doctor(BaseClass.getDriver());
	    s = new Surgery(BaseClass.getDriver());
	    w = new WellnessForm(BaseClass.getDriver());
	}
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	@When("User enters city Mumbai in seachbox")
	public void user_enters_city_Mumbai_in_seachbox() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    f.clickCity();
	    f.clearCity();
	    f.sendCity();
	    f.clickCity();
	}
	@When("User clicks on Mumbai option")
	public void user_clicks_on_Mumbai_option() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    f.clickLocation();
	}

	
	@When("User enters Medical specialist Cardiologist in seachbox")
	public void user_enters_medical_specialist_cardiologist_in_seachbox() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    f.clickInspec();
	    f.sendSpeciality();
	}
	@When("User clicks on Cardiologist option")
	public void user_clicks_on_cardiologist_option() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		f.clickSPec();
	}
	
	@When("User applies filters")
	public void user_applies_filters() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		a.clickPatSto();
		a.clickAmtPatSto();
		Thread.sleep(3000);
		a.clickExp();
		Thread.sleep(3000);
		a.clickDocEx();
		Thread.sleep(3000);
		a.clickAppFilter();
		Thread.sleep(2000);
		a.clickFees();
		Thread.sleep(3000);
		a.clickAppFilter();
		a.clickAvail();
		Thread.sleep(4000);
		a.clickSOrt();
		Thread.sleep(3000);
		a.clickMetSor();
		Thread.sleep(3000);
		}
	@Then("User displays the first five Doctors")
	public void user_displays_the_first_five_doctors() {
		a.DOcInfoM();
	}

	
	@When("User clicks on Surgeries")
	public void user_clicks_on_surgeries() {
		s.clickSurg();	
	}
	
	@Then("User displays the Surgeries list")
	public void user_displays_the_surgeries_list() {
		s.SurName();
	}
}

