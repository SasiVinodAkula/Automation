package com.projectName.companyName.testcases;



import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.projectName.companyName.PageObjects.*;
import com.projectName.companyName.utilities.*;


public class SearchGoogle extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void searchGoogle(Hashtable<String,String> data) throws Exception {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		
		DataUtil.checkExecution("master", "searchGoogle", data.get("Runmode"), excel);
		log.info("Inside Test");		
		openBrowser(data.get("browser"));
		LoginPage homePage = new LoginPage().open(file.get("testsiteurl"));
		homePage.searchKword(data.get("SearchKeyword"));

		
		
//		logPassed("Test case Passed");

//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Test Completed");
		
		quit();
		
	}

}
