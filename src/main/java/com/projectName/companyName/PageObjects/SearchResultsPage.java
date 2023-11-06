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

public class SearchResultsPage extends BasePage {

	@FindBy(xpath = "(//*[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span)/parent::a")
	private WebElement search_result;
	@FindBy(xpath = "//span[text()='Add to Cart']")
	private WebElement addtoCart;

	@Override
	protected void getPageScreenSot() {
		picture();
//		newPageScreenShot();
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(search_result);
	}

	public ProductDetailsPage selectProduct() throws Exception {

		
		doClick(search_result, "First Search Result");
		Thread.sleep(5000);
		
		switchToWindow(1);
		Thread.sleep(5000);

		return (ProductDetailsPage) openPage(ProductDetailsPage.class);
	}

}
