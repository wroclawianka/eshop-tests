Feature: Bag Management

Scenario: User adds additional instance of the product
  Given user goes to the e-shop page
  When user searches by keyword
  When user adds two products
  And user goes to the bag
  And user adds one more instance of the product
  Then cost is correctly calculated
