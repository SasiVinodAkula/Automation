package com.projectName.companyName.testcases;



import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.projectName.companyName.PageObjects.*;
import com.projectName.companyName.utilities.*;






public class ActiveMembersLoginTest extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void loginTest(Hashtable<String,String> data) throws Exception {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		DataUtil.checkExecution("master", "LoginTest", data.get("Runmode"), excel);
		log.info("Inside Login Test");		
		openBrowser(data.get("browser"));
		
//
		FacebookPage home = new FacebookPage().open(getTestSiteURL());
//		home.getCred(getDefaultUserName(),getDefaultPassword());
//		checkoutPage.purchase(getDefaultUserName(),getDefaultPassword());
		
//		logPassed("Test case Passed");

//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Login Test Completed");
		
		quit();
		
	}

}
