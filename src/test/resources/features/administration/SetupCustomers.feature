Feature: Setup Customers

  Background: Login to system and navigate to Administration/Customers page
    Given User logs in into system
    And User navigates to ADMIN_CUSTOMER page

  Scenario: Verify that user can add new customer by [+] button
    When User click 'Add new customer' on Administration/Customers Page
    Then Customers modal is visible on Administration Customers Page

  Scenario: Verify that user can decline creating new customer
    When User click 'Add new customer' on Administration/Customers Page
    And User click 'Abort Create new Customer' on Administration/Customers Page
    Then Customers modal is not visible on Administration Customers Page

  Scenario: Verify that user can navigate thru pages with customers
    When User click '2' page number on Administration/Customers Page
    Then Page number '2' is active on Administration/Customers Page
    When User click '3' page number on Administration/Customers Page
    Then Page number '3' is active on Administration/Customers Page
    When User click '4' page number on Administration/Customers Page
    Then Page number '4' is active on Administration/Customers Page
    When User click '5' page number on Administration/Customers Page
    Then Page number '5' is active on Administration/Customers Page




