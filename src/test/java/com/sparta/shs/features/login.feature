Feature: Logging into the website
  Scenario: Navigating to the login page
    Given I am on the home page
    When I click on make appointment
    Then I should be on the login page

  Scenario: Logging in with valid credentials
    Given I am on the home page
    When I click on make appointment
    Then I should be on the login page

    When I enter "John Doe" as username
    And I enter "ThisIsNotAPassword" as password
    And I click login

    Then I should be on the appointment making page

  Scenario Outline: Logging in with invalid credentials
    Given I am on the home page
    When I click on make appointment
    Then I should be on the login page

    When I enter "<Username>" as username
    And I enter "<Password>" as password
    And I click login

    Then I should see a failed login message

    Examples: Invalid username and password
      | Username | Password        |
      | Doe John | ThisIsAPassword |

    Examples: Valid username
      | Username | Password        |
      | John Doe | ThisIsAPassword |

    Examples: Valid password
      | Username | Password           |
      | Doe John | ThisIsNotAPassword |