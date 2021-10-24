@Smoke
Feature: Verify that admin list is visible for Orange HRM
#Description:
Background: Login using valid credentials
Scenario: As an Orange HRM user, I can select admin under user role
Given open the browser and pass the URL
When Enter username & password and click login
And User verify page title is Orange HRM
#Then User click on admin tab
And User select Admin under user role
And user click on search button
And User verify Dominic Chase is displayed in result set
And user logout of Orange HRM