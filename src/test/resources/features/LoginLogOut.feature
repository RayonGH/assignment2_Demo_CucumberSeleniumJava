Feature: Login functionality on SauceDemo

# Scenario 1: Successful login with valid credentials
Scenario: User logs in with valid credentials
  Given User is on the login page
  When User enters correct credentials "standard_user" and "secret_sauce"
  Then User should be redirected to the inventory page

# Scenario 2: Unsuccessful login with invalid credentials (locked_out_user)
Scenario: User logs in with invalid credentials
  Given User is on the login page
  When User enters locked out user credentials "locked_out_user" and "secret_sauce"
  Then User should see the error message "Epic sadface: Sorry, this user has been locked out."