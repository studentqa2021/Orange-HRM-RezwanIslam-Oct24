package com.step.definition;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.generic.BaseConfig;
import com.generic.DriverManager;
import com.generic.MasterPageFactory;
import com.util.Highlighter;
import com.util.Screenshot;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminListStepDef {
	WebDriver driver;
	MasterPageFactory mpf;
	Select sc;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	@Given("open the browser and pass the URL")
	public void open_the_browser_and_pass_the_url() {
	    
		driver = new DriverManager().getDriver();
	    
	}

	@When("Enter username & password and click login")
	public void enter_username_password_and_click_login() {
		mpf = new MasterPageFactory(driver);
		
		Highlighter.addColor(driver, mpf.getUsername());
		mpf.getUsername().sendKeys(BaseConfig.getConfigValue("username"));
		
		Highlighter.addColor(driver, mpf.getPassword());
		mpf.getPassword().sendKeys(BaseConfig.getConfigValue("password"));
		
		Screenshot.getScreenShot(driver, "Login Page");
		
		Highlighter.addColor(driver, mpf.getLoginbtn());
		mpf.getLoginbtn().click();
	    
	}

	@When("User verify page title is Orange HRM")
	public void user_verify_page_title_is_orange_hrm() {
	    if(mpf.getPageTitle().isDisplayed()) {
	    	System.out.println("Login is succesful!");
	    	Assert.assertTrue(mpf.getPageTitle().isDisplayed(), "Login passed");
	    }else {
	    	System.out.println("Login is unsuccesful!");
	    	Assert.assertTrue(mpf.getPageTitle().isDisplayed(), "Login failed");
	    }
	    Screenshot.getScreenShot(driver, "Home page after login");
	}

	@Then("User click on admin tab")
	public void user_click_on_admin_tab() {
		Highlighter.addColor(driver, mpf.getAdmintab());
	    mpf.getAdmintab().click();
	}

	@Then("User select Admin under user role")
	public void user_select_admin_under_user_role() {
	    Highlighter.addColor(driver, mpf.getUserRole());
	    sc = new Select(mpf.getUserRole());
	    sc.selectByVisibleText("Admin");
	}

	@Then("user click on search button")
	public void user_click_on_search_button() {
	    
	    mpf.getSearchbtn().click();
	}

	@Then("User verify Dominic Chase is displayed in result set")
	public void user_verify_dominic_chase_is_displayed_in_result_set() {
	    
	    if(mpf.getDominicChase().isDisplayed()) {
	    	System.out.println("Dominic Chase is present in admin.");
	    	Assert.assertTrue(mpf.getDominicChase().isDisplayed(), "Dominic Chase is displayed in result set.");
	    }else {
	    	System.out.println("Dominic Chase is not present in admin.");
	    	Assert.assertTrue(mpf.getDominicChase().isDisplayed(), "Dominic Chase is not displayed in result set.");
	    }
	}

	@Then("user logout of Orange HRM")
	public void user_logout_of_orange_hrm() {
		Highlighter.addColor(driver, mpf.getWelcomebtn());		
	    mpf.getWelcomebtn().click();
	    
	    wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.elementToBeClickable(mpf.getLogoutbtn()));
	    
	    Highlighter.addColor(driver, mpf.getLogoutbtn());	
	    mpf.getLogoutbtn().click();
	    
	    driver.quit();
	}

}
