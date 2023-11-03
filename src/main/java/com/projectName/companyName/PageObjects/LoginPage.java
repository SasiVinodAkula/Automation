package com.projectName.companyName.PageObjects;

import com.projectName.companyName.ExtentListeners.ExtentListeners;
import com.projectName.companyName.utilities.DriverManager;

import net.bytebuddy.asm.Advice.Enter;

import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginPage extends BasePage {

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;

	
	
	@FindBy(xpath = "//*[@name='q']")
	WebElement search;

	@Override
	protected void getPageScreenSot() {
		picture();
//		newPageScreenShot();
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(login);
	}

	
	
	
	
	public LoginPage open(String url) throws Exception {

		DriverManager.getDriver().navigate().to(url);
		ExtentListeners.testReport.get().info("<b>" + "<font color=" + "Green>" + "Application Opened" + "</font>" + "</b>");

		return (LoginPage) openPage(LoginPage.class);
	}

	
	public void searchKword(String value) throws Exception {

		doEnterText(search, value,"Search Field");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		

		}

	public HomePage loginToApplication(String uName, String pwd) throws Exception {

		doEnterText(userName, uName,"User Name Field");
		doEnterText(password, pwd,"Password Field");
		doClick(login, "Login Button");
		return (HomePage) openPage(HomePage.class);

		}

}


