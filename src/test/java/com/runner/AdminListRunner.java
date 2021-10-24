package com.runner;

import org.testng.annotations.AfterClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(publish = true,plugin = { "pretty", 
		"html:target/site/cucumber-pretty", "rerun:target/rerun.txt",
		"json:target/cucumber.json",
		},

		features = { "src/test/resources/Admin List.feature" }, 
		glue = { "com.step.definition" }, // package name
		monochrome = true, //remove all ?? & console will be easily readable
		dryRun = true, //check feature file
		strict = true //check stepdef
		,tags= "@Smoke"

)



public class AdminListRunner extends AbstractTestNGCucumberTests{
	ExtentReports extent;
	ExtentTest test;
	
	@AfterClass
	public void writeExtentReport() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("target/AdminList.html");
		reporter.config().setDocumentTitle("Orange HRM Admin List Automation");
		reporter.config().setReportName("Smoke test");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Company ", "SMART TECH");
		extent.setSystemInfo("Testing environment ", "QA");
		extent.setSystemInfo("Team ", "QA");
		extent.setSystemInfo("Tester Name: ", System.getProperty("user.name"));
		
		test = extent.createTest("Smoke Test-Login");
		
		extent.flush();
	}

}
