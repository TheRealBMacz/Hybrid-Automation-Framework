Feature: Products Page Feature

  Background:
    Given user is already logged into the application using the valid credentials
    |username|password|
    |standard_user|secret_sauce|

    Scenario: Products page title validation
      Given user is on the Products page
      When The user gets the title of the page
      Then The title of the page should be "Swag Labs".


      Scenario: available products validation on Products page
        Given user is on the Products page
        Then the user gets the products on the products section
        |Sauce Labs Backpack|
        |Sauce Labs Bike Light|
        |Sauce Labs Bolt T-Shirt|
        |Sauce Labs Fleece Jacket|
        |Sauce Labs Onesie|
        |Test.allTheThings() T-Shirt (Red)|
        And the count of the products displayed should be equal to 6
