package com.vtest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author ThulasiPrasad
 *
 */
public class ContactusPO {

	@FindBy(xpath = "//input[@name='fname']")
	private WebElement nameLocator;

	@FindBy(xpath = "//input[@name='company']")
	private WebElement companyLocator;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailLocator;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneLocator;

	@FindBy(xpath = "//input[@name='requirement']")
	private WebElement requirementLocator;

	public WebElement getNameLocator() {
		return nameLocator;
	}
	
	public WebElement getCompanyLocator() {
		return companyLocator;
	}

	public WebElement getEmailLocator() {
		return emailLocator;
	}

	public WebElement getPhoneLocator() {
		return phoneLocator;
	}
	
	public WebElement getRequirementLocator() {
		return requirementLocator;
	}
	
	public String getNameValue() {
		return nameLocator.getAttribute("value");
	}
	
	public String getCompanyValue() {
		return companyLocator.getAttribute("value");
	}
	
	public String getEmailValue() {
		return emailLocator.getAttribute("value");
	}
	
	public String getPhoneValue() {
		return phoneLocator.getAttribute("value");
	}
	
	public String getRequirementValue() {
		return requirementLocator.getAttribute("value");
	}
	
	public ContactusPO typeName(String name) {
		nameLocator.sendKeys(name);
		return this;
	}
	
	public ContactusPO typeCompanyName(String companyName) {
		companyLocator.sendKeys(companyName);
		return this;
	}
	
	public ContactusPO typeEmailName(String emailName) {
		emailLocator.sendKeys(emailName);
		return this;
	}
	
	public ContactusPO typePhoneNumber(String phoneNumber) {
		phoneLocator.sendKeys(phoneNumber);
		return this;
	}
	
	
	public ContactusPO typeRequirement(String requirement) {
		requirementLocator.sendKeys(requirement);
		return this;
	}
	
}
