Feature: T-Mobile Search Functionality

  @SanityTest
  Scenario Outline: Searching for a specific phone by module
    Given user is on the T-Mobile homepage
    When user sees the T-Mobile logo
    Then user clicks on search button
    And user enters name of phone "<product>"
    And user clicks on search submit button or clicks on enter
    Then user should be able to see the correct result "<product>"
    Examples:
      | product       |
      | iPhone 12 Pro |
      | iPhone 15     |
      | razr+ 2023    |
      | G310 5G       |
      | Galaxy S24    |
      | Pixel 8 Pro   |

  @SanityTest
  Scenario Outline: Searching for a specific phone by brand plus module
    Given user is on the T-Mobile homepage
    When user sees the T-Mobile logo
    Then user clicks on search button
    And user enters name of phone "<brand>" and model "<model>"
    And user clicks on search submit button or clicks on enter
    Then user should sees the correct result containing the brand "<brand>" and module "<model>"
    Examples:
      | brand    | model         |
      | Apple    | iPhone 12 Pro |
      | Motorola | edge 2022     |
      | Samsung  | Galaxy S24    |
      | Google   | Pixel 8 Pro   |


  @SanityTest
  Scenario Outline: Searching for a key word
    Given user is on the T-Mobile homepage
    When user sees the T-Mobile logo
    Then user clicks on search button
    And user enters name of phone "<keyWord>"
    And user clicks on search submit button or clicks on enter
    Then user should be able to see accurate result with keyword "<keyWord>"
    Examples:
      | keyWord   |
      | Delta     |
      | kids      |
      | tracker   |
      | bill      |
      | promotion |
      | update    |