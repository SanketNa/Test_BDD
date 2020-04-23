## Test_BDD Test automation framework using Selenium with Java, Cucumber and Maven-
This is a sample project to demonstrate what is BDD framework and how it can used in selenium to automate any application.
Cucumber is used as test framework.

##The framework has following features 
1. Modular Design
2. Maven based framework
3. Report Generation (Extent Report) 
4. Centralized Configuration (Using Properties file)
5. POM
6. Page object model and Page Factory followed


## libraries used
Selenium
Cucumber
Extent Reports

## Add the Feature file 

Add the feature file under `src\test\java\features\Test.feature`

Feature: Reset functionality on login page of Application

Scenario: Verification of Reset button
Given Open the Chrome and launch the application
When Enter the Username and Password
Then Search product and in cart
And Verify the Product Page
And Verify the Cart
And Verify the Order Page
  
## Reporting usin Extent Report

Report: `target\cucumber-reports\report.html` 
screenshots: `target\cucumber-reports\Screenshot`  

## Steps to run at your system:
Clone the repository using "git clone <repository url>
Run "mvn clean test"