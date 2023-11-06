package com.projectName.companyName.PageObjects;

import com.projectName.companyName.ExtentListeners.ExtentListeners;
import com.projectName.companyName.utilities.DriverManager;

import net.bytebuddy.asm.Advice.Enter;

import java.awt.event.KeyEvent;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SignInPage extends BasePage {

	
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='continue']")
	WebElement next;
	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;
	@FindBy(xpath = "//input[@id='signInSubmit']")
	WebElement signInButton;
	
	
	
	@Override
	protected void getPageScreenSot() {
		picture();
//		newPageScreenShot();
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		
		return ExpectedConditions.visibilityOf(email);
	}

	
	
	
	

	public void loginToApplication() {

		
		
		
	}

	public void loginToApplication(Map<String, String> file) throws Exception {
		
		doEnterText(email, file.get("defaultUserName"),"emailOrPhone");
		doClick(next, "Continue button");
		doEnterText(pwd, file.get("defaultPassword"), "password");
		doClick(signInButton, "Sign In button");
		ExtentListeners.testReport.get().info("User successfully logged in to application");
	}
	
//setTimeout(function(){debugger;}, 5000)
}


