package com.projectName.companyName.testcases;



import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.projectName.companyName.ExtentListeners.ExtentListeners;
import com.projectName.companyName.PageObjects.*;
import com.projectName.companyName.utilities.*;


public class TC001 extends BaseTest {

	
	
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="masterDP")
	public void verifyUserAbletoAddProductToCart(Hashtable<String,String> data) throws Exception {
		
		ExcelReader excel = new ExcelReader(Constants.SUITE1_XL_PATH);
		
		DataUtil.checkExecution("master", "verifyUserAbletoAddProductToCart", data.get("Runmode"), excel);
		log.info("Inside Test");		
		openBrowser(data.get("browser"));	
		HomePage homePage= new HomePage().open(file.get("testsiteurl"));
		SignInPage signPage = homePage.goToSignPage();
		signPage.loginToApplication(file);
		int cartValue = homePage.getCartCount();
		cartValue = cartValue+1;
		SearchResultsPage searchResultsPage =homePage.searchProduct(data);
		ProductDetailsPage productDetailsPage = searchResultsPage.selectProduct();
		productDetailsPage.addtoCart();
		int NewCartValue = homePage.getCartCount();
		SoftAssert st = new SoftAssert();
		st.assertEquals(cartValue, NewCartValue);
		st.assertAll();
		ExtentListeners.testReport.get().info("Cart value updated successfully after adding product to cart: "+cartValue);
		
		

//		Assert.fail("Failing the login test");
	}

	@AfterMethod
	public void tearDown() {
		
		logInfo("Test Completed");
		
		quit();
		
	}

}
