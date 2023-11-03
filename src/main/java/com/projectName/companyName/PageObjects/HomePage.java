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

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[@title='Home']")
	WebElement homeTab;
	@FindBy(xpath = "//a[@title='Calendar']")
	WebElement calendarTab;
	@FindBy(xpath = "//a[@title='Companies']")
	WebElement companiesTab;
	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement contactTab;
	@FindBy(xpath = "//a[@title='New Contact']")
	WebElement newContact;
	@FindBy(xpath = "//a[@title='Deals']")
	WebElement dealsTab;
	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement tasksTab;
	
	
	@FindBy(xpath = "//*[@name='q']")
	WebElement search;

	@Override
	protected void getPageScreenSot() {
		picture();
//		newPageScreenShot();
	}

	@Override
	protected ExpectedCondition getPageLoadCondition() {

		return ExpectedConditions.visibilityOf(homeTab);
	}

	
	
	
	
	public ContactsPage navigateToContactsPage()  {

		doClick(contactTab, "contact Tab");
		

		return (ContactsPage) openPage(ContactsPage.class);
	}

	public ContactsPage addNewContact()  {

		
		moveToElement(contactTab);
		doClick(newContact, "New contact");
		return (ContactsPage) openPage(ContactsPage.class);
	}
	
//setTimeout(function(){debugger;}, 5000)
}


