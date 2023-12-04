@ui @democheck
Feature: E-commerce application demo check

Background: Navigation to the base URL of application
Given user navigate to the home application url

@ValidationOflandingpageElement
Scenario:  Validate the header elements
Given user navigate to the home application url
When  user header over to Home Page
Then  Options underheader section 
  |  Home		 |
  |  Products  |
  |  Cart  |
  | Signup / Login|
  | Test Cases|
  |  API Testing |
  |  Video Tutorials  |
  |   Contact us|

@Subscription
Scenario:  After launching url User is able to see, enter an email id  under subscription
Given User see SUBSCRIPTION Lable
When  User enter email id "urmiladeshmukh@gmail.com"
And Click on Arrow button 
Then Validate User has "You have been successfully subscribed!"

@ErrorMessageValidation
Scenario Outline: Verify Login Functionality
 Given User Navigate to Login Page
When user enters email id as "<Username> "
And user enters password as "<Password>"
And checking click on login button 
Then Validation of  Error message "Your email or password is incorrect!"
Examples:
| Username | Password |
| Tom@gmail.com | Welc@345 |
| Jerry@gmail.com | Test@542 |
| Bheem@gmail.com | Test@542 |


@RegUserLogin
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
