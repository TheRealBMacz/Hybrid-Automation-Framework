Feature: Validate Login to Sauce Labs

  Scenario Outline: Login to Sauce Labs with locked out user

    Given Initialize the Browser with chrome
    And Navigate to the "https://www.saucedemo.com/" site
    When User logs into application with the <username> and <password>
    Then Verify user is thrown an error message saying "Epic sadface: Sorry, this user has been locked out."
    And Close the Browser

    Examples:
      |username	                |password			|
      |standard_user	          |secret_sauce	|
      |locked_out_user	        |secret_sauce	|
      |problem_user	            |secret_sauce	|
      |performance_glitch_user	|secret_sauce	|

