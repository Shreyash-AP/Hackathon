package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.WellnessForm;
import factory.BaseClass;

@SuppressWarnings("deprecation")
public class Healthform {
	WellnessForm health;
	
	@Given("Navigate to Health & Wellness Plans Page")
	public void navigate_to_health_wellness_plans_page() {
		health = new WellnessForm(BaseClass.getDriver());
	}

	@When("the user click on health and wellness plans under for corporates")
	public void the_user_click_on_health_and_wellness_plans_under_for_corporates() {
		BaseClass.getLogger().info("********Starting healthStep********");
		health.clickHealth();
		BaseClass.getLogger().info("********Health & Wellness under FOR CORPORATES header has been clicked********");
		BaseClass.getLogger().info("********Navigated to Health and Wellness Plan page********");
	}

	@When("the user fill the form by reading input from excel")
	public void the_user_fill_the_form_by_reading_input_from_excel() {
		BaseClass.getLogger().info("********Negative testing by providing invalid email has been started********");
		health.setName();
	    health.selectOrganization();
	    health.setContact();
	}

	@When("scrolls the page and passes the invalid email")
	public void scrolls_the_page_and_passes_the_invalid_email() {
	    health.scroll();
	    health.setEmail1();
	    health.selectOrganization();
	    health.selectInterest();
	}

	
	
	@Then("user validates whether the button is disabled")
	public void user_validates_whether_the_button_is_disabled() {
	    boolean result = health.clickButton1();
	    Assert.assertEquals("Take a demo button is enabled", false,result);
	    BaseClass.getLogger().info("********Negative testing has been done********");
	}

	@When("the user refresh the health and wellness page")
	public void the_user_refresh_the_health_and_wellness_page() throws InterruptedException {
	    health.refresh();
	    BaseClass.getLogger().info("********Health page has been refreshed to refresh the form********");
    	BaseClass.getLogger().info("********Positive testing by providing valid email has been started********");
	    health.setName();
	    health.setOrganization();
	    health.setContact();
	}

	@When("scrolls the page and passes the valid email")
	public void scrolls_the_page_and_passes_the_valid_email() throws InterruptedException {
	    health.scroll();
	    health.setEmail2();
	    health.selectOrganization();
	    health.selectInterest();
	    Thread.sleep(2000);
	}

	@Then("user validates whether the button is enabled")
	public void user_validates_whether_the_button_is_enabled() throws InterruptedException {
	    boolean resultPos = health.clickButton2();
	    Assert.assertEquals("Take a demo button is disabled", true, resultPos );
	    Thread.sleep(20000);
	    BaseClass.getLogger().info("********Positive testing has been done********");
	}

	
	@Then("capture the message displayed after successful form submission")
	public void capture_the_message_displayed_after_successful_form_submission() {
		boolean displayText = health.getResponse1();
		Assert.assertTrue("Thank You message is not displayed", displayText);
	    health.getResponse2();
	    BaseClass.getLogger().info("********Message After successful form submission has been captured********");
	    BaseClass.getLogger().info("********Ending healthStep********");
	}



}