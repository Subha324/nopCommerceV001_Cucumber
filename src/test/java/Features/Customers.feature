Feature: Customers
@sanity
Scenario: Add new Customer
   Given User Launch the Chrome browser
   When User open URL "https://admin-demo.nopcommerce.com"
   And User enters Email as  "admin@yourstore.com" and password as "admin"
   And Click login
   Then User can view Dashboard
   When User Click on customer Menu
   And  Click on Customers Menu item
   And Click on Add new button
   Then User can view Add new customer page
   When User enter Customer info
   And Click on Save button
   Then User can view Confirmation Message "The new customer has been added successfully"
   And Close browser
   
   @sanity
   Scenario: Search Customer by Email Id
     Given User Launch the Chrome browser
   When User open URL "https://admin-demo.nopcommerce.com"
   And User enters Email as  "admin@yourstore.com" and password as "admin"
   And Click login
   Then User can view Dashboard
   When User Click on customer Menu
   And  Click on Customers Menu item
   And Click on Arrowdown button
   And Enter Customer Email
   When Click on Search button
   Then User should found Email in the Serach table
   And Close browser
   
   