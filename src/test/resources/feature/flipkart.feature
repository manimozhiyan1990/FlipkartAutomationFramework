Feature: Flipkart Cart Validation


  @sanity
  Scenario Outline: Add multiple Products into the cart
    Given user navigate flipkart home page
    When user search "<product>"
    And user select variant of the product
    And user click add to cart
    And user enter the customer details
    Examples:
      | product |
      |Samsung Galaxy S25 FE 5G (Navy, 256 GB) |
#      | product |
#      | product |
#      | product |
#      | product |
#      | product |
#      | product |
#      | product |
#      | product |
#      | product |