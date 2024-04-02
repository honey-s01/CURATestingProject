Feature: Making an appointment - End to end
  Background:
    Given I am on the home page
    When I click on make appointment
    Then I should be on the login page

    When I enter "John Doe" as username
    And I enter "ThisIsNotAPassword" as password
    And I click login

    Then I should be on the appointment making page

  Scenario: Booking an appointment
    When I select "Tokyo CURA Healthcare Center" facility
    And I apply for hospital readmission
    And I select "Medicare" healthcare program
    And I enter "02/04/2024" date
    And I enter "I've made a comment" comment
    And I book appointment

    Then I should see appointment confirmation
    And I confirm details stored in the table
      | Facility             | Tokyo CURA Healthcare Center |
      | Hospital readmission | Yes                          |
      | Healthcare Program   | Medicare                     |
      | Visit Date           | 02/04/2024                   |
      | Comment              | I've made a comment          |

    And I logout