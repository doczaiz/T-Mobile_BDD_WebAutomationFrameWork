Feature: T-Mobile Home Page

  @SanityTest
  Scenario: User validates top navigate bar menus names
    Given user is on the T-Mobile homepage
    When user sees the T-Mobile logo
    And user sees top navigate menus
    Then user validates menus name


  @SanityTest
  Scenario Outline: User verify each top navigate bar menu items
    Given user is on the T-Mobile homepage
    When user sees the T-Mobile logo
    And user sees top navigate menus
    Then user validates menu items main menu <mainMenu>
#    Then user validates menu items side menu
    Examples:
      | mainMenu         |
      | Plans            |
      | Phones & devices |
      | Deals            |
      | Coverage         |
      | Join Us          |






