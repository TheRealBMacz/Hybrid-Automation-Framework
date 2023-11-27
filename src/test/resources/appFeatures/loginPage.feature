Feature: Validate Login to Sauce Labs

  Scenario:Login Page title validation
    Given The user is in SwagLabs Login Page
    And The Login Page Logo is displayed
    When The user gets the title of the page
    Then The title of the page should be "Swag Labs".

  Scenario Outline: Login to Sauce Labs with locked out user

    Given The user is in SwagLabs Login Page
    When User logs into application with the <username> and <password>
    Then The title of the page should be "Swag Labs".

    Examples:
      |username	                |password	    |
      |standard_user	        |secret_sauce	|
      |locked_out_user	        |secret_sauce	|
      |problem_user	            |secret_sauce	|
      |performance_glitch_user	|secret_sauce	|

