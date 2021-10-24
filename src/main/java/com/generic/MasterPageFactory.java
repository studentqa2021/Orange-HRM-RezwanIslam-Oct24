package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactory {

	public MasterPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='txtUsername']")
	private WebElement username;
	
	@FindBy(xpath="//*[@id='txtPassword']")
	private WebElement password;
	
	@FindBy(xpath="//*[@id='btnLogin']")
	private WebElement loginbtn;
	
	@FindBy(xpath="//img[@alt='OrangeHRM']")
	private WebElement pageTitle;
	
	@FindBy(xpath="(//*[contains(text(),'Admin')])[1]")
	private WebElement admintab;
	
	@FindBy(xpath="//*[@id='searchBtn']")
	private WebElement searchbtn;
	
	@FindBy(xpath="//*[contains(text(),'Dominic.Chase')]")
	private WebElement dominicChase;
	
	@FindBy(xpath="//*[@id='welcome']")
	private WebElement welcomebtn;
	
	@FindBy(xpath="//*[contains(text(),'Logout')]")
	private WebElement logoutbtn;
	
	@FindBy(xpath="//*[@id='searchSystemUser_userType']")
	private WebElement userRole;

	public WebElement getUserRole() {
		return userRole;
	}

	public WebElement getLogoutbtn() {
		return logoutbtn;
	}

	public WebElement getWelcomebtn() {
		return welcomebtn;
	}

	public WebElement getDominicChase() {
		return dominicChase;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getAdmintab() {
		return admintab;
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getUsername() {
		return username;
	}
	
}
