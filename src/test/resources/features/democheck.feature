@ui @democheck
Feature: E-commerce application demo check


Background: Navigation to the base URL of application
Given user navigate to the home application url
@ValidationS1
Scenario: user navigate to the home application url
When  Validate header section buttons of homepage


@SubscriptionS2
Scenario:  After launching url User is able to see, enter an email id  under subscription
Given User see SUBSCRIPTION Lable
When  User enter email id "urmiladeshmuk8181@gmail.com"
And Click on Arrow button 
Then Validate User has been successfully subscribed


@ErrorMessageValidation
Scenario: Verify Login Functionality
 Given User Navigate to Login Page
When User enters "<username1>" and "<password1>"
| username1 | password1 |
| Employee_1 | Welc@345 |
| Employee_2 | Test@542 |


#Scenario Outline: User is able to visit application login page and with valid credentials able to login in app
#Given user clicks on Signup/login button form top header section
#When user redirected to login page with title as "Automation Exercise - Signup / Login"
#And url for the login page contains "login" as keyword
#And user able to see "Login to your account" section on login page
#And user enters valid registered email id as "ciwika1748@frandin.com "
#And user enters valid password as "123456.Abc"
#And click on login button
#Then with "Ryan Wick" as user name just after Logged in as button
#And click on logout
@RegUserLoginS4
Scenario Outline: User is able to visit application login page and with valid credentials able to login in app
Given user clicks on Signup/login button form top header section
When user redirected to login page with title as "Automation Exercise - Signup / Login"
And url for the login page contains "login" as keyword
And user able to see "Login to your account" section on login page
And user enters valid registered email id as "<username> "
And user enters valid password as "<pw>"
And click on login button
Then with "<name>" as user name just after Logged in as button
And click on logout

Examples:
|username|pw|name|
|ciwika1748@frandin.com|123456.Abc|Ryan Wick|
|ciwika1744@frandin.com |123456.Abc|James Richard|
