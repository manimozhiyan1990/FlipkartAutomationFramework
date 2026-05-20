Feature: Flipkart Cart Validation


  @sanity
  Scenario Outline: Add multiple Brand Mobiles into the cart
    Given user navigate flipkart home page
    When user search "<product>"
    And user select variant if available
    And user click add to cart
    And user enter the customer details
    Examples:
      | product|
      |   1    |
      |   2    |
      |   3    |
      |   4    |
      |   5    |
      |   6    |
      |   7    |
      |   8    |
      |   9    |
      |   10   |