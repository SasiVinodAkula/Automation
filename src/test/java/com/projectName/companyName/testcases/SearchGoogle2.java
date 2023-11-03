package com.projectName.companyName.testcases;



import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.projectName.companyName.PageObjects.*;
import com.projectName.companyName.utilities.*;


public class SearchGoogle2 extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void searchGoogle2(Hashtable<String,String> data) throws Exception {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		
		DataUtil.checkExecution("master", "searchGoogle2", data.get("Runmode"), excel);
		log.info("Inside Test");		
		openBrowser(data.get("browser"));
		
		LoginPage loginPage = new LoginPage().open(file.get("testsiteurl"));
		HomePage homePage=loginPage.loginToApplication(file.get("defaultUserName"), file.get("defaultPassword"));
		ContactsPage contactsPage = homePage.navigateToContactsPage();
		
		
//		logPassed("Test case Passed");

//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Test Completed");
		
		quit();
		
	}

}
