Feature: Inventory and Shopping Cart functionality on SauceDemo

# Scenario 3: Sorting items by price from high to low
Scenario: User sorts items by price from high to low
  Given User is logged in to the inventory page
  When User sorts the items by price from high to low
  Then the products should be sorted from highest to lowest price

# Scenario 4: Adding 2 items with price $15.99 to the shopping cart
Scenario: User adds two items with price $15.99 to the cart
  Given User is logged in to the inventory page
  When User sorts the items by price from low to high
  And User adds the items priced at "15.99" $ to the cart
  Then the cart should contain 2 items

# Scenario 5: Checking out and completing the purchase
Scenario: User proceeds to checkout and completes the purchase
  Given User is logged in to the inventory page
  When User sorts the items by price from low to high
  And User adds the items priced at "15.99" $ to the cart
  And User proceeds to checkout and enters first name: "John", last name: "Doe", postal code: "12345"
  Then User should see the checkout summary
  And User should be able to finish the checkout and see the "Checkout: Complete!" message

