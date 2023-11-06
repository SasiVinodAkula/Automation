package com.projectName.companyName.PageObjects;

import com.projectName.companyName.ExtentListeners.ExtentListeners;
import com.projectName.companyName.utilities.DriverManager;

import net.bytebuddy.asm.Advice.Enter;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailsPage extends BasePage {

	
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement addtoCart;
	
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;
	
	@FindBy(xpath = "//a[@id='attach-close_sideSheet-link']")
	WebElement close_sideSheet;
	
	@Override
	protected void getPageScreenSot() {
		picture();
//		newPageScreenShot();
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

	
		return ExpectedConditions.visibilityOf(addtoCart);
	}

	
	
	
	
	public boolean addtoCart() throws Exception  {

//		doClick(addtoCart, "Add To Cart");
		doActionsClick(addtoCart,"Add to Cart");
		doClick(close_sideSheet, "close Side Sheet");
		Thread.sleep(2000);
//		doActionsClick(proceedToCheckout);
//		doClick(proceedToCheckout, "Proceed To Checkout");
		return true;

		
	}

	
	

}


