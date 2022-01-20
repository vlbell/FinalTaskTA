Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search field visibility
    And User checks sign in button visibility
    And User checks shopping bag button visibility
    When User opens shopping bag
    Then User checks empty bag title visibility

    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check for invalid input in the search field
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    Then User clicks search button
    And User checks that message saying that no results is shown

    Examples:
      | homePage              | keyword |
      | https://www.asos.com/ | e2er31d |

  Scenario Outline: Check correctly working filter
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User checks filter’s field visibility
    And User clicks 'SaleNewSeason' filter field
    And User clicks 'NewSeason' button
    Then User checks that current url contains '<filterWord>'

    Examples:
      | homePage              | filterWord | keyword |
      | https://www.asos.com/ | new_season | hat     |

  Scenario Outline: Check elements amount on search page
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by keyword '<searchWord>'
    And User clicks search button
    Then User checks that amount of products in search page are '<amountOfElements>'

    Examples:
      | homePage              | searchWord | amountOfElements |
      | https://www.asos.com/ | hat        | 72               |

  Scenario Outline: Check add product to cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks first product of search results
    And User clicks add to bag button on product
    And User checks that add to bag popup visible
    And User clicks main page button
    Then User checks that amount of products in shopping bag are '<amountOfProducts>'

    Examples:
      | homePage              | keyword | amountOfProducts |
      | https://www.asos.com/ | Scarf   | 1                |


  Scenario Outline: Check sale products
    Given User opens '<homePage>' page
    And User clicks Men button
    And User moves to Sale button
    And User checks Sale pop up visibility
    And User clicks Sale sunglasses button
    Then User checks sale products have saleIcon

    Examples:
      | homePage              |
      | https://www.asos.com/ |

  Scenario Outline: Check save button
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks Save button on five product
    And User clicks Saved items button
    Then User checks that amount of saved items are '<amountOfSavedItems>'

    Examples:
      | homePage              | keyword | amountOfSavedItems |
      | https://www.asos.com/ | tie     | 1 item             |

  Scenario Outline: Check that impossible to sign in with only incorrect email
    Given User opens '<homePage>' page
    And User clicks 'Sign In' button
    And User checks sign in popup visibility
    And User clicks 'Sign In' button at sign in popup
    And User checks email and password fields visibility
    When User enter '<wrongEmail>'
    And User clicks 'Sign In' button at sign in page
    Then User checks that email error is visible

    Examples:
      | homePage              | wrongEmail |
      | https://www.asos.com/ | wrongemail |

  Scenario Outline: Check that impossible to sign in without password
    Given User opens '<homePage>' page
    And User clicks 'Sign In' button
    And User clicks 'Sign In' button at sign in popup
    And User enter '<correctEmail>'
    And User clicks 'Sign In' button at sign in page
    Then User checks that password error is visible

    Examples:
      | homePage              | correctEmail      |
      | https://www.asos.com/ | example@gmail.com |

  Scenario Outline: Check that it is possible to reset the password
    Given User opens '<homePage>' page
    And User clicks 'Sign In' button
    And User clicks 'Sign In' button at sign in popup
    And User checks 'forgot password' button visibility
    And User clicks 'Forgot password'
    And User checks email field visibility
    And User checks 'reset password' button visibility

    Examples:
      | homePage              |
      | https://www.asos.com/ |

