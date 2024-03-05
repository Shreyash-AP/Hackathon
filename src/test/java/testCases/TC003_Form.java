package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.WellnessForm;
import factory.BaseClass;

public class TC003_Form extends BaseClass{
	
	public WellnessForm health;
	
	@Test(priority=1, groups={"sanity"})
	public void navigateToHospital() {
		health = new WellnessForm(BaseClass.getDriver());
		BaseClass.getLogger().info("********Starting TC_03_HealthTest********");
		health.clickHealth();
		BaseClass.getLogger().info("********Health & Wellness under FOR CORPORATES header has been clicked********");
		BaseClass.getLogger().info("********Navigated to Health and Wellness Plan page********");
	}
	
	@Test(priority=2, groups={"sanity","regression"})
	public void negativeTesting() throws InterruptedException {
		health = new WellnessForm(BaseClass.getDriver());
		BaseClass.getLogger().info("********Negative testing by providing invalid email has been started********");
		health.setName();
		health.setOrganization();
		health.setContact();
		health.scroll();
		health.setEmail1();
		health.selectOrganization();
		health.selectInterest();
		boolean resultNegative = health.clickButton1();
		Assert.assertEquals(resultNegative, false,"Take a demo button is enabled ");
		BaseClass.getLogger().info("********Negative testing has been done********");
	}
	
    @Test(priority=3, groups={"sanity","regression"})
	public void positiveTesting() throws InterruptedException{
    	health = new WellnessForm(BaseClass.getDriver());
    	health.refresh();
    	BaseClass.getLogger().info("********Health page has been refreshed to refresh the form********");
    	BaseClass.getLogger().info("********Positive testing by providing valid email has been started********");
    	health.setName();
		health.setOrganization();
		health.setContact();
		health.scroll();
		health.setEmail2();
		health.selectOrganization();
		health.selectInterest();
		Thread.sleep(2000);
		boolean resultPositive = health.clickButton2();
		Assert.assertEquals(resultPositive, true,"Take a demo button is disabled ");
		Thread.sleep(12000);
		BaseClass.getLogger().info("********Positive testing has been done********");
	}
    
    @Test(priority=4, groups={"regression"})
    public void displayResponse() {
    	health = new WellnessForm(BaseClass.getDriver());
    	boolean displayText = health.getResponse1();
    	Assert.assertTrue(displayText, "Thank You message is not displayed");
    }

    @Test(priority=5, groups={"regression"})
    public void displayAddResponse() {
    	health = new WellnessForm(BaseClass.getDriver());
    	health.getResponse2();
    	BaseClass.getLogger().info("********Message After successful form submission has been captured********");
    	BaseClass.getLogger().info("********Ending TC_03_HealthTest********");
    }
}