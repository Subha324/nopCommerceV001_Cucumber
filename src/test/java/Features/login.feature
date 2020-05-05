Feature: Login
@regression
Scenario: Successful login with Valid Credentials
Given User Launch the Chrome browser
When User open URL "https://admin-demo.nopcommerce.com"
And User enters Email as  "admin@yourstore.com" and password as "admin"
And Click login
Then Page title should be "Dashboard / nopCommerce administration"
And Click on logout
Then Page title should be "Your store. Login"
And Close browser
@sanity
Scenario Outline: Successful login with Valid Credentials
Given User Launch the Chrome browser
When User open URL "https://admin-demo.nopcommerce.com"
And User enters Email as  "<email>" and password as "<password>"
And Click login
Then Page title should be "Dashboard / nopCommerce administration"
And Click on logout
Then Page title should be "Your store. Login"
And Close browser

Examples:
  |email | password |
  |admin@yourstore.com | admin |
  
