Feature: T-Mobile Shopping Cart Functionality

  @SanityTest
  Scenario Outline:User Adding a phone to the shopping cart on T-Mobile
    Given user is on the T-Mobile homepage
    When user sees the T-Mobile logo
    Then user clicks on search button
    And user enters name of phone "<product>"
    And user clicks on search submit button or clicks on enter
    Then user should be able to see the correct result "<product>"
    And user clicks on the desire product <product>
    Then user selects the color "<color>"
    Then user selects the storage size "<StorageSize>"
    Then user selects if existing or new customer
    And user selects to keep number or get a new number
    Then user selects to trade in or no trade in
    And user selects payment option
    Then user adds the the product to cart

    Examples:
      | product          | plan name        | color         | StorageSize |
      | iPhone 15        | Essentials Saver | Yellow        | 256GB       |
      | Galaxy S24       | Go5G Plus        | Cobalt Violet | 256GB       |
      | Galaxy S24 Ultra | Essentials       | Titanium Gray | 256GB       |
      | Galaxy S24+      |                  | Onyx Black    | 256GB       |
      | Pixel 8 Pro      |                  | Obsidian      | 128GB       |
      | iPhone 14 Pro    |                  | Silver        | 128GB       |

  @SanityTest
  Scenario Outline:User chooses a phone plan on T-Mobile
    Given user is on the T-Mobile homepage
    When user sees the T-Mobile logo
    Then user clicks on search button
    And user enters name of phone "<product>"
    And user clicks on search submit button or clicks on enter
    Then user should be able to see the correct result "<product>"
    And user clicks on the desire product <product>
    Then user selects the color "<color>"
    Then user selects the storage size "<StorageSize>"
    Then user selects if existing or new customer
    And user selects to keep number or get a new number
    Then user selects to trade in or no trade in
    And user selects payment option
    Then user adds the the product to cart
    Then user selects a phone plan "<planName>"


    Examples:
      | product   | color  | StorageSize | planName         |
      | iPhone 15 | Yellow | 512GB       | Essentials Saver |
      | iPhone 15 | Green  | 128GB       | Go5G Next        |
      | iPhone 15 | Pink   | 256GB       | Go5G             |
      | iPhone 15 | Black  | 512GB       | Essentials       |
      | iPhone 15 | Blue   | 512GB       | Essentials       |
