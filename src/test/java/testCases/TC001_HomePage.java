package testCases;

import org.testng.annotations.Test;

import pageObjects.Doctor;
import pageObjects.FindSearch;
import factory.BaseClass;

public class TC001_HomePage extends BaseClass{
	public Doctor CardioObj;
	
	@Test(priority=1, groups={"sanity"})
	public void location()
	{
		FindSearch homeObj = new FindSearch(BaseClass.getDriver());		
		try {
			BaseClass.getLogger().info("********Starting TC_01_DoctorTest********");
			homeObj.clickCity();
			homeObj.clearCity();
			homeObj.sendCity();
			homeObj.clickLocation();
			BaseClass.getLogger().info("********Location has been selected********");
			homeObj.clickInspec();
			homeObj.sendSpeciality();
			homeObj.clickSPec();
			BaseClass.getLogger().info("********Hospitals has been selected********");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=2,dependsOnMethods= {"location"},groups={"regression"})
	public void patientFilter() throws InterruptedException {
	    CardioObj =  new Doctor(BaseClass.getDriver());
	    BaseClass.getLogger().info("********Navigated to Doctor page********");
		CardioObj.clickPatSto();
		CardioObj.clickAmtPatSto();
		BaseClass.getLogger().info("********Patient Filter has been selected********");
	}
	
	@Test(priority=3, groups={"regression"})
	public void experienceFilter() {
		try {
			CardioObj =  new Doctor(BaseClass.getDriver());
			CardioObj.clickExp();
			CardioObj.clickDocEx();
			Thread.sleep(2000);
			BaseClass.getLogger().info("********Experience Filter has been selected********");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority=4 ,groups={"sanity"})
	public void allFilters() {
		CardioObj =  new Doctor(BaseClass.getDriver());
		//try {
			CardioObj.clickAppFilter();
			BaseClass.getLogger().info("********All Filters has been selected********");
		//} catch (InterruptedException e) {
			//e.printStackTrace();
		//}
	}
	
	@Test(priority=5, groups={"regression"})
	public void feesFilter() {
		CardioObj =  new Doctor(BaseClass.getDriver());
		CardioObj.clickFees();
		BaseClass.getLogger().info("********Select Fees Filter under All Filters has been selected********");
	}
	
	@Test(priority=6, groups={"regression"})
	public void sortFilter() throws InterruptedException {
		CardioObj =  new Doctor(BaseClass.getDriver());
		CardioObj.clickSOrt();
		CardioObj.clickMetSor();
		BaseClass.getLogger().info("********Sort Filter has been selected********");
	}
	
	@Test(priority=7, groups={"regression"})
	public void availableFilter() {
		CardioObj =  new Doctor(BaseClass.getDriver());
		allFilters();
		BaseClass.getLogger().info("********All Filters has been selected********");
		CardioObj.clickAvail();
		BaseClass.getLogger().info("********Availability Filter under All Filters has been selected********");
	}
	
	@Test(priority=8,groups={"sanity","regression"})
	public void displayDoctorInfo() {
		CardioObj =  new Doctor(BaseClass.getDriver());
		CardioObj.DOcInfoM();
		BaseClass.getLogger().info("********First Five Doctors Information has been captured********");
		BaseClass.getLogger().info("********Ending TC_01_DoctorTest********");
	}

}
