package com.projectName.companyName.PageObjects;

import com.projectName.companyName.ExtentListeners.ExtentListeners;
import com.projectName.companyName.utilities.DriverManager;

import net.bytebuddy.asm.Advice.Enter;

import java.awt.event.KeyEvent;
import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	
	@FindBy(xpath = "//span[text()='Hello, sign in']")
	private WebElement helloSignIn;
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchTextBox;
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchbutton;
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement cartCount;
	
	
	

	@Override
	protected void getPageScreenSot() {
		picture();
//		newPageScreenShot();
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		
		return ExpectedConditions.visibilityOf(helloSignIn);
	}

	
	public HomePage open(String url) throws Exception {

		DriverManager.getDriver().navigate().to(url);
		ExtentListeners.testReport.get().info("<b>" + "<font color=" + "Green>" + "Application Opened" + "</font>" + "</b>");

		return (HomePage) openPage(HomePage.class);
	}

	
	
	

	public SignInPage goToSignPage() throws Exception {
		
		doClick(helloSignIn, "Sign in Tab");
		return (SignInPage) openPage(SignInPage.class);
	}

	public SearchResultsPage searchProduct(Hashtable<String, String> data) throws Exception {
		
		doEnterText(searchTextBox, data.get("SearchKeyWord"), "Search Text Box");
		doClick(searchbutton, "Search Button");
		return (SearchResultsPage) openPage(SearchResultsPage.class);
	}

	public int getCartCount() {
		String cv = getText(cartCount, "Total Cart");
		ExtentListeners.testReport.get().info("Cart Value "+cv);
		return stringToInt(cv);
			
	}
	
	
	
	
	
//setTimeout(function(){debugger;}, 5000)
}


