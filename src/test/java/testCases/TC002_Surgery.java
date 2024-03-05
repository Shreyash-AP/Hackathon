package testCases;

import org.testng.annotations.Test;

import pageObjects.Surgery;
import factory.BaseClass;

public class TC002_Surgery extends BaseClass{
	
	public Surgery surgeries;
	
	@Test(priority=1, groups={"sanity"})
	public void navigateToSurgeries() {
		surgeries = new Surgery(BaseClass.getDriver());
		BaseClass.getLogger().info("********Starting TC_02_SurgeryTest********");
		surgeries.clickSurg();;
		BaseClass.getLogger().info("********Surgeries under nav header is clicked********");
		BaseClass.getLogger().info("********Navigated to Surgeries page********");
		//surgeries.scrollToSurgery();
		BaseClass.getLogger().info("********Popular surgeries in surgeries page has been scrolled********");
	}
	
	@Test(priority=2,groups={"sanity","regression"})
	public void displaySurgeryElements() {
		surgeries = new Surgery(BaseClass.getDriver());
		surgeries.SurName();;
		BaseClass.getLogger().info("********All the popular surgeries has been listed********");
		BaseClass.getLogger().info("********Ending TC_02_SurgeryTest********");
	}

}