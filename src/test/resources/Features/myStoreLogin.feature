Feature: To test login functionality of the page

  Scenario Outline: User is able to login with valid credentials
    Given the user is on home page
    When the user clicks on Sign In
    And enters valid <username> and <password>
    Then the user is logged in successfully

    Examples: 
      | username         | password |
      | test882@test.com |   123456 |
